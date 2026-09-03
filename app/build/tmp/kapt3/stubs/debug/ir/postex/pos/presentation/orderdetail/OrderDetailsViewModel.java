package ir.postex.pos.presentation.orderdetail;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020 R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006!"}, d2 = {"Lir/postex/pos/presentation/orderdetail/OrderDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lir/postex/pos/domain/repositories/MainRepository;", "dataStoreManager", "Lir/postex/pos/data/source/local/DataStoreManager;", "privateKeyStorage", "Lir/postex/pos/security/PrivateKeyStorage;", "(Lir/postex/pos/domain/repositories/MainRepository;Lir/postex/pos/data/source/local/DataStoreManager;Lir/postex/pos/security/PrivateKeyStorage;)V", "_stateGetAmuont", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lir/postex/pos/data/source/remote/network/Resource;", "Lir/postex/pos/domain/model/enroll/EnrollResponse;", "<set-?>", "", "isLoading", "()Z", "setLoading", "(Z)V", "isLoading$delegate", "Landroidx/compose/runtime/MutableState;", "stateGetAmuont", "Lkotlinx/coroutines/flow/StateFlow;", "getStateGetAmuont", "()Lkotlinx/coroutines/flow/StateFlow;", "postShipmentPay", "Lkotlinx/coroutines/Job;", "parcelNo", "", "request", "Lir/postex/pos/domain/model/shipment/ShipmentPayRequest;", "setStateNull", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class OrderDetailsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final ir.postex.pos.domain.repositories.MainRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final ir.postex.pos.data.source.local.DataStoreManager dataStoreManager = null;
    @org.jetbrains.annotations.NotNull()
    private final ir.postex.pos.security.PrivateKeyStorage privateKeyStorage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState isLoading$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<ir.postex.pos.data.source.remote.network.Resource<ir.postex.pos.domain.model.enroll.EnrollResponse>> _stateGetAmuont;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<ir.postex.pos.data.source.remote.network.Resource<ir.postex.pos.domain.model.enroll.EnrollResponse>> stateGetAmuont = null;
    
    @javax.inject.Inject()
    public OrderDetailsViewModel(@org.jetbrains.annotations.NotNull()
    ir.postex.pos.domain.repositories.MainRepository repository, @org.jetbrains.annotations.NotNull()
    ir.postex.pos.data.source.local.DataStoreManager dataStoreManager, @org.jetbrains.annotations.NotNull()
    ir.postex.pos.security.PrivateKeyStorage privateKeyStorage) {
        super();
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    private final void setLoading(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<ir.postex.pos.data.source.remote.network.Resource<ir.postex.pos.domain.model.enroll.EnrollResponse>> getStateGetAmuont() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job postShipmentPay(@org.jetbrains.annotations.NotNull()
    java.lang.String parcelNo, @org.jetbrains.annotations.NotNull()
    ir.postex.pos.domain.model.shipment.ShipmentPayRequest request) {
        return null;
    }
    
    public final void setStateNull() {
    }
}