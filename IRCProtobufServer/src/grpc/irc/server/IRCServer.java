/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grpc.irc.server;

import grpc.irc.Boolean;
import grpc.irc.Chat;
import grpc.irc.IRCChannel;
import grpc.irc.IRCResponse;
import grpc.irc.IRCServiceGrpc;
import grpc.irc.IRCUser;
import grpc.irc.Membership;
import io.grpc.ServerImpl;
import io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author ndro.tb
 */
public class IRCServer {
    private static final Logger logger = Logger.getLogger(IRCServer.class.getName());

    private final int port;
    private ServerImpl server;
    
    public static List<String> channelList = new ArrayList<>();
    public static List<ChatUser> userList = new ArrayList<>();

    public IRCServer(int port) {
        this.port = port;
    }

    /** Start serving requests. */
    public void start() throws IOException {
        server = NettyServerBuilder.forPort(port)
            .addService(IRCServiceGrpc.bindService(new IRCServiceImpl()))
            .build()
            .start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
          @Override
          public void run() {
            // Use stderr here since the logger may has been reset by its JVM shutdown hook.
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            IRCServer.this.stop();
            System.err.println("*** server shut down");
          }
        });
    }

    /** Stop serving requests and shutdown resources. */
    public void stop() {
        if (server != null) {
          server.shutdown();
        }
    }

    /**
    * Await termination on the main thread since the grpc library uses daemon threads.
    */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
          server.awaitTermination();
        }
    }

    /**
    * Main method.  This comment makes the linter happy.
    */
    public static void main(String[] args) throws Exception {
        IRCServer server = new IRCServer(50051);
        server.start();
        server.blockUntilShutdown();
    }
    
    private class IRCServiceImpl implements IRCServiceGrpc.IRCService {

        @Override
        public void nickname(IRCUser request, StreamObserver<IRCResponse> responseObserver) {
            ChatUser new_member = new ChatUser();
            new_member.setUsername(request.getUsername());
            userList.add(new_member);
            System.out.println(request.getUsername() + " is signing in to server");
            for(ChatUser member : userList)
            {
                System.out.println(member.getUsername());
            }
            
            IRCResponse reply = IRCResponse.newBuilder().setResponse(request.getUsername()).build();
            responseObserver.onValue(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void join(Membership request, StreamObserver<IRCResponse> responseObserver) {
            if(!checkChannel(request.getChannelname())) {
                createChannel(request.getChannelname());
            }

            int index = searchMember(request.getUsername());
            userList.get(index).addMembership(request.getChannelname());

            IRCResponse reply = IRCResponse.newBuilder().setResponse(request.getChannelname()).build();
            responseObserver.onValue(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void leave(Membership request, StreamObserver<IRCResponse> responseObserver) {
            int index = searchMember(request.getUsername());
            userList.get(index).leaveGroup(request.getChannelname());
            System.out.println(request.getUsername()+ " left channel "+request.getChannelname());
        
            IRCResponse reply = IRCResponse.newBuilder().setResponse(request.getChannelname()).build();
            responseObserver.onValue(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void exit(IRCUser request, StreamObserver<IRCResponse> responseObserver) {
            int index = searchMember(request.getUsername());
        
            for(int i=0; i<userList.get(index).getMembership().size(); i++) {
                System.out.println(userList.get(index).getMembership().get(i));
            }
            userList.remove(index);
            System.out.println(request.getUsername()+" exit from application");
            
            IRCResponse reply = IRCResponse.newBuilder().setResponse("Aplication closed successfully").build();
            responseObserver.onValue(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void sendMessage(Chat request, StreamObserver<IRCResponse> responseObserver) {
            ChatMessage msg = new ChatMessage();
            msg.setMessage(request.getText());
            msg.setStatus(false);
            msg.setSender(request.getUsername());
            msg.setChannel(request.getChannelname());
            if(!request.getChannelname().equals("")) {
                for (ChatUser user : userList) {
                    distributeMessage(user.getUsername(), request.getChannelname(), msg);
                }
            }
            else {
                sendAll(request.getUsername(), msg);
            }
            System.out.println(request.getUsername()+" is sending message");
            System.out.println(request.getText());
            
            IRCResponse reply = IRCResponse.newBuilder().setResponse("Message Sent").build();
            responseObserver.onValue(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void receiveMessage(Chat request, StreamObserver<IRCResponse> responseObserver) {
            ChatMessage retrieve = retrieveMessage(request.getUsername());
            String message = retrieve.getMessage();
            String sender = retrieve.getSender();
            String channelMsg = retrieve.getChannel();
            if(message == null || sender == null) {
                message = "No unread message";
            }
            else {
                message = "[" + channelMsg + "]("+sender + ") : " + message;
            }
            System.out.println("The message is "+message);
            
            IRCResponse reply = IRCResponse.newBuilder().setResponse(message).build();
            responseObserver.onValue(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void checkChannel(IRCChannel request, StreamObserver<Boolean> responseObserver) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void createChannel(IRCChannel request, StreamObserver<IRCResponse> responseObserver) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
        /** Create new method */
        public boolean checkChannel(String channelname) {
            boolean found = false;
            int i = 0;

            while(i<channelList.size() && !found) {
                String temp = channelList.get(i);
                if(temp.equals(channelname)) {
                    found = true;
                    System.out.println("Channel "+channelname+" is exist");
                }
                i++;
            }
            return found;
        }

        public void createChannel(String channelname) {

            channelList.add(channelname);
            System.out.println("Channel " + channelname + " is created");
        }

        public int searchMember(String username) {

            int i = 0;
            boolean found = false;
            int index = 0;

            while(i<userList.size() && !found) {
                String temp = userList.get(i).getUsername();
                if(temp!=null) {
                    if(temp.equals(username)) {
                        index = i;
                        found = true;
                    }
                }
            i++;    
            }
            return index;
        }
        
        public boolean isMember(String username, String channel) {
        
            boolean member = false;
            int index = searchMember(username);
            List<String> temp = userList.get(index).getMembership();

            int i = 0;
            while(i<temp.size() && !member) {
                if(temp.get(i).equals(channel)) {
                    member = true;
                }
                i++;
            }
            return member;
        }
        
        public void distributeMessage(String username, String channel, ChatMessage chat) {

            int index = searchMember(username);
            if(isMember(username, channel)) {
                userList.get(index).addMessage(chat);
                System.out.println("Message is sent to "+ username);
            }
        }

        public void sendAll(String username, ChatMessage chat) {

            int index = searchMember(username);
            List<String> membership = userList.get(index).getMembership();
            for(String channel : membership) {
                for(ChatUser user : userList) {
                    chat.setChannel(channel);
                    distributeMessage(user.getUsername(), channel, chat);
                }
            }
        }
        
        public ChatMessage retrieveMessage(String username) {
        
            int index = searchMember(username);
            int unread = 0;
            List<ChatMessage> inbox = userList.get(index).getInbox();

            ChatMessage message = new ChatMessage();
            if(!inbox.isEmpty()) {
                message = inbox.get(unread);
                inbox.get(unread).setStatus(true);
                userList.get(index).deleteMessage();
            }
            return message;
        }
    }
}
