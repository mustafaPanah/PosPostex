package ir.postex.pos.domain.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\n\b\u0001\u0010\u0002 \u0001*\u00020\u00032\u00020\u0004:\u0002\u0005\u0006\u0082\u0001\u0002\u0007\b\u00a8\u0006\t"}, d2 = {"Lir/postex/pos/domain/model/ResourceE;", "D", "E", "Lir/postex/pos/domain/model/Error;", "", "Error", "Success", "Lir/postex/pos/domain/model/ResourceE$Error;", "Lir/postex/pos/domain/model/ResourceE$Success;", "app_release"})
public abstract interface ResourceE<D extends java.lang.Object, E extends ir.postex.pos.domain.model.Error> {
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u0000*\u000e\b\u0002\u0010\u0001 \u0001*\u00060\u0002j\u0002`\u00032\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00010\u0004B\r\u0012\u0006\u0010\u0006\u001a\u00028\u0002\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\u000b\u001a\u00028\u0002H\u00c6\u0003\u00a2\u0006\u0002\u0010\tJ\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u0002H\u00c6\u0001\u00a2\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0013\u0010\u0006\u001a\u00028\u0002\u00a2\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0016"}, d2 = {"Lir/postex/pos/domain/model/ResourceE$Error;", "E", "Lir/postex/pos/domain/model/Error;", "Lir/postex/pos/domain/model/DomainError;", "Lir/postex/pos/domain/model/ResourceE;", "", "error", "(Lir/postex/pos/domain/model/Error;)V", "getError", "()Lir/postex/pos/domain/model/Error;", "Lir/postex/pos/domain/model/Error;", "component1", "copy", "(Lir/postex/pos/domain/model/Error;)Lir/postex/pos/domain/model/ResourceE$Error;", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"})
    public static final class Error<E extends ir.postex.pos.domain.model.Error> implements ir.postex.pos.domain.model.ResourceE {
        @org.jetbrains.annotations.NotNull()
        private final E error = null;
        
        public Error(@org.jetbrains.annotations.NotNull()
        E error) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final E getError() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final E component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final ir.postex.pos.domain.model.ResourceE.Error<E> copy(@org.jetbrains.annotations.NotNull()
        E error) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u0000*\u0006\b\u0002\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0002\u00a2\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0002H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u0002H\u00c6\u0001\u00a2\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001R\u0013\u0010\u0004\u001a\u00028\u0002\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0014"}, d2 = {"Lir/postex/pos/domain/model/ResourceE$Success;", "D", "Lir/postex/pos/domain/model/ResourceE;", "", "data", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lir/postex/pos/domain/model/ResourceE$Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"})
    public static final class Success<D extends java.lang.Object> implements ir.postex.pos.domain.model.ResourceE {
        private final D data = null;
        
        public Success(D data) {
            super();
        }
        
        public final D getData() {
            return null;
        }
        
        public final D component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final ir.postex.pos.domain.model.ResourceE.Success<D> copy(D data) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}