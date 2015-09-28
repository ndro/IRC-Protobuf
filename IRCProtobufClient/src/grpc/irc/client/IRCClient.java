/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grpc.irc.client;

import grpc.irc.*;
import io.grpc.ChannelImpl;
import io.grpc.netty.NegotiationType;
import io.grpc.netty.NettyChannelBuilder;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ndro.tb
 */
public class IRCClient {
    private static final Logger logger = Logger.getLogger(IRCClient.class.getName());

    private final ChannelImpl channel;
    private static IRCServiceGrpc.IRCServiceBlockingStub blockingStub;
    private static IRCClient client;
    private static boolean isOnline = true;
    private static IRCUser username;

    /** Construct client connecting to HelloWorld server at {@code host:port}. */
    public IRCClient(String host, int port) {
        channel =
            NettyChannelBuilder.forAddress(host, port).negotiationType(NegotiationType.PLAINTEXT)
                .build();
        blockingStub = IRCServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /**
    * Greet server. If provided, the first element of {@code args} is the name to use in the
    * greeting.
    */
    public static void main(String[] args) throws Exception {
        client = new IRCClient("localhost", 50051);
        Scanner in = new Scanner(System.in);
        
        try {
          /* Access a service running on the local machine on port 50051 */
            while(isOnline) {
                String test = in.nextLine().toLowerCase();
                client.processRequest(test);
            }

        } finally {
            client.shutdown();
        }
    }
    
    public static void processRequest(String req) throws InterruptedException {
        String[] input = req.split(" ");
        
        if(input[0].equals("/nick")) {
            getNickname(input[1]);
        }
        else if(input[0].equals("/join")) {
            joinChannel(input[1]);
        }
        else if(input[0].equals("/leave")) {
            leaveChannel(input[1]);
        }
        else if(input[0].equals("/exit")) {
            exitApp();
            isOnline = false;
        }
        else if(input[0].contains("@")) {
            String channel = input[0].substring(1);
            String chat = "";
            for(int i=1; i<input.length; i++) {
                chat+=input[i]+" ";
            }
            sendChat(chat, channel);
        }
        else if(input[0].equals("get")) {
            receiveChat();
        }
        else {
            String channel = "";
            String chat = "";
            for(int i=0; i<input.length; i++) {
                chat+=input[i]+" ";
            }
            sendChat( chat, channel);
        }
    }
    
    //request for nickname
    public static void getNickname(String name) {
        
        username = IRCUser.newBuilder().setUsername(name).build();
        IRCResponse response = blockingStub.nickname(username);
        System.out.println("Your nickname is : " + response.getResponse());
    }
    
    public static void joinChannel(String channel){
        
        Membership member = Membership.newBuilder()
                            .setChannelname(channel)
                            .setUsername(username.getUsername())
                            .build();
        IRCResponse response = blockingStub.join(member);
        
        System.out.println("You are member of channel " + response.getResponse());
    }
    
    public static void leaveChannel(String channel) {
        
        Membership member = Membership.newBuilder()
                            .setChannelname(channel)
                            .setUsername(username.getUsername())
                            .build();
        IRCResponse response = blockingStub.leave(member);
        
        System.out.println("You left from "+ response.getResponse() + " channel");
    }
    
    public static void exitApp () throws InterruptedException {
        
        IRCResponse response = blockingStub.exit(username);
        System.out.println(response.getResponse());
        client.shutdown();
    }
    
    public static void sendChat(String text, String channel) {
        
        Chat chat = Chat.newBuilder()
                    .setChannelname(channel)
                    .setText(text)
                    .setUsername(username.getUsername())
                    .build();
        IRCResponse response = blockingStub.sendMessage(chat);
        System.out.println(response.getResponse());
    }
    
    public static void receiveChat(){
        
        Chat chat = Chat.newBuilder()
                    .setUsername(username.getUsername())
                    .build();
        IRCResponse response = blockingStub.receiveMessage(chat);
        System.out.println(response.getResponse());
    }
}
