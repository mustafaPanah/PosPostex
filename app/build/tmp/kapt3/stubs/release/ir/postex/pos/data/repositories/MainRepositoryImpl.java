package ir.postex.pos.data.repositories;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\"\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\f\u001a\u00020\rH\u0096@\u00a2\u0006\u0002\u0010\u000eJ\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\n0\tH\u0096@\u00a2\u0006\u0002\u0010\u0011J \u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\n0\tH\u0096@\u00a2\u0006\u0002\u0010\u0011J0\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00130\n0\t2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rH\u0096@\u00a2\u0006\u0002\u0010\u0019J*\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\n0\t2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0096@\u00a2\u0006\u0002\u0010\u001fJ*\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\n0\t2\u0006\u0010\u001d\u001a\u00020\"2\u0006\u0010#\u001a\u00020\rH\u0096@\u00a2\u0006\u0002\u0010$R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lir/postex/pos/data/repositories/MainRepositoryImpl;", "Lir/postex/pos/domain/repositories/MainRepository;", "Lir/postex/pos/data/source/remote/network/SafeApiRequest;", "mServices", "Lir/postex/pos/data/source/remote/network/MainServices;", "dataStoreManager", "Lir/postex/pos/data/source/local/DataStoreManager;", "(Lir/postex/pos/data/source/remote/network/MainServices;Lir/postex/pos/data/source/local/DataStoreManager;)V", "getAmount", "Lkotlinx/coroutines/flow/Flow;", "Lir/postex/pos/data/source/remote/network/Resource;", "Lir/postex/pos/domain/model/inquiry/InquiryResponse;", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBalance", "Lir/postex/pos/domain/model/balance/BalanceResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDailyReport", "", "Lir/postex/pos/domain/model/report/DailyReportItem;", "getTransactions", "Lir/postex/pos/domain/model/report/TransactionsItem;", "fromDate", "toDate", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postShipmentPay", "Lir/postex/pos/domain/model/enroll/EnrollResponse;", "parcelNo", "request", "Lir/postex/pos/domain/model/shipment/ShipmentPayRequest;", "(Ljava/lang/String;Lir/postex/pos/domain/model/shipment/ShipmentPayRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "topUp", "Lir/postex/pos/domain/model/topup/TopUpResponse;", "Lir/postex/pos/domain/model/topup/TopUpRequest;", "sign", "(Lir/postex/pos/domain/model/topup/TopUpRequest;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public final class MainRepositoryImpl extends ir.postex.pos.data.source.remote.network.SafeApiRequest implements ir.postex.pos.domain.repositories.MainRepository {
    @org.jetbrains.annotations.NotNull()
    private final ir.postex.pos.data.source.remote.network.MainServices mServices = null;
    @org.jetbrains.annotations.NotNull()
    private final ir.postex.pos.data.source.local.DataStoreManager dataStoreManager = null;
    
    @javax.inject.Inject()
    public MainRepositoryImpl(@javax.inject.Named(value = "with_token")
    @org.jetbrains.annotations.NotNull()
    ir.postex.pos.data.source.remote.network.MainServices mServices, @org.jetbrains.annotations.NotNull()
    ir.postex.pos.data.source.local.DataStoreManager dataStoreManager) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getBalance(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends ir.postex.pos.data.source.remote.network.Resource<ir.postex.pos.domain.model.balance.BalanceResponse>>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getDailyReport(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends ir.postex.pos.data.source.remote.network.Resource<java.util.List<ir.postex.pos.domain.model.report.DailyReportItem>>>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object topUp(@org.jetbrains.annotations.NotNull()
    ir.postex.pos.domain.model.topup.TopUpRequest request, @org.jetbrains.annotations.NotNull()
    java.lang.String sign, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends ir.postex.pos.data.source.remote.network.Resource<ir.postex.pos.domain.model.topup.TopUpResponse>>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getAmount(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends ir.postex.pos.data.source.remote.network.Resource<ir.postex.pos.domain.model.inquiry.InquiryResponse>>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object postShipmentPay(@org.jetbrains.annotations.NotNull()
    java.lang.String parcelNo, @org.jetbrains.annotations.NotNull()
    ir.postex.pos.domain.model.shipment.ShipmentPayRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends ir.postex.pos.data.source.remote.network.Resource<ir.postex.pos.domain.model.enroll.EnrollResponse>>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getTransactions(@org.jetbrains.annotations.NotNull()
    java.lang.String fromDate, @org.jetbrains.annotations.NotNull()
    java.lang.String toDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends ir.postex.pos.data.source.remote.network.Resource<java.util.List<ir.postex.pos.domain.model.report.TransactionsItem>>>> $completion) {
        return null;
    }
}