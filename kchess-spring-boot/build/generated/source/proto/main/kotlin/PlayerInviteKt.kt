// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: player.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
@kotlin.jvm.JvmName("-initializeplayerInvite")
public inline fun playerInvite(block: PlayerInviteKt.Dsl.() -> kotlin.Unit): PlayerInvite =
  PlayerInviteKt.Dsl._create(PlayerInvite.newBuilder()).apply { block() }._build()
/**
 * Protobuf type `PlayerInvite`
 */
public object PlayerInviteKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: PlayerInvite.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: PlayerInvite.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): PlayerInvite = _builder.build()

    /**
     * `string host = 1;`
     */
    public var host: kotlin.String
      @JvmName("getHost")
      get() = _builder.getHost()
      @JvmName("setHost")
      set(value) {
        _builder.setHost(value)
      }
    /**
     * `string host = 1;`
     */
    public fun clearHost() {
      _builder.clearHost()
    }

    /**
     * `string guest = 2;`
     */
    public var guest: kotlin.String
      @JvmName("getGuest")
      get() = _builder.getGuest()
      @JvmName("setGuest")
      set(value) {
        _builder.setGuest(value)
      }
    /**
     * `string guest = 2;`
     */
    public fun clearGuest() {
      _builder.clearGuest()
    }
  }
}
@kotlin.jvm.JvmSynthetic
@com.google.errorprone.annotations.CheckReturnValue
public inline fun PlayerInvite.copy(block: PlayerInviteKt.Dsl.() -> kotlin.Unit): PlayerInvite =
  PlayerInviteKt.Dsl._create(this.toBuilder()).apply { block() }._build()

