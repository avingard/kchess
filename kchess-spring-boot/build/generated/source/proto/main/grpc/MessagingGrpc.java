import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.53.0)",
    comments = "Source: messaging.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MessagingGrpc {

  private MessagingGrpc() {}

  public static final String SERVICE_NAME = "Messaging";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Request,
      Response> getRequestResponseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RequestResponse",
      requestType = Request.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Request,
      Response> getRequestResponseMethod() {
    io.grpc.MethodDescriptor<Request, Response> getRequestResponseMethod;
    if ((getRequestResponseMethod = MessagingGrpc.getRequestResponseMethod) == null) {
      synchronized (MessagingGrpc.class) {
        if ((getRequestResponseMethod = MessagingGrpc.getRequestResponseMethod) == null) {
          MessagingGrpc.getRequestResponseMethod = getRequestResponseMethod =
              io.grpc.MethodDescriptor.<Request, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RequestResponse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
              .setSchemaDescriptor(new MessagingMethodDescriptorSupplier("RequestResponse"))
              .build();
        }
      }
    }
    return getRequestResponseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Request,
      Response> getRequestStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RequestStream",
      requestType = Request.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<Request,
      Response> getRequestStreamMethod() {
    io.grpc.MethodDescriptor<Request, Response> getRequestStreamMethod;
    if ((getRequestStreamMethod = MessagingGrpc.getRequestStreamMethod) == null) {
      synchronized (MessagingGrpc.class) {
        if ((getRequestStreamMethod = MessagingGrpc.getRequestStreamMethod) == null) {
          MessagingGrpc.getRequestStreamMethod = getRequestStreamMethod =
              io.grpc.MethodDescriptor.<Request, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RequestStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
              .setSchemaDescriptor(new MessagingMethodDescriptorSupplier("RequestStream"))
              .build();
        }
      }
    }
    return getRequestStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Request,
      Response> getStreamResponseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamResponse",
      requestType = Request.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<Request,
      Response> getStreamResponseMethod() {
    io.grpc.MethodDescriptor<Request, Response> getStreamResponseMethod;
    if ((getStreamResponseMethod = MessagingGrpc.getStreamResponseMethod) == null) {
      synchronized (MessagingGrpc.class) {
        if ((getStreamResponseMethod = MessagingGrpc.getStreamResponseMethod) == null) {
          MessagingGrpc.getStreamResponseMethod = getStreamResponseMethod =
              io.grpc.MethodDescriptor.<Request, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamResponse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
              .setSchemaDescriptor(new MessagingMethodDescriptorSupplier("StreamResponse"))
              .build();
        }
      }
    }
    return getStreamResponseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Request,
      Response> getChannelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Channel",
      requestType = Request.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<Request,
      Response> getChannelMethod() {
    io.grpc.MethodDescriptor<Request, Response> getChannelMethod;
    if ((getChannelMethod = MessagingGrpc.getChannelMethod) == null) {
      synchronized (MessagingGrpc.class) {
        if ((getChannelMethod = MessagingGrpc.getChannelMethod) == null) {
          MessagingGrpc.getChannelMethod = getChannelMethod =
              io.grpc.MethodDescriptor.<Request, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Channel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
              .setSchemaDescriptor(new MessagingMethodDescriptorSupplier("Channel"))
              .build();
        }
      }
    }
    return getChannelMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MessagingStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessagingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessagingStub>() {
        @java.lang.Override
        public MessagingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessagingStub(channel, callOptions);
        }
      };
    return MessagingStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MessagingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessagingBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessagingBlockingStub>() {
        @java.lang.Override
        public MessagingBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessagingBlockingStub(channel, callOptions);
        }
      };
    return MessagingBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MessagingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessagingFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessagingFutureStub>() {
        @java.lang.Override
        public MessagingFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessagingFutureStub(channel, callOptions);
        }
      };
    return MessagingFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class MessagingImplBase implements io.grpc.BindableService {

    /**
     */
    public void requestResponse(Request request,
        io.grpc.stub.StreamObserver<Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRequestResponseMethod(), responseObserver);
    }

    /**
     */
    public void requestStream(Request request,
        io.grpc.stub.StreamObserver<Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRequestStreamMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<Request> streamResponse(
        io.grpc.stub.StreamObserver<Response> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getStreamResponseMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<Request> channel(
        io.grpc.stub.StreamObserver<Response> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getChannelMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRequestResponseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                Request,
                Response>(
                  this, METHODID_REQUEST_RESPONSE)))
          .addMethod(
            getRequestStreamMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                Request,
                Response>(
                  this, METHODID_REQUEST_STREAM)))
          .addMethod(
            getStreamResponseMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                Request,
                Response>(
                  this, METHODID_STREAM_RESPONSE)))
          .addMethod(
            getChannelMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                Request,
                Response>(
                  this, METHODID_CHANNEL)))
          .build();
    }
  }

  /**
   */
  public static final class MessagingStub extends io.grpc.stub.AbstractAsyncStub<MessagingStub> {
    private MessagingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessagingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessagingStub(channel, callOptions);
    }

    /**
     */
    public void requestResponse(Request request,
        io.grpc.stub.StreamObserver<Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRequestResponseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void requestStream(Request request,
        io.grpc.stub.StreamObserver<Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getRequestStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<Request> streamResponse(
        io.grpc.stub.StreamObserver<Response> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getStreamResponseMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<Request> channel(
        io.grpc.stub.StreamObserver<Response> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getChannelMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class MessagingBlockingStub extends io.grpc.stub.AbstractBlockingStub<MessagingBlockingStub> {
    private MessagingBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessagingBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessagingBlockingStub(channel, callOptions);
    }

    /**
     */
    public Response requestResponse(Request request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRequestResponseMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<Response> requestStream(
        Request request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getRequestStreamMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MessagingFutureStub extends io.grpc.stub.AbstractFutureStub<MessagingFutureStub> {
    private MessagingFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessagingFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessagingFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> requestResponse(
        Request request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRequestResponseMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REQUEST_RESPONSE = 0;
  private static final int METHODID_REQUEST_STREAM = 1;
  private static final int METHODID_STREAM_RESPONSE = 2;
  private static final int METHODID_CHANNEL = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MessagingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MessagingImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REQUEST_RESPONSE:
          serviceImpl.requestResponse((Request) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_REQUEST_STREAM:
          serviceImpl.requestStream((Request) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
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
        case METHODID_STREAM_RESPONSE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamResponse(
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
        case METHODID_CHANNEL:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.channel(
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MessagingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MessagingBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return MessagingOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Messaging");
    }
  }

  private static final class MessagingFileDescriptorSupplier
      extends MessagingBaseDescriptorSupplier {
    MessagingFileDescriptorSupplier() {}
  }

  private static final class MessagingMethodDescriptorSupplier
      extends MessagingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MessagingMethodDescriptorSupplier(String methodName) {
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
      synchronized (MessagingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MessagingFileDescriptorSupplier())
              .addMethod(getRequestResponseMethod())
              .addMethod(getRequestStreamMethod())
              .addMethod(getStreamResponseMethod())
              .addMethod(getChannelMethod())
              .build();
        }
      }
    }
    return result;
  }
}
