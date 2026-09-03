package ir.postex.pos.data.source.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007\u00a8\u0006\u001c"}, d2 = {"Lir/postex/pos/data/source/local/DataStoreConstants;", "", "()V", "ACCESS_TOKEN", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "getACCESS_TOKEN", "()Landroidx/datastore/preferences/core/Preferences$Key;", "DATASTORE_NAME", "DEVICE_ID", "getDEVICE_ID", "IS_DEVICE_CONFIGURED", "", "getIS_DEVICE_CONFIGURED", "IS_SIGNED_IN", "getIS_SIGNED_IN", "MERCHANT_ID", "getMERCHANT_ID", "REFRESH_TOKEN", "getREFRESH_TOKEN", "SERIAL", "getSERIAL", "TERMINAL_ID", "getTERMINAL_ID", "USER_ID", "getUSER_ID", "USER_ID_NET", "getUSER_ID_NET", "app_release"})
public final class DataStoreConstants {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATASTORE_NAME = "default_datastore";
    @org.jetbrains.annotations.NotNull()
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> ACCESS_TOKEN = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> IS_SIGNED_IN = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> TERMINAL_ID = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> MERCHANT_ID = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> IS_DEVICE_CONFIGURED = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> DEVICE_ID = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> USER_ID = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> USER_ID_NET = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> SERIAL = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> REFRESH_TOKEN = null;
    @org.jetbrains.annotations.NotNull()
    public static final ir.postex.pos.data.source.local.DataStoreConstants INSTANCE = null;
    
    private DataStoreConstants() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> getACCESS_TOKEN() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> getIS_SIGNED_IN() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> getTERMINAL_ID() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> getMERCHANT_ID() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> getIS_DEVICE_CONFIGURED() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> getDEVICE_ID() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> getUSER_ID() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> getUSER_ID_NET() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> getSERIAL() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> getREFRESH_TOKEN() {
        return null;
    }
}