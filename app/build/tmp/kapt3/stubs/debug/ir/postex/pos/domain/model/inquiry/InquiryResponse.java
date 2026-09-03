package ir.postex.pos.domain.model.inquiry;

@kotlinx.serialization.Serializable()
@com.squareup.moshi.JsonClass(generateAdapter = true)
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 =2\u00020\u0001:\u0002<=B}\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0002\u0010\u0013B}\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0002\u0010\u0014J\u0010\u0010#\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0018J\u000b\u0010$\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0018J\u0010\u0010&\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0018J\u0010\u0010\'\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0018J\u000b\u0010(\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u0086\u0001\u0010-\u001a\u00020\u00002\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u00c6\u0001\u00a2\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00102\u001a\u00020\u0003H\u00d6\u0001J\t\u00103\u001a\u00020\nH\u00d6\u0001J&\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00002\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u00c1\u0001\u00a2\u0006\u0002\b;R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001b\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b \u0010\u0018R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b!\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016\u00a8\u0006>"}, d2 = {"Lir/postex/pos/domain/model/inquiry/InquiryResponse;", "", "seen1", "", "codAmount", "", "shippingPayableAmount", "otherPayableAmount", "totalPayableAmount", "trackingNo", "", "payer", "paymentType", "deliveryStatus", "calculatedAt", "receiver", "Lir/postex/pos/domain/model/inquiry/InquiryReceiver;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lir/postex/pos/domain/model/inquiry/InquiryReceiver;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lir/postex/pos/domain/model/inquiry/InquiryReceiver;)V", "getCalculatedAt", "()Ljava/lang/String;", "getCodAmount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDeliveryStatus", "getOtherPayableAmount", "getPayer", "getPaymentType", "getReceiver", "()Lir/postex/pos/domain/model/inquiry/InquiryReceiver;", "getShippingPayableAmount", "getTotalPayableAmount", "getTrackingNo", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lir/postex/pos/domain/model/inquiry/InquiryReceiver;)Lir/postex/pos/domain/model/inquiry/InquiryResponse;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_debug", "$serializer", "Companion", "app_debug"})
public final class InquiryResponse {
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long codAmount = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long shippingPayableAmount = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long otherPayableAmount = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long totalPayableAmount = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String trackingNo = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String payer = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String paymentType = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String deliveryStatus = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String calculatedAt = null;
    @org.jetbrains.annotations.Nullable()
    private final ir.postex.pos.domain.model.inquiry.InquiryReceiver receiver = null;
    @org.jetbrains.annotations.NotNull()
    public static final ir.postex.pos.domain.model.inquiry.InquiryResponse.Companion Companion = null;
    
    public InquiryResponse(@com.squareup.moshi.Json(name = "codAmount")
    @org.jetbrains.annotations.Nullable()
    java.lang.Long codAmount, @com.squareup.moshi.Json(name = "shippingPayableAmount")
    @org.jetbrains.annotations.Nullable()
    java.lang.Long shippingPayableAmount, @com.squareup.moshi.Json(name = "otherPayableAmount")
    @org.jetbrains.annotations.Nullable()
    java.lang.Long otherPayableAmount, @com.squareup.moshi.Json(name = "totalPayableAmount")
    @org.jetbrains.annotations.Nullable()
    java.lang.Long totalPayableAmount, @com.squareup.moshi.Json(name = "trackingNo")
    @org.jetbrains.annotations.Nullable()
    java.lang.String trackingNo, @com.squareup.moshi.Json(name = "payer")
    @org.jetbrains.annotations.Nullable()
    java.lang.String payer, @com.squareup.moshi.Json(name = "paymentType")
    @org.jetbrains.annotations.Nullable()
    java.lang.String paymentType, @com.squareup.moshi.Json(name = "deliveryStatus")
    @org.jetbrains.annotations.Nullable()
    java.lang.String deliveryStatus, @com.squareup.moshi.Json(name = "calculatedAt")
    @org.jetbrains.annotations.Nullable()
    java.lang.String calculatedAt, @com.squareup.moshi.Json(name = "receiver")
    @org.jetbrains.annotations.Nullable()
    ir.postex.pos.domain.model.inquiry.InquiryReceiver receiver) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getCodAmount() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getShippingPayableAmount() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getOtherPayableAmount() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getTotalPayableAmount() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTrackingNo() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPayer() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPaymentType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDeliveryStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCalculatedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ir.postex.pos.domain.model.inquiry.InquiryReceiver getReceiver() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ir.postex.pos.domain.model.inquiry.InquiryReceiver component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ir.postex.pos.domain.model.inquiry.InquiryResponse copy(@com.squareup.moshi.Json(name = "codAmount")
    @org.jetbrains.annotations.Nullable()
    java.lang.Long codAmount, @com.squareup.moshi.Json(name = "shippingPayableAmount")
    @org.jetbrains.annotations.Nullable()
    java.lang.Long shippingPayableAmount, @com.squareup.moshi.Json(name = "otherPayableAmount")
    @org.jetbrains.annotations.Nullable()
    java.lang.Long otherPayableAmount, @com.squareup.moshi.Json(name = "totalPayableAmount")
    @org.jetbrains.annotations.Nullable()
    java.lang.Long totalPayableAmount, @com.squareup.moshi.Json(name = "trackingNo")
    @org.jetbrains.annotations.Nullable()
    java.lang.String trackingNo, @com.squareup.moshi.Json(name = "payer")
    @org.jetbrains.annotations.Nullable()
    java.lang.String payer, @com.squareup.moshi.Json(name = "paymentType")
    @org.jetbrains.annotations.Nullable()
    java.lang.String paymentType, @com.squareup.moshi.Json(name = "deliveryStatus")
    @org.jetbrains.annotations.Nullable()
    java.lang.String deliveryStatus, @com.squareup.moshi.Json(name = "calculatedAt")
    @org.jetbrains.annotations.Nullable()
    java.lang.String calculatedAt, @com.squareup.moshi.Json(name = "receiver")
    @org.jetbrains.annotations.Nullable()
    ir.postex.pos.domain.model.inquiry.InquiryReceiver receiver) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
    
    @kotlin.jvm.JvmStatic()
    public static final void write$Self$app_debug(@org.jetbrains.annotations.NotNull()
    ir.postex.pos.domain.model.inquiry.InquiryResponse self, @org.jetbrains.annotations.NotNull()
    kotlinx.serialization.encoding.CompositeEncoder output, @org.jetbrains.annotations.NotNull()
    kotlinx.serialization.descriptors.SerialDescriptor serialDesc) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tH\u00d6\u0001\u00a2\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u00d6\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VX\u00d6\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0014"}, d2 = {"ir/postex/pos/domain/model/inquiry/InquiryResponse.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lir/postex/pos/domain/model/inquiry/InquiryResponse;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "app_debug"})
    @java.lang.Deprecated()
    public static final class $serializer implements kotlinx.serialization.internal.GeneratedSerializer<ir.postex.pos.domain.model.inquiry.InquiryResponse> {
        @org.jetbrains.annotations.NotNull()
        public static final ir.postex.pos.domain.model.inquiry.InquiryResponse.$serializer INSTANCE = null;
        
        private $serializer() {
            super();
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public kotlinx.serialization.KSerializer<?>[] childSerializers() {
            return null;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public ir.postex.pos.domain.model.inquiry.InquiryResponse deserialize(@org.jetbrains.annotations.NotNull()
        kotlinx.serialization.encoding.Decoder decoder) {
            return null;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public kotlinx.serialization.descriptors.SerialDescriptor getDescriptor() {
            return null;
        }
        
        @java.lang.Override()
        public void serialize(@org.jetbrains.annotations.NotNull()
        kotlinx.serialization.encoding.Encoder encoder, @org.jetbrains.annotations.NotNull()
        ir.postex.pos.domain.model.inquiry.InquiryResponse value) {
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public kotlinx.serialization.KSerializer<?>[] typeParametersSerializers() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0001\u00a8\u0006\u0006"}, d2 = {"Lir/postex/pos/domain/model/inquiry/InquiryResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lir/postex/pos/domain/model/inquiry/InquiryResponse;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlinx.serialization.KSerializer<ir.postex.pos.domain.model.inquiry.InquiryResponse> serializer() {
            return null;
        }
    }
}