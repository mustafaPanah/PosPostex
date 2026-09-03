package ir.postex.pos.data.source.remote.network.presentation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J.\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\t2\u0018\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\r0\f0\u000bH\u00a6@\u00a2\u0006\u0002\u0010\u000eR\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lir/postex/pos/data/source/remote/network/presentation/DataLoadingViewModelDelegate;", "", "dataLoadingState", "Lkotlinx/coroutines/flow/SharedFlow;", "Lir/postex/pos/data/source/remote/network/presentation/LoadDataState;", "getDataLoadingState", "()Lkotlinx/coroutines/flow/SharedFlow;", "loadData", "", "T", "call", "Lkotlin/Function0;", "Lir/postex/pos/domain/model/ResourceE;", "Lir/postex/pos/domain/model/NetworkError;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public abstract interface DataLoadingViewModelDelegate {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.SharedFlow<ir.postex.pos.data.source.remote.network.presentation.LoadDataState> getDataLoadingState();
    
    @org.jetbrains.annotations.Nullable()
    public abstract <T extends java.lang.Object>java.lang.Object loadData(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<? extends ir.postex.pos.domain.model.ResourceE<? extends T, ? extends ir.postex.pos.domain.model.NetworkError>> call, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}