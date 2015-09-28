package grpc.irc;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;

@javax.annotation.Generated("by gRPC proto compiler")
public class IRCServiceGrpc {

  // Static method descriptors that strictly reflect the proto.
  public static final io.grpc.MethodDescriptor<grpc.irc.IRCUser,
      grpc.irc.IRCResponse> METHOD_NICKNAME =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          "irc.IRCService", "nickname",
          io.grpc.protobuf.ProtoUtils.marshaller(grpc.irc.IRCUser.parser()),
          io.grpc.protobuf.ProtoUtils.marshaller(grpc.irc.IRCResponse.parser()));
  public static final io.grpc.MethodDescriptor<grpc.irc.Membership,
      grpc.irc.IRCResponse> METHOD_JOIN =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          "irc.IRCService", "join",
          io.grpc.protobuf.ProtoUtils.marshaller(grpc.irc.Membership.parser()),
          io.grpc.protobuf.ProtoUtils.marshaller(grpc.irc.IRCResponse.parser()));
  public static final io.grpc.MethodDescriptor<grpc.irc.Membership,
      grpc.irc.IRCResponse> METHOD_LEAVE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          "irc.IRCService", "leave",
          io.grpc.protobuf.ProtoUtils.marshaller(grpc.irc.Membership.parser()),
          io.grpc.protobuf.ProtoUtils.marshaller(grpc.irc.IRCResponse.parser()));
  public static final io.grpc.MethodDescriptor<grpc.irc.IRCUser,
      grpc.irc.IRCResponse> METHOD_EXIT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          "irc.IRCService", "exit",
          io.grpc.protobuf.ProtoUtils.marshaller(grpc.irc.IRCUser.parser()),
          io.grpc.protobuf.ProtoUtils.marshaller(grpc.irc.IRCResponse.parser()));
  public static final io.grpc.MethodDescriptor<grpc.irc.Chat,
      grpc.irc.IRCResponse> METHOD_SEND_MESSAGE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          "irc.IRCService", "sendMessage",
          io.grpc.protobuf.ProtoUtils.marshaller(grpc.irc.Chat.parser()),
          io.grpc.protobuf.ProtoUtils.marshaller(grpc.irc.IRCResponse.parser()));
  public static final io.grpc.MethodDescriptor<grpc.irc.Chat,
      grpc.irc.IRCResponse> METHOD_RECEIVE_MESSAGE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          "irc.IRCService", "receiveMessage",
          io.grpc.protobuf.ProtoUtils.marshaller(grpc.irc.Chat.parser()),
          io.grpc.protobuf.ProtoUtils.marshaller(grpc.irc.IRCResponse.parser()));
  public static final io.grpc.MethodDescriptor<grpc.irc.IRCChannel,
      grpc.irc.Boolean> METHOD_CHECK_CHANNEL =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          "irc.IRCService", "checkChannel",
          io.grpc.protobuf.ProtoUtils.marshaller(grpc.irc.IRCChannel.parser()),
          io.grpc.protobuf.ProtoUtils.marshaller(grpc.irc.Boolean.parser()));
  public static final io.grpc.MethodDescriptor<grpc.irc.IRCChannel,
      grpc.irc.IRCResponse> METHOD_CREATE_CHANNEL =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          "irc.IRCService", "createChannel",
          io.grpc.protobuf.ProtoUtils.marshaller(grpc.irc.IRCChannel.parser()),
          io.grpc.protobuf.ProtoUtils.marshaller(grpc.irc.IRCResponse.parser()));

  public static IRCServiceStub newStub(io.grpc.Channel channel) {
    return new IRCServiceStub(channel);
  }

  public static IRCServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new IRCServiceBlockingStub(channel);
  }

  public static IRCServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new IRCServiceFutureStub(channel);
  }

  public static interface IRCService {

    public void nickname(grpc.irc.IRCUser request,
        io.grpc.stub.StreamObserver<grpc.irc.IRCResponse> responseObserver);

    public void join(grpc.irc.Membership request,
        io.grpc.stub.StreamObserver<grpc.irc.IRCResponse> responseObserver);

    public void leave(grpc.irc.Membership request,
        io.grpc.stub.StreamObserver<grpc.irc.IRCResponse> responseObserver);

    public void exit(grpc.irc.IRCUser request,
        io.grpc.stub.StreamObserver<grpc.irc.IRCResponse> responseObserver);

    public void sendMessage(grpc.irc.Chat request,
        io.grpc.stub.StreamObserver<grpc.irc.IRCResponse> responseObserver);

    public void receiveMessage(grpc.irc.Chat request,
        io.grpc.stub.StreamObserver<grpc.irc.IRCResponse> responseObserver);

    public void checkChannel(grpc.irc.IRCChannel request,
        io.grpc.stub.StreamObserver<grpc.irc.Boolean> responseObserver);

    public void createChannel(grpc.irc.IRCChannel request,
        io.grpc.stub.StreamObserver<grpc.irc.IRCResponse> responseObserver);
  }

  public static interface IRCServiceBlockingClient {

    public grpc.irc.IRCResponse nickname(grpc.irc.IRCUser request);

    public grpc.irc.IRCResponse join(grpc.irc.Membership request);

    public grpc.irc.IRCResponse leave(grpc.irc.Membership request);

    public grpc.irc.IRCResponse exit(grpc.irc.IRCUser request);

    public grpc.irc.IRCResponse sendMessage(grpc.irc.Chat request);

    public grpc.irc.IRCResponse receiveMessage(grpc.irc.Chat request);

    public grpc.irc.Boolean checkChannel(grpc.irc.IRCChannel request);

    public grpc.irc.IRCResponse createChannel(grpc.irc.IRCChannel request);
  }

  public static interface IRCServiceFutureClient {

    public com.google.common.util.concurrent.ListenableFuture<grpc.irc.IRCResponse> nickname(
        grpc.irc.IRCUser request);

    public com.google.common.util.concurrent.ListenableFuture<grpc.irc.IRCResponse> join(
        grpc.irc.Membership request);

    public com.google.common.util.concurrent.ListenableFuture<grpc.irc.IRCResponse> leave(
        grpc.irc.Membership request);

    public com.google.common.util.concurrent.ListenableFuture<grpc.irc.IRCResponse> exit(
        grpc.irc.IRCUser request);

    public com.google.common.util.concurrent.ListenableFuture<grpc.irc.IRCResponse> sendMessage(
        grpc.irc.Chat request);

    public com.google.common.util.concurrent.ListenableFuture<grpc.irc.IRCResponse> receiveMessage(
        grpc.irc.Chat request);

    public com.google.common.util.concurrent.ListenableFuture<grpc.irc.Boolean> checkChannel(
        grpc.irc.IRCChannel request);

    public com.google.common.util.concurrent.ListenableFuture<grpc.irc.IRCResponse> createChannel(
        grpc.irc.IRCChannel request);
  }

  public static class IRCServiceStub extends io.grpc.stub.AbstractStub<IRCServiceStub>
      implements IRCService {
    private IRCServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private IRCServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IRCServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new IRCServiceStub(channel, callOptions);
    }

    @java.lang.Override
    public void nickname(grpc.irc.IRCUser request,
        io.grpc.stub.StreamObserver<grpc.irc.IRCResponse> responseObserver) {
      asyncUnaryCall(
          channel.newCall(METHOD_NICKNAME, callOptions), request, responseObserver);
    }

    @java.lang.Override
    public void join(grpc.irc.Membership request,
        io.grpc.stub.StreamObserver<grpc.irc.IRCResponse> responseObserver) {
      asyncUnaryCall(
          channel.newCall(METHOD_JOIN, callOptions), request, responseObserver);
    }

    @java.lang.Override
    public void leave(grpc.irc.Membership request,
        io.grpc.stub.StreamObserver<grpc.irc.IRCResponse> responseObserver) {
      asyncUnaryCall(
          channel.newCall(METHOD_LEAVE, callOptions), request, responseObserver);
    }

    @java.lang.Override
    public void exit(grpc.irc.IRCUser request,
        io.grpc.stub.StreamObserver<grpc.irc.IRCResponse> responseObserver) {
      asyncUnaryCall(
          channel.newCall(METHOD_EXIT, callOptions), request, responseObserver);
    }

    @java.lang.Override
    public void sendMessage(grpc.irc.Chat request,
        io.grpc.stub.StreamObserver<grpc.irc.IRCResponse> responseObserver) {
      asyncUnaryCall(
          channel.newCall(METHOD_SEND_MESSAGE, callOptions), request, responseObserver);
    }

    @java.lang.Override
    public void receiveMessage(grpc.irc.Chat request,
        io.grpc.stub.StreamObserver<grpc.irc.IRCResponse> responseObserver) {
      asyncUnaryCall(
          channel.newCall(METHOD_RECEIVE_MESSAGE, callOptions), request, responseObserver);
    }

    @java.lang.Override
    public void checkChannel(grpc.irc.IRCChannel request,
        io.grpc.stub.StreamObserver<grpc.irc.Boolean> responseObserver) {
      asyncUnaryCall(
          channel.newCall(METHOD_CHECK_CHANNEL, callOptions), request, responseObserver);
    }

    @java.lang.Override
    public void createChannel(grpc.irc.IRCChannel request,
        io.grpc.stub.StreamObserver<grpc.irc.IRCResponse> responseObserver) {
      asyncUnaryCall(
          channel.newCall(METHOD_CREATE_CHANNEL, callOptions), request, responseObserver);
    }
  }

  public static class IRCServiceBlockingStub extends io.grpc.stub.AbstractStub<IRCServiceBlockingStub>
      implements IRCServiceBlockingClient {
    private IRCServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private IRCServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IRCServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new IRCServiceBlockingStub(channel, callOptions);
    }

    @java.lang.Override
    public grpc.irc.IRCResponse nickname(grpc.irc.IRCUser request) {
      return blockingUnaryCall(
          channel.newCall(METHOD_NICKNAME, callOptions), request);
    }

    @java.lang.Override
    public grpc.irc.IRCResponse join(grpc.irc.Membership request) {
      return blockingUnaryCall(
          channel.newCall(METHOD_JOIN, callOptions), request);
    }

    @java.lang.Override
    public grpc.irc.IRCResponse leave(grpc.irc.Membership request) {
      return blockingUnaryCall(
          channel.newCall(METHOD_LEAVE, callOptions), request);
    }

    @java.lang.Override
    public grpc.irc.IRCResponse exit(grpc.irc.IRCUser request) {
      return blockingUnaryCall(
          channel.newCall(METHOD_EXIT, callOptions), request);
    }

    @java.lang.Override
    public grpc.irc.IRCResponse sendMessage(grpc.irc.Chat request) {
      return blockingUnaryCall(
          channel.newCall(METHOD_SEND_MESSAGE, callOptions), request);
    }

    @java.lang.Override
    public grpc.irc.IRCResponse receiveMessage(grpc.irc.Chat request) {
      return blockingUnaryCall(
          channel.newCall(METHOD_RECEIVE_MESSAGE, callOptions), request);
    }

    @java.lang.Override
    public grpc.irc.Boolean checkChannel(grpc.irc.IRCChannel request) {
      return blockingUnaryCall(
          channel.newCall(METHOD_CHECK_CHANNEL, callOptions), request);
    }

    @java.lang.Override
    public grpc.irc.IRCResponse createChannel(grpc.irc.IRCChannel request) {
      return blockingUnaryCall(
          channel.newCall(METHOD_CREATE_CHANNEL, callOptions), request);
    }
  }

  public static class IRCServiceFutureStub extends io.grpc.stub.AbstractStub<IRCServiceFutureStub>
      implements IRCServiceFutureClient {
    private IRCServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private IRCServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IRCServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new IRCServiceFutureStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<grpc.irc.IRCResponse> nickname(
        grpc.irc.IRCUser request) {
      return futureUnaryCall(
          channel.newCall(METHOD_NICKNAME, callOptions), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<grpc.irc.IRCResponse> join(
        grpc.irc.Membership request) {
      return futureUnaryCall(
          channel.newCall(METHOD_JOIN, callOptions), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<grpc.irc.IRCResponse> leave(
        grpc.irc.Membership request) {
      return futureUnaryCall(
          channel.newCall(METHOD_LEAVE, callOptions), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<grpc.irc.IRCResponse> exit(
        grpc.irc.IRCUser request) {
      return futureUnaryCall(
          channel.newCall(METHOD_EXIT, callOptions), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<grpc.irc.IRCResponse> sendMessage(
        grpc.irc.Chat request) {
      return futureUnaryCall(
          channel.newCall(METHOD_SEND_MESSAGE, callOptions), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<grpc.irc.IRCResponse> receiveMessage(
        grpc.irc.Chat request) {
      return futureUnaryCall(
          channel.newCall(METHOD_RECEIVE_MESSAGE, callOptions), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<grpc.irc.Boolean> checkChannel(
        grpc.irc.IRCChannel request) {
      return futureUnaryCall(
          channel.newCall(METHOD_CHECK_CHANNEL, callOptions), request);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<grpc.irc.IRCResponse> createChannel(
        grpc.irc.IRCChannel request) {
      return futureUnaryCall(
          channel.newCall(METHOD_CREATE_CHANNEL, callOptions), request);
    }
  }

  public static io.grpc.ServerServiceDefinition bindService(
      final IRCService serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder("irc.IRCService")
      .addMethod(io.grpc.ServerMethodDefinition.create(
          METHOD_NICKNAME,
          asyncUnaryCall(
            new io.grpc.stub.ServerCalls.UnaryMethod<
                grpc.irc.IRCUser,
                grpc.irc.IRCResponse>() {
              @java.lang.Override
              public void invoke(
                  grpc.irc.IRCUser request,
                  io.grpc.stub.StreamObserver<grpc.irc.IRCResponse> responseObserver) {
                serviceImpl.nickname(request, responseObserver);
              }
            })))
      .addMethod(io.grpc.ServerMethodDefinition.create(
          METHOD_JOIN,
          asyncUnaryCall(
            new io.grpc.stub.ServerCalls.UnaryMethod<
                grpc.irc.Membership,
                grpc.irc.IRCResponse>() {
              @java.lang.Override
              public void invoke(
                  grpc.irc.Membership request,
                  io.grpc.stub.StreamObserver<grpc.irc.IRCResponse> responseObserver) {
                serviceImpl.join(request, responseObserver);
              }
            })))
      .addMethod(io.grpc.ServerMethodDefinition.create(
          METHOD_LEAVE,
          asyncUnaryCall(
            new io.grpc.stub.ServerCalls.UnaryMethod<
                grpc.irc.Membership,
                grpc.irc.IRCResponse>() {
              @java.lang.Override
              public void invoke(
                  grpc.irc.Membership request,
                  io.grpc.stub.StreamObserver<grpc.irc.IRCResponse> responseObserver) {
                serviceImpl.leave(request, responseObserver);
              }
            })))
      .addMethod(io.grpc.ServerMethodDefinition.create(
          METHOD_EXIT,
          asyncUnaryCall(
            new io.grpc.stub.ServerCalls.UnaryMethod<
                grpc.irc.IRCUser,
                grpc.irc.IRCResponse>() {
              @java.lang.Override
              public void invoke(
                  grpc.irc.IRCUser request,
                  io.grpc.stub.StreamObserver<grpc.irc.IRCResponse> responseObserver) {
                serviceImpl.exit(request, responseObserver);
              }
            })))
      .addMethod(io.grpc.ServerMethodDefinition.create(
          METHOD_SEND_MESSAGE,
          asyncUnaryCall(
            new io.grpc.stub.ServerCalls.UnaryMethod<
                grpc.irc.Chat,
                grpc.irc.IRCResponse>() {
              @java.lang.Override
              public void invoke(
                  grpc.irc.Chat request,
                  io.grpc.stub.StreamObserver<grpc.irc.IRCResponse> responseObserver) {
                serviceImpl.sendMessage(request, responseObserver);
              }
            })))
      .addMethod(io.grpc.ServerMethodDefinition.create(
          METHOD_RECEIVE_MESSAGE,
          asyncUnaryCall(
            new io.grpc.stub.ServerCalls.UnaryMethod<
                grpc.irc.Chat,
                grpc.irc.IRCResponse>() {
              @java.lang.Override
              public void invoke(
                  grpc.irc.Chat request,
                  io.grpc.stub.StreamObserver<grpc.irc.IRCResponse> responseObserver) {
                serviceImpl.receiveMessage(request, responseObserver);
              }
            })))
      .addMethod(io.grpc.ServerMethodDefinition.create(
          METHOD_CHECK_CHANNEL,
          asyncUnaryCall(
            new io.grpc.stub.ServerCalls.UnaryMethod<
                grpc.irc.IRCChannel,
                grpc.irc.Boolean>() {
              @java.lang.Override
              public void invoke(
                  grpc.irc.IRCChannel request,
                  io.grpc.stub.StreamObserver<grpc.irc.Boolean> responseObserver) {
                serviceImpl.checkChannel(request, responseObserver);
              }
            })))
      .addMethod(io.grpc.ServerMethodDefinition.create(
          METHOD_CREATE_CHANNEL,
          asyncUnaryCall(
            new io.grpc.stub.ServerCalls.UnaryMethod<
                grpc.irc.IRCChannel,
                grpc.irc.IRCResponse>() {
              @java.lang.Override
              public void invoke(
                  grpc.irc.IRCChannel request,
                  io.grpc.stub.StreamObserver<grpc.irc.IRCResponse> responseObserver) {
                serviceImpl.createChannel(request, responseObserver);
              }
            }))).build();
  }
}
