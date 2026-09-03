package ir.postex.pos.domain.repositories;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00a2\u0006\u0002\u0010\bJ\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u000bJ \u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u00040\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u000bJ0\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\u00040\u00032\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u00a6@\u00a2\u0006\u0002\u0010\u0013J*\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00040\u00032\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u00a6@\u00a2\u0006\u0002\u0010\u0019J*\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00040\u00032\u0006\u0010\u0017\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0007H\u00a6@\u00a2\u0006\u0002\u0010\u001e\u00a8\u0006\u001f"}, d2 = {"Lir/postex/pos/domain/repositories/MainRepository;", "", "getAmount", "Lkotlinx/coroutines/flow/Flow;", "Lir/postex/pos/data/source/remote/network/Resource;", "Lir/postex/pos/domain/model/inquiry/InquiryResponse;", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBalance", "Lir/postex/pos/domain/model/balance/BalanceResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDailyReport", "", "Lir/postex/pos/domain/model/report/DailyReportItem;", "getTransactions", "Lir/postex/pos/domain/model/report/TransactionsItem;", "fromDate", "toDate", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postShipmentPay", "Lir/postex/pos/domain/model/enroll/EnrollResponse;", "parcelNo", "request", "Lir/postex/pos/domain/model/shipment/ShipmentPayRequest;", "(Ljava/lang/String;Lir/postex/pos/domain/model/shipment/ShipmentPayRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "topUp", "Lir/postex/pos/domain/model/topup/TopUpResponse;", "Lir/postex/pos/domain/model/topup/TopUpRequest;", "sign", "(Lir/postex/pos/domain/model/topup/TopUpRequest;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public abstract interface MainRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBalance(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends ir.postex.pos.data.source.remote.network.Resource<ir.postex.pos.domain.model.balance.BalanceResponse>>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getDailyReport(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends ir.postex.pos.data.source.remote.network.Resource<java.util.List<ir.postex.pos.domain.model.report.DailyReportItem>>>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object topUp(@org.jetbrains.annotations.NotNull()
    ir.postex.pos.domain.model.topup.TopUpRequest request, @org.jetbrains.annotations.NotNull()
    java.lang.String sign, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends ir.postex.pos.data.source.remote.network.Resource<ir.postex.pos.domain.model.topup.TopUpResponse>>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAmount(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends ir.postex.pos.data.source.remote.network.Resource<ir.postex.pos.domain.model.inquiry.InquiryResponse>>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTransactions(@org.jetbrains.annotations.NotNull()
    java.lang.String fromDate, @org.jetbrains.annotations.NotNull()
    java.lang.String toDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends ir.postex.pos.data.source.remote.network.Resource<java.util.List<ir.postex.pos.domain.model.report.TransactionsItem>>>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object postShipmentPay(@org.jetbrains.annotations.NotNull()
    java.lang.String parcelNo, @org.jetbrains.annotations.NotNull()
    ir.postex.pos.domain.model.shipment.ShipmentPayRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends ir.postex.pos.data.source.remote.network.Resource<ir.postex.pos.domain.model.enroll.EnrollResponse>>> $completion);
}