// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: messaging.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
@kotlin.jvm.JvmName("-initializemapValue")
public inline fun mapValue(block: MapValueKt.Dsl.() -> kotlin.Unit): MapValue =
  MapValueKt.Dsl._create(MapValue.newBuilder()).apply { block() }._build()
/**
 * Protobuf type `MapValue`
 */
public object MapValueKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: MapValue.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: MapValue.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): MapValue = _builder.build()

    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    public class FieldsProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * `map<string, .Value> fields = 1;`
     */
     public val fields: com.google.protobuf.kotlin.DslMap<kotlin.String, Value, FieldsProxy>
      @kotlin.jvm.JvmSynthetic
      @JvmName("getFieldsMap")
      get() = com.google.protobuf.kotlin.DslMap(
        _builder.getFieldsMap()
      )
    /**
     * `map<string, .Value> fields = 1;`
     */
    @JvmName("putFields")
    public fun com.google.protobuf.kotlin.DslMap<kotlin.String, Value, FieldsProxy>
      .put(key: kotlin.String, value: Value) {
         _builder.putFields(key, value)
       }
    /**
     * `map<string, .Value> fields = 1;`
     */
    @kotlin.jvm.JvmSynthetic
    @JvmName("setFields")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslMap<kotlin.String, Value, FieldsProxy>
      .set(key: kotlin.String, value: Value) {
         put(key, value)
       }
    /**
     * `map<string, .Value> fields = 1;`
     */
    @kotlin.jvm.JvmSynthetic
    @JvmName("removeFields")
    public fun com.google.protobuf.kotlin.DslMap<kotlin.String, Value, FieldsProxy>
      .remove(key: kotlin.String) {
         _builder.removeFields(key)
       }
    /**
     * `map<string, .Value> fields = 1;`
     */
    @kotlin.jvm.JvmSynthetic
    @JvmName("putAllFields")
    public fun com.google.protobuf.kotlin.DslMap<kotlin.String, Value, FieldsProxy>
      .putAll(map: kotlin.collections.Map<kotlin.String, Value>) {
         _builder.putAllFields(map)
       }
    /**
     * `map<string, .Value> fields = 1;`
     */
    @kotlin.jvm.JvmSynthetic
    @JvmName("clearFields")
    public fun com.google.protobuf.kotlin.DslMap<kotlin.String, Value, FieldsProxy>
      .clear() {
         _builder.clearFields()
       }
  }
}
@kotlin.jvm.JvmSynthetic
@com.google.errorprone.annotations.CheckReturnValue
public inline fun MapValue.copy(block: MapValueKt.Dsl.() -> kotlin.Unit): MapValue =
  MapValueKt.Dsl._create(this.toBuilder()).apply { block() }._build()
