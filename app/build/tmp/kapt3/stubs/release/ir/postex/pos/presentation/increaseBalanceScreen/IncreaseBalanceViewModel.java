package ir.postex.pos.presentation.increaseBalanceScreen;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ \u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010 J\u0006\u0010%\u001a\u00020&J\u000e\u0010\'\u001a\u00020\"2\u0006\u0010(\u001a\u00020 J\u000e\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020\"J\u0018\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020.H\u0002J\u000e\u0010/\u001a\u00020&2\u0006\u00100\u001a\u000201R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r0\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r0\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\u0019\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r0\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001f\u0010\u001d\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r0\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001c\u00a8\u00062"}, d2 = {"Lir/postex/pos/presentation/increaseBalanceScreen/IncreaseBalanceViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lir/postex/pos/domain/repositories/MainRepository;", "dataStoreManager", "Lir/postex/pos/data/source/local/DataStoreManager;", "moshi", "Lcom/squareup/moshi/Moshi;", "privateKeyStorage", "Lir/postex/pos/security/PrivateKeyStorage;", "(Lir/postex/pos/domain/repositories/MainRepository;Lir/postex/pos/data/source/local/DataStoreManager;Lcom/squareup/moshi/Moshi;Lir/postex/pos/security/PrivateKeyStorage;)V", "_stateGetBalance", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lir/postex/pos/data/source/remote/network/Resource;", "Lir/postex/pos/domain/model/balance/BalanceResponse;", "_stateTopUp", "Lir/postex/pos/domain/model/topup/TopUpResponse;", "<set-?>", "", "isLoading", "()Z", "setLoading", "(Z)V", "isLoading$delegate", "Landroidx/compose/runtime/MutableState;", "stateTopUp", "Lkotlinx/coroutines/flow/StateFlow;", "getStateTopUp", "()Lkotlinx/coroutines/flow/StateFlow;", "stateteGetBalance", "getStateteGetBalance", "buildCanonicalRequest", "", "method", "", "path", "rawBody", "getBalance", "Lkotlinx/coroutines/Job;", "sha256FromBytes", "bytes", "sha256Hex", "input", "signCanonical", "canonical", "privateKey", "Ljava/security/PrivateKey;", "topUP", "request", "Lir/postex/pos/domain/model/topup/TopUpRequest;", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class IncreaseBalanceViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final ir.postex.pos.domain.repositories.MainRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final ir.postex.pos.data.source.local.DataStoreManager dataStoreManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.squareup.moshi.Moshi moshi = null;
    @org.jetbrains.annotations.NotNull()
    private final ir.postex.pos.security.PrivateKeyStorage privateKeyStorage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState isLoading$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<ir.postex.pos.data.source.remote.network.Resource<ir.postex.pos.domain.model.balance.BalanceResponse>> _stateGetBalance;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<ir.postex.pos.data.source.remote.network.Resource<ir.postex.pos.domain.model.balance.BalanceResponse>> stateteGetBalance = null;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<ir.postex.pos.data.source.remote.network.Resource<ir.postex.pos.domain.model.topup.TopUpResponse>> _stateTopUp;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<ir.postex.pos.data.source.remote.network.Resource<ir.postex.pos.domain.model.topup.TopUpResponse>> stateTopUp = null;
    
    @javax.inject.Inject()
    public IncreaseBalanceViewModel(@org.jetbrains.annotations.NotNull()
    ir.postex.pos.domain.repositories.MainRepository repository, @org.jetbrains.annotations.NotNull()
    ir.postex.pos.data.source.local.DataStoreManager dataStoreManager, @org.jetbrains.annotations.NotNull()
    com.squareup.moshi.Moshi moshi, @org.jetbrains.annotations.NotNull()
    ir.postex.pos.security.PrivateKeyStorage privateKeyStorage) {
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
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<ir.postex.pos.data.source.remote.network.Resource<ir.postex.pos.domain.model.topup.TopUpResponse>> getStateTopUp() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getBalance() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job topUP(@org.jetbrains.annotations.NotNull()
    ir.postex.pos.domain.model.topup.TopUpRequest request) {
        return null;
    }
    
    private final java.lang.String signCanonical(java.lang.String canonical, java.security.PrivateKey privateKey) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String sha256FromBytes(@org.jetbrains.annotations.NotNull()
    byte[] bytes) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] buildCanonicalRequest(@org.jetbrains.annotations.NotNull()
    java.lang.String method, @org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.Nullable()
    byte[] rawBody) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String sha256Hex(@org.jetbrains.annotations.NotNull()
    java.lang.String input) {
        return null;
    }
}