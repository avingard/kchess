// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: messaging.proto

public interface MapValueOrBuilder extends
    // @@protoc_insertion_point(interface_extends:MapValue)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>map&lt;string, .Value&gt; fields = 1;</code>
   */
  int getFieldsCount();
  /**
   * <code>map&lt;string, .Value&gt; fields = 1;</code>
   */
  boolean containsFields(
      java.lang.String key);
  /**
   * Use {@link #getFieldsMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, Value>
  getFields();
  /**
   * <code>map&lt;string, .Value&gt; fields = 1;</code>
   */
  java.util.Map<java.lang.String, Value>
  getFieldsMap();
  /**
   * <code>map&lt;string, .Value&gt; fields = 1;</code>
   */
  /* nullable */
Value getFieldsOrDefault(
      java.lang.String key,
      /* nullable */
Value defaultValue);
  /**
   * <code>map&lt;string, .Value&gt; fields = 1;</code>
   */
  Value getFieldsOrThrow(
      java.lang.String key);
}
