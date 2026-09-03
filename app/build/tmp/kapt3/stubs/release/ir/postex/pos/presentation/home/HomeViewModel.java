package ir.postex.pos.presentation.home;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u001aH\u0086@\u00a2\u0006\u0002\u0010\u001bR\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R+\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lir/postex/pos/presentation/home/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lir/postex/pos/domain/repositories/MainRepository;", "store", "Lir/postex/pos/data/source/local/DataStoreManager;", "(Lir/postex/pos/domain/repositories/MainRepository;Lir/postex/pos/data/source/local/DataStoreManager;)V", "_stateGetBalance", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lir/postex/pos/data/source/remote/network/Resource;", "Lir/postex/pos/domain/model/balance/BalanceResponse;", "<set-?>", "", "isLoading", "()Z", "setLoading", "(Z)V", "isLoading$delegate", "Landroidx/compose/runtime/MutableState;", "stateteGetBalance", "Lkotlinx/coroutines/flow/StateFlow;", "getStateteGetBalance", "()Lkotlinx/coroutines/flow/StateFlow;", "getBalance", "Lkotlinx/coroutines/Job;", "getUserName", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final ir.postex.pos.domain.repositories.MainRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final ir.postex.pos.data.source.local.DataStoreManager store = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState isLoading$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<ir.postex.pos.data.source.remote.network.Resource<ir.postex.pos.domain.model.balance.BalanceResponse>> _stateGetBalance;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<ir.postex.pos.data.source.remote.network.Resource<ir.postex.pos.domain.model.balance.BalanceResponse>> stateteGetBalance = null;
    
    @javax.inject.Inject()
    public HomeViewModel(@org.jetbrains.annotations.NotNull()
    ir.postex.pos.domain.repositories.MainRepository repository, @org.jetbrains.annotations.NotNull()
    ir.postex.pos.data.source.local.DataStoreManager store) {
        super();
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    private final void setLoading(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<ir.postex.pos.data.source.remote.network.Resource<ir.postex.pos.domain.model.balance.BalanceResponse>> getStateteGetBalance() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getUserName(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getBalance() {
        return null;
    }
}