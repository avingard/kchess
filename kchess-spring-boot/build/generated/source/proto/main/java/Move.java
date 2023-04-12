// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chess.proto

/**
 * Protobuf type {@code Move}
 */
public final class Move extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Move)
    MoveOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Move.newBuilder() to construct.
  private Move(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Move() {
    effect_ = 0;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Move();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return Chess.internal_static_Move_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return Chess.internal_static_Move_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            Move.class, Move.Builder.class);
  }

  public static final int FROM_FIELD_NUMBER = 1;
  private Position from_;
  /**
   * <code>.Position from = 1;</code>
   * @return Whether the from field is set.
   */
  @java.lang.Override
  public boolean hasFrom() {
    return from_ != null;
  }
  /**
   * <code>.Position from = 1;</code>
   * @return The from.
   */
  @java.lang.Override
  public Position getFrom() {
    return from_ == null ? Position.getDefaultInstance() : from_;
  }
  /**
   * <code>.Position from = 1;</code>
   */
  @java.lang.Override
  public PositionOrBuilder getFromOrBuilder() {
    return from_ == null ? Position.getDefaultInstance() : from_;
  }

  public static final int TO_FIELD_NUMBER = 2;
  private Position to_;
  /**
   * <code>.Position to = 2;</code>
   * @return Whether the to field is set.
   */
  @java.lang.Override
  public boolean hasTo() {
    return to_ != null;
  }
  /**
   * <code>.Position to = 2;</code>
   * @return The to.
   */
  @java.lang.Override
  public Position getTo() {
    return to_ == null ? Position.getDefaultInstance() : to_;
  }
  /**
   * <code>.Position to = 2;</code>
   */
  @java.lang.Override
  public PositionOrBuilder getToOrBuilder() {
    return to_ == null ? Position.getDefaultInstance() : to_;
  }

  public static final int EFFECT_FIELD_NUMBER = 3;
  private int effect_ = 0;
  /**
   * <code>.MoveEffect effect = 3;</code>
   * @return The enum numeric value on the wire for effect.
   */
  @java.lang.Override public int getEffectValue() {
    return effect_;
  }
  /**
   * <code>.MoveEffect effect = 3;</code>
   * @return The effect.
   */
  @java.lang.Override public MoveEffect getEffect() {
    MoveEffect result = MoveEffect.forNumber(effect_);
    return result == null ? MoveEffect.UNRECOGNIZED : result;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (from_ != null) {
      output.writeMessage(1, getFrom());
    }
    if (to_ != null) {
      output.writeMessage(2, getTo());
    }
    if (effect_ != MoveEffect.CHECK.getNumber()) {
      output.writeEnum(3, effect_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (from_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getFrom());
    }
    if (to_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getTo());
    }
    if (effect_ != MoveEffect.CHECK.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(3, effect_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof Move)) {
      return super.equals(obj);
    }
    Move other = (Move) obj;

    if (hasFrom() != other.hasFrom()) return false;
    if (hasFrom()) {
      if (!getFrom()
          .equals(other.getFrom())) return false;
    }
    if (hasTo() != other.hasTo()) return false;
    if (hasTo()) {
      if (!getTo()
          .equals(other.getTo())) return false;
    }
    if (effect_ != other.effect_) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasFrom()) {
      hash = (37 * hash) + FROM_FIELD_NUMBER;
      hash = (53 * hash) + getFrom().hashCode();
    }
    if (hasTo()) {
      hash = (37 * hash) + TO_FIELD_NUMBER;
      hash = (53 * hash) + getTo().hashCode();
    }
    hash = (37 * hash) + EFFECT_FIELD_NUMBER;
    hash = (53 * hash) + effect_;
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static Move parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Move parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Move parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Move parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Move parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Move parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Move parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static Move parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static Move parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static Move parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static Move parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static Move parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(Move prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code Move}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Move)
      MoveOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Chess.internal_static_Move_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Chess.internal_static_Move_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Move.class, Move.Builder.class);
    }

    // Construct using Move.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      from_ = null;
      if (fromBuilder_ != null) {
        fromBuilder_.dispose();
        fromBuilder_ = null;
      }
      to_ = null;
      if (toBuilder_ != null) {
        toBuilder_.dispose();
        toBuilder_ = null;
      }
      effect_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return Chess.internal_static_Move_descriptor;
    }

    @java.lang.Override
    public Move getDefaultInstanceForType() {
      return Move.getDefaultInstance();
    }

    @java.lang.Override
    public Move build() {
      Move result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public Move buildPartial() {
      Move result = new Move(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(Move result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.from_ = fromBuilder_ == null
            ? from_
            : fromBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.to_ = toBuilder_ == null
            ? to_
            : toBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.effect_ = effect_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof Move) {
        return mergeFrom((Move)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(Move other) {
      if (other == Move.getDefaultInstance()) return this;
      if (other.hasFrom()) {
        mergeFrom(other.getFrom());
      }
      if (other.hasTo()) {
        mergeTo(other.getTo());
      }
      if (other.effect_ != 0) {
        setEffectValue(other.getEffectValue());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              input.readMessage(
                  getFromFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              input.readMessage(
                  getToFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 24: {
              effect_ = input.readEnum();
              bitField0_ |= 0x00000004;
              break;
            } // case 24
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private Position from_;
    private com.google.protobuf.SingleFieldBuilderV3<
        Position, Position.Builder, PositionOrBuilder> fromBuilder_;
    /**
     * <code>.Position from = 1;</code>
     * @return Whether the from field is set.
     */
    public boolean hasFrom() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>.Position from = 1;</code>
     * @return The from.
     */
    public Position getFrom() {
      if (fromBuilder_ == null) {
        return from_ == null ? Position.getDefaultInstance() : from_;
      } else {
        return fromBuilder_.getMessage();
      }
    }
    /**
     * <code>.Position from = 1;</code>
     */
    public Builder setFrom(Position value) {
      if (fromBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        from_ = value;
      } else {
        fromBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.Position from = 1;</code>
     */
    public Builder setFrom(
        Position.Builder builderForValue) {
      if (fromBuilder_ == null) {
        from_ = builderForValue.build();
      } else {
        fromBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.Position from = 1;</code>
     */
    public Builder mergeFrom(Position value) {
      if (fromBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
          from_ != null &&
          from_ != Position.getDefaultInstance()) {
          getFromBuilder().mergeFrom(value);
        } else {
          from_ = value;
        }
      } else {
        fromBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.Position from = 1;</code>
     */
    public Builder clearFrom() {
      bitField0_ = (bitField0_ & ~0x00000001);
      from_ = null;
      if (fromBuilder_ != null) {
        fromBuilder_.dispose();
        fromBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.Position from = 1;</code>
     */
    public Position.Builder getFromBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getFromFieldBuilder().getBuilder();
    }
    /**
     * <code>.Position from = 1;</code>
     */
    public PositionOrBuilder getFromOrBuilder() {
      if (fromBuilder_ != null) {
        return fromBuilder_.getMessageOrBuilder();
      } else {
        return from_ == null ?
            Position.getDefaultInstance() : from_;
      }
    }
    /**
     * <code>.Position from = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        Position, Position.Builder, PositionOrBuilder> 
        getFromFieldBuilder() {
      if (fromBuilder_ == null) {
        fromBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            Position, Position.Builder, PositionOrBuilder>(
                getFrom(),
                getParentForChildren(),
                isClean());
        from_ = null;
      }
      return fromBuilder_;
    }

    private Position to_;
    private com.google.protobuf.SingleFieldBuilderV3<
        Position, Position.Builder, PositionOrBuilder> toBuilder_;
    /**
     * <code>.Position to = 2;</code>
     * @return Whether the to field is set.
     */
    public boolean hasTo() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>.Position to = 2;</code>
     * @return The to.
     */
    public Position getTo() {
      if (toBuilder_ == null) {
        return to_ == null ? Position.getDefaultInstance() : to_;
      } else {
        return toBuilder_.getMessage();
      }
    }
    /**
     * <code>.Position to = 2;</code>
     */
    public Builder setTo(Position value) {
      if (toBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        to_ = value;
      } else {
        toBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.Position to = 2;</code>
     */
    public Builder setTo(
        Position.Builder builderForValue) {
      if (toBuilder_ == null) {
        to_ = builderForValue.build();
      } else {
        toBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.Position to = 2;</code>
     */
    public Builder mergeTo(Position value) {
      if (toBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
          to_ != null &&
          to_ != Position.getDefaultInstance()) {
          getToBuilder().mergeFrom(value);
        } else {
          to_ = value;
        }
      } else {
        toBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.Position to = 2;</code>
     */
    public Builder clearTo() {
      bitField0_ = (bitField0_ & ~0x00000002);
      to_ = null;
      if (toBuilder_ != null) {
        toBuilder_.dispose();
        toBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.Position to = 2;</code>
     */
    public Position.Builder getToBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getToFieldBuilder().getBuilder();
    }
    /**
     * <code>.Position to = 2;</code>
     */
    public PositionOrBuilder getToOrBuilder() {
      if (toBuilder_ != null) {
        return toBuilder_.getMessageOrBuilder();
      } else {
        return to_ == null ?
            Position.getDefaultInstance() : to_;
      }
    }
    /**
     * <code>.Position to = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        Position, Position.Builder, PositionOrBuilder> 
        getToFieldBuilder() {
      if (toBuilder_ == null) {
        toBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            Position, Position.Builder, PositionOrBuilder>(
                getTo(),
                getParentForChildren(),
                isClean());
        to_ = null;
      }
      return toBuilder_;
    }

    private int effect_ = 0;
    /**
     * <code>.MoveEffect effect = 3;</code>
     * @return The enum numeric value on the wire for effect.
     */
    @java.lang.Override public int getEffectValue() {
      return effect_;
    }
    /**
     * <code>.MoveEffect effect = 3;</code>
     * @param value The enum numeric value on the wire for effect to set.
     * @return This builder for chaining.
     */
    public Builder setEffectValue(int value) {
      effect_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>.MoveEffect effect = 3;</code>
     * @return The effect.
     */
    @java.lang.Override
    public MoveEffect getEffect() {
      MoveEffect result = MoveEffect.forNumber(effect_);
      return result == null ? MoveEffect.UNRECOGNIZED : result;
    }
    /**
     * <code>.MoveEffect effect = 3;</code>
     * @param value The effect to set.
     * @return This builder for chaining.
     */
    public Builder setEffect(MoveEffect value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000004;
      effect_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.MoveEffect effect = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearEffect() {
      bitField0_ = (bitField0_ & ~0x00000004);
      effect_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Move)
  }

  // @@protoc_insertion_point(class_scope:Move)
  private static final Move DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new Move();
  }

  public static Move getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Move>
      PARSER = new com.google.protobuf.AbstractParser<Move>() {
    @java.lang.Override
    public Move parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<Move> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Move> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public Move getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
