import io.grpc.CallOptions
import io.grpc.CallOptions.DEFAULT
import io.grpc.Channel
import io.grpc.Metadata
import io.grpc.MethodDescriptor
import io.grpc.ServerServiceDefinition
import io.grpc.ServerServiceDefinition.builder
import io.grpc.ServiceDescriptor
import io.grpc.Status
import io.grpc.Status.UNIMPLEMENTED
import io.grpc.StatusException
import io.grpc.kotlin.AbstractCoroutineServerImpl
import io.grpc.kotlin.AbstractCoroutineStub
import io.grpc.kotlin.ClientCalls.bidiStreamingRpc
import io.grpc.kotlin.ClientCalls.clientStreamingRpc
import io.grpc.kotlin.ClientCalls.serverStreamingRpc
import io.grpc.kotlin.ClientCalls.unaryRpc
import io.grpc.kotlin.ServerCalls.bidiStreamingServerMethodDefinition
import io.grpc.kotlin.ServerCalls.clientStreamingServerMethodDefinition
import io.grpc.kotlin.ServerCalls.serverStreamingServerMethodDefinition
import io.grpc.kotlin.ServerCalls.unaryServerMethodDefinition
import io.grpc.kotlin.StubFor
import kotlin.String
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic
import kotlinx.coroutines.flow.Flow

/**
 * Holder for Kotlin coroutine-based client and server APIs for Messaging.
 */
public object MessagingGrpcKt {
  public const val SERVICE_NAME: String = MessagingGrpc.SERVICE_NAME

  @JvmStatic
  public val serviceDescriptor: ServiceDescriptor
    get() = MessagingGrpc.getServiceDescriptor()

  public val requestResponseMethod: MethodDescriptor<Request, Response>
    @JvmStatic
    get() = MessagingGrpc.getRequestResponseMethod()

  public val requestStreamMethod: MethodDescriptor<Request, Response>
    @JvmStatic
    get() = MessagingGrpc.getRequestStreamMethod()

  public val streamResponseMethod: MethodDescriptor<Request, Response>
    @JvmStatic
    get() = MessagingGrpc.getStreamResponseMethod()

  public val channelMethod: MethodDescriptor<Request, Response>
    @JvmStatic
    get() = MessagingGrpc.getChannelMethod()

  /**
   * A stub for issuing RPCs to a(n) Messaging service as suspending coroutines.
   */
  @StubFor(MessagingGrpc::class)
  public class MessagingCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT,
  ) : AbstractCoroutineStub<MessagingCoroutineStub>(channel, callOptions) {
    public override fun build(channel: Channel, callOptions: CallOptions): MessagingCoroutineStub =
        MessagingCoroutineStub(channel, callOptions)

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun requestResponse(request: Request, headers: Metadata = Metadata()): Response =
        unaryRpc(
      channel,
      MessagingGrpc.getRequestResponseMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    public fun requestStream(request: Request, headers: Metadata = Metadata()): Flow<Response> =
        serverStreamingRpc(
      channel,
      MessagingGrpc.getRequestStreamMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * This function collects the [Flow] of requests.  If the server terminates the RPC
     * for any reason before collection of requests is complete, the collection of requests
     * will be cancelled.  If the collection of requests completes exceptionally for any other
     * reason, the RPC will be cancelled for that reason and this method will throw that
     * exception.
     *
     * @param requests A [Flow] of request messages.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun streamResponse(requests: Flow<Request>, headers: Metadata = Metadata()):
        Response = clientStreamingRpc(
      channel,
      MessagingGrpc.getStreamResponseMethod(),
      requests,
      callOptions,
      headers
    )

    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * The [Flow] of requests is collected once each time the [Flow] of responses is
     * collected. If collection of the [Flow] of responses completes normally or
     * exceptionally before collection of `requests` completes, the collection of
     * `requests` is cancelled.  If the collection of `requests` completes
     * exceptionally for any other reason, then the collection of the [Flow] of responses
     * completes exceptionally for the same reason and the RPC is cancelled with that reason.
     *
     * @param requests A [Flow] of request messages.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    public fun channel(requests: Flow<Request>, headers: Metadata = Metadata()): Flow<Response> =
        bidiStreamingRpc(
      channel,
      MessagingGrpc.getChannelMethod(),
      requests,
      callOptions,
      headers
    )
  }

  /**
   * Skeletal implementation of the Messaging service based on Kotlin coroutines.
   */
  public abstract class MessagingCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns the response to an RPC for Messaging.RequestResponse.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun requestResponse(request: Request): Response = throw
        StatusException(UNIMPLEMENTED.withDescription("Method Messaging.RequestResponse is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for Messaging.RequestStream.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open fun requestStream(request: Request): Flow<Response> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method Messaging.RequestStream is unimplemented"))

    /**
     * Returns the response to an RPC for Messaging.StreamResponse.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param requests A [Flow] of requests from the client.  This flow can be
     *        collected only once and throws [java.lang.IllegalStateException] on attempts to
     * collect
     *        it more than once.
     */
    public open suspend fun streamResponse(requests: Flow<Request>): Response = throw
        StatusException(UNIMPLEMENTED.withDescription("Method Messaging.StreamResponse is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for Messaging.Channel.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param requests A [Flow] of requests from the client.  This flow can be
     *        collected only once and throws [java.lang.IllegalStateException] on attempts to
     * collect
     *        it more than once.
     */
    public open fun channel(requests: Flow<Request>): Flow<Response> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method Messaging.Channel is unimplemented"))

    public final override fun bindService(): ServerServiceDefinition =
        builder(MessagingGrpc.getServiceDescriptor())
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = MessagingGrpc.getRequestResponseMethod(),
      implementation = ::requestResponse
    ))
      .addMethod(serverStreamingServerMethodDefinition(
      context = this.context,
      descriptor = MessagingGrpc.getRequestStreamMethod(),
      implementation = ::requestStream
    ))
      .addMethod(clientStreamingServerMethodDefinition(
      context = this.context,
      descriptor = MessagingGrpc.getStreamResponseMethod(),
      implementation = ::streamResponse
    ))
      .addMethod(bidiStreamingServerMethodDefinition(
      context = this.context,
      descriptor = MessagingGrpc.getChannelMethod(),
      implementation = ::channel
    )).build()
  }
}
