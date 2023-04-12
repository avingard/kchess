import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.53.0)",
    comments = "Source: player.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MatchMakingGrpc {

  private MatchMakingGrpc() {}

  public static final String SERVICE_NAME = "MatchMaking";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<PlayerInvite,
      com.google.protobuf.Empty> getInviteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Invite",
      requestType = PlayerInvite.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<PlayerInvite,
      com.google.protobuf.Empty> getInviteMethod() {
    io.grpc.MethodDescriptor<PlayerInvite, com.google.protobuf.Empty> getInviteMethod;
    if ((getInviteMethod = MatchMakingGrpc.getInviteMethod) == null) {
      synchronized (MatchMakingGrpc.class) {
        if ((getInviteMethod = MatchMakingGrpc.getInviteMethod) == null) {
          MatchMakingGrpc.getInviteMethod = getInviteMethod =
              io.grpc.MethodDescriptor.<PlayerInvite, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Invite"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  PlayerInvite.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new MatchMakingMethodDescriptorSupplier("Invite"))
              .build();
        }
      }
    }
    return getInviteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MatchMakingStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MatchMakingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MatchMakingStub>() {
        @java.lang.Override
        public MatchMakingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MatchMakingStub(channel, callOptions);
        }
      };
    return MatchMakingStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MatchMakingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MatchMakingBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MatchMakingBlockingStub>() {
        @java.lang.Override
        public MatchMakingBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MatchMakingBlockingStub(channel, callOptions);
        }
      };
    return MatchMakingBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MatchMakingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MatchMakingFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MatchMakingFutureStub>() {
        @java.lang.Override
        public MatchMakingFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MatchMakingFutureStub(channel, callOptions);
        }
      };
    return MatchMakingFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class MatchMakingImplBase implements io.grpc.BindableService {

    /**
     */
    public void invite(PlayerInvite request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInviteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getInviteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                PlayerInvite,
                com.google.protobuf.Empty>(
                  this, METHODID_INVITE)))
          .build();
    }
  }

  /**
   */
  public static final class MatchMakingStub extends io.grpc.stub.AbstractAsyncStub<MatchMakingStub> {
    private MatchMakingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MatchMakingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MatchMakingStub(channel, callOptions);
    }

    /**
     */
    public void invite(PlayerInvite request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInviteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MatchMakingBlockingStub extends io.grpc.stub.AbstractBlockingStub<MatchMakingBlockingStub> {
    private MatchMakingBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MatchMakingBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MatchMakingBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Empty invite(PlayerInvite request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInviteMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MatchMakingFutureStub extends io.grpc.stub.AbstractFutureStub<MatchMakingFutureStub> {
    private MatchMakingFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MatchMakingFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MatchMakingFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> invite(
        PlayerInvite request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInviteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_INVITE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MatchMakingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MatchMakingImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_INVITE:
          serviceImpl.invite((PlayerInvite) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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

  private static abstract class MatchMakingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MatchMakingBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Player.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MatchMaking");
    }
  }

  private static final class MatchMakingFileDescriptorSupplier
      extends MatchMakingBaseDescriptorSupplier {
    MatchMakingFileDescriptorSupplier() {}
  }

  private static final class MatchMakingMethodDescriptorSupplier
      extends MatchMakingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MatchMakingMethodDescriptorSupplier(String methodName) {
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
      synchronized (MatchMakingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MatchMakingFileDescriptorSupplier())
              .addMethod(getInviteMethod())
              .build();
        }
      }
    }
    return result;
  }
}
