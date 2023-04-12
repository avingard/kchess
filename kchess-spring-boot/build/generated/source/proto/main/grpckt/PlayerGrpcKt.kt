import com.google.protobuf.Empty
import io.grpc.CallOptions
import io.grpc.CallOptions.DEFAULT
import io.grpc.Channel
import io.grpc.Metadata
import io.grpc.MethodDescriptor
import io.grpc.ServerServiceDefinition
import io.grpc.ServerServiceDefinition.builder
import io.grpc.ServiceDescriptor
import io.grpc.Status.UNIMPLEMENTED
import io.grpc.StatusException
import io.grpc.kotlin.AbstractCoroutineServerImpl
import io.grpc.kotlin.AbstractCoroutineStub
import io.grpc.kotlin.ClientCalls.unaryRpc
import io.grpc.kotlin.ServerCalls.unaryServerMethodDefinition
import io.grpc.kotlin.StubFor
import kotlin.String
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * Holder for Kotlin coroutine-based client and server APIs for MatchMaking.
 */
public object MatchMakingGrpcKt {
  public const val SERVICE_NAME: String = MatchMakingGrpc.SERVICE_NAME

  @JvmStatic
  public val serviceDescriptor: ServiceDescriptor
    get() = MatchMakingGrpc.getServiceDescriptor()

  public val inviteMethod: MethodDescriptor<PlayerInvite, Empty>
    @JvmStatic
    get() = MatchMakingGrpc.getInviteMethod()

  /**
   * A stub for issuing RPCs to a(n) MatchMaking service as suspending coroutines.
   */
  @StubFor(MatchMakingGrpc::class)
  public class MatchMakingCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT,
  ) : AbstractCoroutineStub<MatchMakingCoroutineStub>(channel, callOptions) {
    public override fun build(channel: Channel, callOptions: CallOptions): MatchMakingCoroutineStub
        = MatchMakingCoroutineStub(channel, callOptions)

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun invite(request: PlayerInvite, headers: Metadata = Metadata()): Empty =
        unaryRpc(
      channel,
      MatchMakingGrpc.getInviteMethod(),
      request,
      callOptions,
      headers
    )
  }

  /**
   * Skeletal implementation of the MatchMaking service based on Kotlin coroutines.
   */
  public abstract class MatchMakingCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns the response to an RPC for MatchMaking.Invite.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun invite(request: PlayerInvite): Empty = throw
        StatusException(UNIMPLEMENTED.withDescription("Method MatchMaking.Invite is unimplemented"))

    public final override fun bindService(): ServerServiceDefinition =
        builder(MatchMakingGrpc.getServiceDescriptor())
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = MatchMakingGrpc.getInviteMethod(),
      implementation = ::invite
    )).build()
  }
}