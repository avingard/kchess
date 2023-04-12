import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.53.0)",
    comments = "Source: chess.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ChessGameGrpc {

  private ChessGameGrpc() {}

  public static final String SERVICE_NAME = "ChessGame";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<MoveRequest,
      com.google.protobuf.Empty> getMoveToMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MoveTo",
      requestType = MoveRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<MoveRequest,
      com.google.protobuf.Empty> getMoveToMethod() {
    io.grpc.MethodDescriptor<MoveRequest, com.google.protobuf.Empty> getMoveToMethod;
    if ((getMoveToMethod = ChessGameGrpc.getMoveToMethod) == null) {
      synchronized (ChessGameGrpc.class) {
        if ((getMoveToMethod = ChessGameGrpc.getMoveToMethod) == null) {
          ChessGameGrpc.getMoveToMethod = getMoveToMethod =
              io.grpc.MethodDescriptor.<MoveRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MoveTo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  MoveRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ChessGameMethodDescriptorSupplier("MoveTo"))
              .build();
        }
      }
    }
    return getMoveToMethod;
  }

  private static volatile io.grpc.MethodDescriptor<GameRequest,
      GameEvent> getGameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Game",
      requestType = GameRequest.class,
      responseType = GameEvent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<GameRequest,
      GameEvent> getGameMethod() {
    io.grpc.MethodDescriptor<GameRequest, GameEvent> getGameMethod;
    if ((getGameMethod = ChessGameGrpc.getGameMethod) == null) {
      synchronized (ChessGameGrpc.class) {
        if ((getGameMethod = ChessGameGrpc.getGameMethod) == null) {
          ChessGameGrpc.getGameMethod = getGameMethod =
              io.grpc.MethodDescriptor.<GameRequest, GameEvent>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Game"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GameEvent.getDefaultInstance()))
              .setSchemaDescriptor(new ChessGameMethodDescriptorSupplier("Game"))
              .build();
        }
      }
    }
    return getGameMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChessGameStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChessGameStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChessGameStub>() {
        @java.lang.Override
        public ChessGameStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChessGameStub(channel, callOptions);
        }
      };
    return ChessGameStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChessGameBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChessGameBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChessGameBlockingStub>() {
        @java.lang.Override
        public ChessGameBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChessGameBlockingStub(channel, callOptions);
        }
      };
    return ChessGameBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChessGameFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChessGameFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChessGameFutureStub>() {
        @java.lang.Override
        public ChessGameFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChessGameFutureStub(channel, callOptions);
        }
      };
    return ChessGameFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ChessGameImplBase implements io.grpc.BindableService {

    /**
     */
    public void moveTo(MoveRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMoveToMethod(), responseObserver);
    }

    /**
     */
    public void game(GameRequest request,
        io.grpc.stub.StreamObserver<GameEvent> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGameMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getMoveToMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                MoveRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_MOVE_TO)))
          .addMethod(
            getGameMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                GameRequest,
                GameEvent>(
                  this, METHODID_GAME)))
          .build();
    }
  }

  /**
   */
  public static final class ChessGameStub extends io.grpc.stub.AbstractAsyncStub<ChessGameStub> {
    private ChessGameStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChessGameStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChessGameStub(channel, callOptions);
    }

    /**
     */
    public void moveTo(MoveRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMoveToMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void game(GameRequest request,
        io.grpc.stub.StreamObserver<GameEvent> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGameMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ChessGameBlockingStub extends io.grpc.stub.AbstractBlockingStub<ChessGameBlockingStub> {
    private ChessGameBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChessGameBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChessGameBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Empty moveTo(MoveRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMoveToMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<GameEvent> game(
        GameRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGameMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ChessGameFutureStub extends io.grpc.stub.AbstractFutureStub<ChessGameFutureStub> {
    private ChessGameFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChessGameFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChessGameFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> moveTo(
        MoveRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMoveToMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_MOVE_TO = 0;
  private static final int METHODID_GAME = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChessGameImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChessGameImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MOVE_TO:
          serviceImpl.moveTo((MoveRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GAME:
          serviceImpl.game((GameRequest) request,
              (io.grpc.stub.StreamObserver<GameEvent>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ChessGameBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChessGameBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Chess.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ChessGame");
    }
  }

  private static final class ChessGameFileDescriptorSupplier
      extends ChessGameBaseDescriptorSupplier {
    ChessGameFileDescriptorSupplier() {}
  }

  private static final class ChessGameMethodDescriptorSupplier
      extends ChessGameBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChessGameMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ChessGameGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChessGameFileDescriptorSupplier())
              .addMethod(getMoveToMethod())
              .addMethod(getGameMethod())
              .build();
        }
      }
    }
    return result;
  }
}
