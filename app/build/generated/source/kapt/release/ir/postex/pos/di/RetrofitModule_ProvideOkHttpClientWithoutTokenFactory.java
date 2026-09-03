package ir.postex.pos.di;

import com.chuckerteam.chucker.api.ChuckerInterceptor;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ir.postex.pos.data.source.remote.network.HeaderInterceptor;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("javax.inject.Named")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class RetrofitModule_ProvideOkHttpClientWithoutTokenFactory implements Factory<OkHttpClient> {
  private final RetrofitModule module;

  private final Provider<ChuckerInterceptor> chuckerInterceptorProvider;

  private final Provider<HeaderInterceptor> headerInterceptorProvider;

  private final Provider<PrettyLogInterceptor> prettyLogInterceptorProvider;

  public RetrofitModule_ProvideOkHttpClientWithoutTokenFactory(RetrofitModule module,
      Provider<ChuckerInterceptor> chuckerInterceptorProvider,
      Provider<HeaderInterceptor> headerInterceptorProvider,
      Provider<PrettyLogInterceptor> prettyLogInterceptorProvider) {
    this.module = module;
    this.chuckerInterceptorProvider = chuckerInterceptorProvider;
    this.headerInterceptorProvider = headerInterceptorProvider;
    this.prettyLogInterceptorProvider = prettyLogInterceptorProvider;
  }

  @Override
  public OkHttpClient get() {
    return provideOkHttpClientWithoutToken(module, chuckerInterceptorProvider.get(), headerInterceptorProvider.get(), prettyLogInterceptorProvider.get());
  }

  public static RetrofitModule_ProvideOkHttpClientWithoutTokenFactory create(RetrofitModule module,
      Provider<ChuckerInterceptor> chuckerInterceptorProvider,
      Provider<HeaderInterceptor> headerInterceptorProvider,
      Provider<PrettyLogInterceptor> prettyLogInterceptorProvider) {
    return new RetrofitModule_ProvideOkHttpClientWithoutTokenFactory(module, chuckerInterceptorProvider, headerInterceptorProvider, prettyLogInterceptorProvider);
  }

  public static OkHttpClient provideOkHttpClientWithoutToken(RetrofitModule instance,
      ChuckerInterceptor chuckerInterceptor, HeaderInterceptor headerInterceptor,
      PrettyLogInterceptor prettyLogInterceptor) {
    return Preconditions.checkNotNullFromProvides(instance.provideOkHttpClientWithoutToken(chuckerInterceptor, headerInterceptor, prettyLogInterceptor));
  }
}
