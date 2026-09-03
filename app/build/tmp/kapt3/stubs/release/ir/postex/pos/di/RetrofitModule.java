package ir.postex.pos.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\u000eH\u0007J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J \u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u001a\u0010\u0018\u001a\u00020\u00192\b\b\u0001\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u000eH\u0007J\u001a\u0010\u001c\u001a\u00020\u00192\b\b\u0001\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u000eH\u0007J\u001a\u0010\u001d\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u001e\u001a\u00020\u001fH\u0007\u00a8\u0006 "}, d2 = {"Lir/postex/pos/di/RetrofitModule;", "", "()V", "provideChuckerInterceptor", "Lcom/chuckerteam/chucker/api/ChuckerInterceptor;", "context", "Landroid/content/Context;", "provideHeaderInterceptor", "Lir/postex/pos/data/source/remote/network/HeaderInterceptor;", "dataStoreManager", "Lir/postex/pos/data/source/local/DataStoreManager;", "provideHttpLoggingInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "provideMoshi", "Lcom/squareup/moshi/Moshi;", "provideOkHttpClientWithToken", "Lokhttp3/OkHttpClient;", "chuckerInterceptor", "headerInterceptor", "prettyLogInterceptor", "Lir/postex/pos/di/PrettyLogInterceptor;", "tokenAuthenticator", "Lir/postex/pos/data/source/remote/network/TokenAuthenticator;", "provideOkHttpClientWithoutToken", "provideRetrofitWithToken", "Lretrofit2/Retrofit;", "okHttpClient", "moshi", "provideRetrofitWithoutToken", "provideTokenAuthenticator", "service", "Lir/postex/pos/data/source/remote/Services;", "app_release"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class RetrofitModule {
    
    public RetrofitModule() {
        super();
    }
    
    @javax.inject.Singleton()
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.logging.HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.chuckerteam.chucker.api.ChuckerInterceptor provideChuckerInterceptor(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @javax.inject.Singleton()
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final ir.postex.pos.data.source.remote.network.HeaderInterceptor provideHeaderInterceptor(@org.jetbrains.annotations.NotNull()
    ir.postex.pos.data.source.local.DataStoreManager dataStoreManager) {
        return null;
    }
    
    @javax.inject.Named(value = "with_token")
    @javax.inject.Singleton()
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.OkHttpClient provideOkHttpClientWithToken(@org.jetbrains.annotations.NotNull()
    com.chuckerteam.chucker.api.ChuckerInterceptor chuckerInterceptor, @org.jetbrains.annotations.NotNull()
    ir.postex.pos.data.source.remote.network.HeaderInterceptor headerInterceptor, @org.jetbrains.annotations.NotNull()
    ir.postex.pos.di.PrettyLogInterceptor prettyLogInterceptor, @org.jetbrains.annotations.NotNull()
    ir.postex.pos.data.source.remote.network.TokenAuthenticator tokenAuthenticator) {
        return null;
    }
    
    @javax.inject.Named(value = "without_token")
    @javax.inject.Singleton()
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.OkHttpClient provideOkHttpClientWithoutToken(@org.jetbrains.annotations.NotNull()
    com.chuckerteam.chucker.api.ChuckerInterceptor chuckerInterceptor, @org.jetbrains.annotations.NotNull()
    ir.postex.pos.data.source.remote.network.HeaderInterceptor headerInterceptor, @org.jetbrains.annotations.NotNull()
    ir.postex.pos.di.PrettyLogInterceptor prettyLogInterceptor) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.squareup.moshi.Moshi provideMoshi() {
        return null;
    }
    
    @javax.inject.Named(value = "with_token")
    @javax.inject.Singleton()
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit provideRetrofitWithToken(@javax.inject.Named(value = "with_token")
    @org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient okHttpClient, @org.jetbrains.annotations.NotNull()
    com.squareup.moshi.Moshi moshi) {
        return null;
    }
    
    @javax.inject.Named(value = "without_token")
    @javax.inject.Singleton()
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit provideRetrofitWithoutToken(@javax.inject.Named(value = "without_token")
    @org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient okHttpClient, @org.jetbrains.annotations.NotNull()
    com.squareup.moshi.Moshi moshi) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final ir.postex.pos.data.source.remote.network.TokenAuthenticator provideTokenAuthenticator(@org.jetbrains.annotations.NotNull()
    ir.postex.pos.data.source.local.DataStoreManager dataStoreManager, @javax.inject.Named(value = "without_token")
    @org.jetbrains.annotations.NotNull()
    ir.postex.pos.data.source.remote.Services service) {
        return null;
    }
}