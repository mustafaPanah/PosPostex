package ir.postex.pos.domain.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001aR\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\b\b\u0001\u0010\u0003*\u00020\u0005\"\u0004\b\u0002\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u0006H\u0086\b\u00f8\u0001\u0000\u001aL\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\b\b\u0001\u0010\u0003*\u00020\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\t0\u0006H\u0086\b\u00f8\u0001\u0000\u001aL\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\b\b\u0001\u0010\u0003*\u00020\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\t0\u0006H\u0086\b\u00f8\u0001\u0000*\n\u0010\u000b\"\u00020\u00052\u00020\u0005\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\f"}, d2 = {"map", "Lir/postex/pos/domain/model/ResourceE;", "R", "E", "T", "Lir/postex/pos/domain/model/Error;", "Lkotlin/Function1;", "onError", "action", "", "onSuccess", "DomainError", "app_release"})
public final class ResourceEKt {
    
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object, E extends ir.postex.pos.domain.model.Error, R extends java.lang.Object>ir.postex.pos.domain.model.ResourceE<R, E> map(@org.jetbrains.annotations.NotNull()
    ir.postex.pos.domain.model.ResourceE<? extends T, ? extends E> $this$map, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, ? extends R> map) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object, E extends ir.postex.pos.domain.model.Error>ir.postex.pos.domain.model.ResourceE<T, E> onSuccess(@org.jetbrains.annotations.NotNull()
    ir.postex.pos.domain.model.ResourceE<? extends T, ? extends E> $this$onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> action) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object, E extends ir.postex.pos.domain.model.Error>ir.postex.pos.domain.model.ResourceE<T, E> onError(@org.jetbrains.annotations.NotNull()
    ir.postex.pos.domain.model.ResourceE<? extends T, ? extends E> $this$onError, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super E, kotlin.Unit> action) {
        return null;
    }
}