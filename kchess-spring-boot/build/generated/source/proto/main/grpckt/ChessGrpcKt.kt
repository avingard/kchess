import com.google.protobuf.Empty
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
import io.grpc.kotlin.ClientCalls.serverStreamingRpc
import io.grpc.kotlin.ClientCalls.unaryRpc
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
 * Holder for Kotlin coroutine-based client and server APIs for ChessGame.
 */
public object ChessGameGrpcKt {
  public const val SERVICE_NAME: String = ChessGameGrpc.SERVICE_NAME

  @JvmStatic
  public val serviceDescriptor: ServiceDescriptor
    get() = ChessGameGrpc.getServiceDescriptor()

  public val moveToMethod: MethodDescriptor<MoveRequest, Empty>
    @JvmStatic
    get() = ChessGameGrpc.getMoveToMethod()

  public val gameMethod: MethodDescriptor<GameRequest, GameEvent>
    @JvmStatic
    get() = ChessGameGrpc.getGameMethod()

  /**
   * A stub for issuing RPCs to a(n) ChessGame service as suspending coroutines.
   */
  @StubFor(ChessGameGrpc::class)
  public class ChessGameCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT,
  ) : AbstractCoroutineStub<ChessGameCoroutineStub>(channel, callOptions) {
    public override fun build(channel: Channel, callOptions: CallOptions): ChessGameCoroutineStub =
        ChessGameCoroutineStub(channel, callOptions)

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
    public suspend fun moveTo(request: MoveRequest, headers: Metadata = Metadata()): Empty =
        unaryRpc(
      channel,
      ChessGameGrpc.getMoveToMethod(),
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
    public fun game(request: GameRequest, headers: Metadata = Metadata()): Flow<GameEvent> =
        serverStreamingRpc(
      channel,
      ChessGameGrpc.getGameMethod(),
      request,
      callOptions,
      headers
    )
  }

  /**
   * Skeletal implementation of the ChessGame service based on Kotlin coroutines.
   */
  public abstract class ChessGameCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns the response to an RPC for ChessGame.MoveTo.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun moveTo(request: MoveRequest): Empty = throw
        StatusException(UNIMPLEMENTED.withDescription("Method ChessGame.MoveTo is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for ChessGame.Game.
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
    public open fun game(request: GameRequest): Flow<GameEvent> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method ChessGame.Game is unimplemented"))

    public final override fun bindService(): ServerServiceDefinition =
        builder(ChessGameGrpc.getServiceDescriptor())
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = ChessGameGrpc.getMoveToMethod(),
      implementation = ::moveTo
    ))
      .addMethod(serverStreamingServerMethodDefinition(
      context = this.context,
      descriptor = ChessGameGrpc.getGameMethod(),
      implementation = ::game
    )).build()
  }
}
