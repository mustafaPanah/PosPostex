package ir.postex.pos.data.source.remote.network.presentation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J.\u0010\n\u001a\u00020\u000b\"\u0004\b\u0000\u0010\f2\u0018\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\u00100\u000f0\u000eH\u0096@\u00a2\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0012"}, d2 = {"Lir/postex/pos/data/source/remote/network/presentation/DataLoadingViewModelDelegateImpl;", "Lir/postex/pos/data/source/remote/network/presentation/DataLoadingViewModelDelegate;", "()V", "_dataLoadingState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lir/postex/pos/data/source/remote/network/presentation/LoadDataState;", "dataLoadingState", "Lkotlinx/coroutines/flow/StateFlow;", "getDataLoadingState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadData", "", "T", "call", "Lkotlin/Function0;", "Lir/postex/pos/domain/model/ResourceE;", "Lir/postex/pos/domain/model/NetworkError;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public final class DataLoadingViewModelDelegateImpl implements ir.postex.pos.data.source.remote.network.presentation.DataLoadingViewModelDelegate {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<ir.postex.pos.data.source.remote.network.presentation.LoadDataState> _dataLoadingState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<ir.postex.pos.data.source.remote.network.presentation.LoadDataState> dataLoadingState = null;
    
    public DataLoadingViewModelDelegateImpl() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.StateFlow<ir.postex.pos.data.source.remote.network.presentation.LoadDataState> getDataLoadingState() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public <T extends java.lang.Object>java.lang.Object loadData(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<? extends ir.postex.pos.domain.model.ResourceE<? extends T, ? extends ir.postex.pos.domain.model.NetworkError>> call, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}