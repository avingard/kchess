// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: messaging.proto

public final class MessagingOuterClass {
  private MessagingOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Request_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Request_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Response_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Response_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Fields_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Fields_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Fields_FieldsEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Fields_FieldsEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Value_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Value_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ArrayValue_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ArrayValue_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_MapValue_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_MapValue_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_MapValue_FieldsEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_MapValue_FieldsEntry_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017messaging.proto\032\034google/protobuf/struc" +
      "t.proto\032\037google/protobuf/timestamp.proto" +
      "\"\"\n\007Request\022\027\n\006fields\030\002 \001(\0132\007.Fields\"#\n\010" +
      "Response\022\027\n\006fields\030\001 \001(\0132\007.Fields\"d\n\006Fie" +
      "lds\022#\n\006fields\030\001 \003(\0132\023.Fields.FieldsEntry" +
      "\0325\n\013FieldsEntry\022\013\n\003key\030\001 \001(\t\022\025\n\005value\030\002 " +
      "\001(\0132\006.Value:\0028\001\"\244\002\n\005Value\0220\n\nnull_value\030" +
      "\013 \001(\0162\032.google.protobuf.NullValueH\000\022\027\n\rb" +
      "oolean_value\030\001 \001(\010H\000\022\027\n\rinteger_value\030\002 " +
      "\001(\003H\000\022\026\n\014double_value\030\003 \001(\001H\000\0225\n\017timesta" +
      "mp_value\030\n \001(\0132\032.google.protobuf.Timesta" +
      "mpH\000\022\026\n\014string_value\030\021 \001(\tH\000\022\"\n\013array_va" +
      "lue\030\t \001(\0132\013.ArrayValueH\000\022\036\n\tmap_value\030\006 " +
      "\001(\0132\t.MapValueH\000B\014\n\nvalue_type\"$\n\nArrayV" +
      "alue\022\026\n\006values\030\001 \003(\0132\006.Value\"h\n\010MapValue" +
      "\022%\n\006fields\030\001 \003(\0132\025.MapValue.FieldsEntry\032" +
      "5\n\013FieldsEntry\022\013\n\003key\030\001 \001(\t\022\025\n\005value\030\002 \001" +
      "(\0132\006.Value:\0028\0012\250\001\n\tMessaging\022&\n\017RequestR" +
      "esponse\022\010.Request\032\t.Response\022&\n\rRequestS" +
      "tream\022\010.Request\032\t.Response0\001\022\'\n\016StreamRe" +
      "sponse\022\010.Request\032\t.Response(\001\022\"\n\007Channel" +
      "\022\010.Request\032\t.Response(\0010\001B\002P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.StructProto.getDescriptor(),
          com.google.protobuf.TimestampProto.getDescriptor(),
        });
    internal_static_Request_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Request_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Request_descriptor,
        new java.lang.String[] { "Fields", });
    internal_static_Response_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Response_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Response_descriptor,
        new java.lang.String[] { "Fields", });
    internal_static_Fields_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Fields_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Fields_descriptor,
        new java.lang.String[] { "Fields", });
    internal_static_Fields_FieldsEntry_descriptor =
      internal_static_Fields_descriptor.getNestedTypes().get(0);
    internal_static_Fields_FieldsEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Fields_FieldsEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_Value_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_Value_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Value_descriptor,
        new java.lang.String[] { "NullValue", "BooleanValue", "IntegerValue", "DoubleValue", "TimestampValue", "StringValue", "ArrayValue", "MapValue", "ValueType", });
    internal_static_ArrayValue_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_ArrayValue_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ArrayValue_descriptor,
        new java.lang.String[] { "Values", });
    internal_static_MapValue_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_MapValue_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_MapValue_descriptor,
        new java.lang.String[] { "Fields", });
    internal_static_MapValue_FieldsEntry_descriptor =
      internal_static_MapValue_descriptor.getNestedTypes().get(0);
    internal_static_MapValue_FieldsEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_MapValue_FieldsEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    com.google.protobuf.StructProto.getDescriptor();
    com.google.protobuf.TimestampProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
