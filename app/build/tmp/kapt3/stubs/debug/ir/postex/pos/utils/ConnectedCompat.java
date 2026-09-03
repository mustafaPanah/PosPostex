package ir.postex.pos.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0003\t\n\u000bB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lir/postex/pos/utils/ConnectedCompat;", "", "()V", "IMPL", "Lir/postex/pos/utils/ConnectedCompat$ConnectedCompatImpl;", "isConnected", "", "connectivityManager", "Landroid/net/ConnectivityManager;", "BaseImpl", "ConnectedCompatImpl", "MarshMallowImpl", "app_debug"})
public final class ConnectedCompat {
    @org.jetbrains.annotations.NotNull()
    private static final ir.postex.pos.utils.ConnectedCompat.ConnectedCompatImpl IMPL = null;
    @org.jetbrains.annotations.NotNull()
    public static final ir.postex.pos.utils.ConnectedCompat INSTANCE = null;
    
    private ConnectedCompat() {
        super();
    }
    
    public final boolean isConnected(@org.jetbrains.annotations.NotNull()
    android.net.ConnectivityManager connectivityManager) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lir/postex/pos/utils/ConnectedCompat$BaseImpl;", "Lir/postex/pos/utils/ConnectedCompat$ConnectedCompatImpl;", "()V", "isConnected", "", "connectivityManager", "Landroid/net/ConnectivityManager;", "app_debug"})
    public static final class BaseImpl implements ir.postex.pos.utils.ConnectedCompat.ConnectedCompatImpl {
        @org.jetbrains.annotations.NotNull()
        public static final ir.postex.pos.utils.ConnectedCompat.BaseImpl INSTANCE = null;
        
        private BaseImpl() {
            super();
        }
        
        @java.lang.Override()
        @kotlin.Suppress(names = {"DEPRECATION"})
        public boolean isConnected(@org.jetbrains.annotations.NotNull()
        android.net.ConnectivityManager connectivityManager) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lir/postex/pos/utils/ConnectedCompat$ConnectedCompatImpl;", "", "isConnected", "", "connectivityManager", "Landroid/net/ConnectivityManager;", "app_debug"})
    public static abstract interface ConnectedCompatImpl {
        
        public abstract boolean isConnected(@org.jetbrains.annotations.NotNull()
        android.net.ConnectivityManager connectivityManager);
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lir/postex/pos/utils/ConnectedCompat$MarshMallowImpl;", "Lir/postex/pos/utils/ConnectedCompat$ConnectedCompatImpl;", "()V", "isConnected", "", "connectivityManager", "Landroid/net/ConnectivityManager;", "app_debug"})
    public static final class MarshMallowImpl implements ir.postex.pos.utils.ConnectedCompat.ConnectedCompatImpl {
        @org.jetbrains.annotations.NotNull()
        public static final ir.postex.pos.utils.ConnectedCompat.MarshMallowImpl INSTANCE = null;
        
        private MarshMallowImpl() {
            super();
        }
        
        @java.lang.Override()
        public boolean isConnected(@org.jetbrains.annotations.NotNull()
        android.net.ConnectivityManager connectivityManager) {
            return false;
        }
    }
}