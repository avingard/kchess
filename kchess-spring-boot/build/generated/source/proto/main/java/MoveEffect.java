// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chess.proto

/**
 * Protobuf enum {@code MoveEffect}
 */
public enum MoveEffect
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>CHECK = 0;</code>
   */
  CHECK(0),
  /**
   * <code>CHECKMATE = 1;</code>
   */
  CHECKMATE(1),
  /**
   * <code>DRAW = 2;</code>
   */
  DRAW(2),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>CHECK = 0;</code>
   */
  public static final int CHECK_VALUE = 0;
  /**
   * <code>CHECKMATE = 1;</code>
   */
  public static final int CHECKMATE_VALUE = 1;
  /**
   * <code>DRAW = 2;</code>
   */
  public static final int DRAW_VALUE = 2;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static MoveEffect valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static MoveEffect forNumber(int value) {
    switch (value) {
      case 0: return CHECK;
      case 1: return CHECKMATE;
      case 2: return DRAW;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<MoveEffect>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      MoveEffect> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<MoveEffect>() {
          public MoveEffect findValueByNumber(int number) {
            return MoveEffect.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return Chess.getDescriptor().getEnumTypes().get(0);
  }

  private static final MoveEffect[] VALUES = values();

  public static MoveEffect valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private MoveEffect(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:MoveEffect)
}

