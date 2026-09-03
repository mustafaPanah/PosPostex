package ir.postex.pos.data.source.remote.network;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002JE\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00050\u0004\"\b\b\u0000\u0010\u0006*\u00020\u00012\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lir/postex/pos/data/source/remote/network/SafeApiRequest;", "", "()V", "apiRequest", "Lkotlinx/coroutines/flow/Flow;", "Lir/postex/pos/data/source/remote/network/Resource;", "T", "call", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lretrofit2/Response;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "app_debug"})
public abstract class SafeApiRequest {
    
    public SafeApiRequest() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>kotlinx.coroutines.flow.Flow<ir.postex.pos.data.source.remote.network.Resource<T>> apiRequest(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super retrofit2.Response<T>>, ? extends java.lang.Object> call) {
        return null;
    }
}