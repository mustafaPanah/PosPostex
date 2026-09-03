package ir.postex.pos.presentation.reportScreen;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0016\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"J\u0006\u0010$\u001a\u00020%R\"\u0010\t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0018\u00010\u000b0\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\f\u0018\u00010\u000b0\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R%\u0010\u0018\u001a\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0018\u00010\u000b0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR%\u0010\u001c\u001a\u0016\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\f\u0018\u00010\u000b0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001b\u00a8\u0006&"}, d2 = {"Lir/postex/pos/presentation/reportScreen/ReportViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lir/postex/pos/domain/repositories/MainRepository;", "dataStoreManager", "Lir/postex/pos/data/source/local/DataStoreManager;", "privateKeyStorage", "Lir/postex/pos/security/PrivateKeyStorage;", "(Lir/postex/pos/domain/repositories/MainRepository;Lir/postex/pos/data/source/local/DataStoreManager;Lir/postex/pos/security/PrivateKeyStorage;)V", "_stateGetDailyReport", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lir/postex/pos/data/source/remote/network/Resource;", "", "Lir/postex/pos/domain/model/report/DailyReportItem;", "_stateGetTransactions", "Lir/postex/pos/domain/model/report/TransactionsItem;", "<set-?>", "", "isLoading", "()Z", "setLoading", "(Z)V", "isLoading$delegate", "Landroidx/compose/runtime/MutableState;", "stateGetDailyReport", "Lkotlinx/coroutines/flow/StateFlow;", "getStateGetDailyReport", "()Lkotlinx/coroutines/flow/StateFlow;", "stateGetTransactions", "getStateGetTransactions", "getDailyReport", "Lkotlinx/coroutines/Job;", "getTransactions", "fromDate", "", "toDate", "setStateNull", "", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ReportViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final ir.postex.pos.domain.repositories.MainRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final ir.postex.pos.data.source.local.DataStoreManager dataStoreManager = null;
    @org.jetbrains.annotations.NotNull()
    private final ir.postex.pos.security.PrivateKeyStorage privateKeyStorage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState isLoading$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<ir.postex.pos.data.source.remote.network.Resource<java.util.List<ir.postex.pos.domain.model.report.DailyReportItem>>> _stateGetDailyReport;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<ir.postex.pos.data.source.remote.network.Resource<java.util.List<ir.postex.pos.domain.model.report.DailyReportItem>>> stateGetDailyReport = null;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<ir.postex.pos.data.source.remote.network.Resource<java.util.List<ir.postex.pos.domain.model.report.TransactionsItem>>> _stateGetTransactions;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<ir.postex.pos.data.source.remote.network.Resource<java.util.List<ir.postex.pos.domain.model.report.TransactionsItem>>> stateGetTransactions = null;
    
    @javax.inject.Inject()
    public ReportViewModel(@org.jetbrains.annotations.NotNull()
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
    public final kotlinx.coroutines.flow.StateFlow<ir.postex.pos.data.source.remote.network.Resource<java.util.List<ir.postex.pos.domain.model.report.DailyReportItem>>> getStateGetDailyReport() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<ir.postex.pos.data.source.remote.network.Resource<java.util.List<ir.postex.pos.domain.model.report.TransactionsItem>>> getStateGetTransactions() {
        return null;
    }
    
    private final kotlinx.coroutines.Job getDailyReport() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getTransactions(@org.jetbrains.annotations.NotNull()
    java.lang.String fromDate, @org.jetbrains.annotations.NotNull()
    java.lang.String toDate) {
        return null;
    }
    
    public final void setStateNull() {
    }
}