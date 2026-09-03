package ir.postex.pos.data.source.remote.network;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u000bJ.\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\u00032\b\b\u0001\u0010\u0011\u001a\u00020\u00062\b\b\u0001\u0010\u0012\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\bJ(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0001\u0010\u0015\u001a\u00020\u00062\b\b\u0001\u0010\u0016\u001a\u00020\u0017H\u00a7@\u00a2\u0006\u0002\u0010\u0018J<\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u001b\u001a\u00020\u00062\b\b\u0001\u0010\u001c\u001a\u00020\u00062\b\b\u0001\u0010\u0016\u001a\u00020\u001dH\u00a7@\u00a2\u0006\u0002\u0010\u001e\u00a8\u0006\u001f"}, d2 = {"Lir/postex/pos/data/source/remote/network/MainServices;", "", "getAmount", "Lretrofit2/Response;", "Lir/postex/pos/domain/model/inquiry/InquiryResponse;", "deviceSerialNo", "", "requestId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBalance", "Lir/postex/pos/domain/model/balance/BalanceResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDailyReport", "", "Lir/postex/pos/domain/model/report/DailyReportItem;", "getTransactions", "Lir/postex/pos/domain/model/report/TransactionsItem;", "fromDate", "toDate", "postShipmentPay", "Lir/postex/pos/domain/model/enroll/EnrollResponse;", "parcelNo", "request", "Lir/postex/pos/domain/model/shipment/ShipmentPayRequest;", "(Ljava/lang/String;Lir/postex/pos/domain/model/shipment/ShipmentPayRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "topUp", "Lir/postex/pos/domain/model/topup/TopUpResponse;", "id", "signature", "Lir/postex/pos/domain/model/topup/TopUpRequest;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lir/postex/pos/domain/model/topup/TopUpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public abstract interface MainServices {
    
    @retrofit2.http.GET(value = "/api/app/v1/wallet/balance")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBalance(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<ir.postex.pos.domain.model.balance.BalanceResponse>> $completion);
    
    @retrofit2.http.GET(value = "/api/app/v1/pos/shipment/{id}/amount")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAmount(@retrofit2.http.Header(value = "x-device-serial-no")
    @org.jetbrains.annotations.NotNull()
    java.lang.String deviceSerialNo, @retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String requestId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<ir.postex.pos.domain.model.inquiry.InquiryResponse>> $completion);
    
    @retrofit2.http.POST(value = "/api/app/v1/pos/top-up")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object topUp(@retrofit2.http.Header(value = "x-device-serial-no")
    @org.jetbrains.annotations.NotNull()
    java.lang.String deviceSerialNo, @retrofit2.http.Header(value = "x-user-id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String id, @retrofit2.http.Header(value = "x-signature")
    @org.jetbrains.annotations.NotNull()
    java.lang.String signature, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    ir.postex.pos.domain.model.topup.TopUpRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<ir.postex.pos.domain.model.topup.TopUpResponse>> $completion);
    
    @retrofit2.http.POST(value = "/api/app/v1/pos/shipment/{parcelNo}/pay")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object postShipmentPay(@retrofit2.http.Path(value = "parcelNo")
    @org.jetbrains.annotations.NotNull()
    java.lang.String parcelNo, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    ir.postex.pos.domain.model.shipment.ShipmentPayRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<ir.postex.pos.domain.model.enroll.EnrollResponse>> $completion);
    
    @retrofit2.http.GET(value = "/api/app/v1/pos/report/summary/daily")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getDailyReport(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<ir.postex.pos.domain.model.report.DailyReportItem>>> $completion);
    
    @retrofit2.http.GET(value = "/api/app/v1/pos/report/transactions")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTransactions(@retrofit2.http.Query(value = "fromDate")
    @org.jetbrains.annotations.NotNull()
    java.lang.String fromDate, @retrofit2.http.Query(value = "toDate")
    @org.jetbrains.annotations.NotNull()
    java.lang.String toDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<ir.postex.pos.domain.model.report.TransactionsItem>>> $completion);
}