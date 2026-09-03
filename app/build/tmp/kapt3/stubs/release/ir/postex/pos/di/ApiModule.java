package ir.postex.pos.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\t"}, d2 = {"Lir/postex/pos/di/ApiModule;", "", "()V", "provideServiceWithOutToken", "Lir/postex/pos/data/source/remote/Services;", "retrofit", "Lretrofit2/Retrofit;", "provideServiceWithToken", "Lir/postex/pos/data/source/remote/network/MainServices;", "app_release"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class ApiModule {
    
    public ApiModule() {
        super();
    }
    
    @javax.inject.Singleton()
    @dagger.Provides()
    @javax.inject.Named(value = "without_token")
    @org.jetbrains.annotations.NotNull()
    public final ir.postex.pos.data.source.remote.Services provideServiceWithOutToken(@javax.inject.Named(value = "without_token")
    @org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @javax.inject.Singleton()
    @dagger.Provides()
    @javax.inject.Named(value = "with_token")
    @org.jetbrains.annotations.NotNull()
    public final ir.postex.pos.data.source.remote.network.MainServices provideServiceWithToken(@javax.inject.Named(value = "with_token")
    @org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
}