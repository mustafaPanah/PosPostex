package ir.postex.pos.di;

import com.chuckerteam.chucker.api.ChuckerInterceptor;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ir.postex.pos.data.source.remote.network.HeaderInterceptor;
import ir.postex.pos.data.source.remote.network.TokenAuthenticator;
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
public final class RetrofitModule_ProvideOkHttpClientWithTokenFactory implements Factory<OkHttpClient> {
  private final RetrofitModule module;

  private final Provider<ChuckerInterceptor> chuckerInterceptorProvider;

  private final Provider<HeaderInterceptor> headerInterceptorProvider;

  private final Provider<PrettyLogInterceptor> prettyLogInterceptorProvider;

  private final Provider<TokenAuthenticator> tokenAuthenticatorProvider;

  public RetrofitModule_ProvideOkHttpClientWithTokenFactory(RetrofitModule module,
      Provider<ChuckerInterceptor> chuckerInterceptorProvider,
      Provider<HeaderInterceptor> headerInterceptorProvider,
      Provider<PrettyLogInterceptor> prettyLogInterceptorProvider,
      Provider<TokenAuthenticator> tokenAuthenticatorProvider) {
    this.module = module;
    this.chuckerInterceptorProvider = chuckerInterceptorProvider;
    this.headerInterceptorProvider = headerInterceptorProvider;
    this.prettyLogInterceptorProvider = prettyLogInterceptorProvider;
    this.tokenAuthenticatorProvider = tokenAuthenticatorProvider;
  }

  @Override
  public OkHttpClient get() {
    return provideOkHttpClientWithToken(module, chuckerInterceptorProvider.get(), headerInterceptorProvider.get(), prettyLogInterceptorProvider.get(), tokenAuthenticatorProvider.get());
  }

  public static RetrofitModule_ProvideOkHttpClientWithTokenFactory create(RetrofitModule module,
      Provider<ChuckerInterceptor> chuckerInterceptorProvider,
      Provider<HeaderInterceptor> headerInterceptorProvider,
      Provider<PrettyLogInterceptor> prettyLogInterceptorProvider,
      Provider<TokenAuthenticator> tokenAuthenticatorProvider) {
    return new RetrofitModule_ProvideOkHttpClientWithTokenFactory(module, chuckerInterceptorProvider, headerInterceptorProvider, prettyLogInterceptorProvider, tokenAuthenticatorProvider);
  }

  public static OkHttpClient provideOkHttpClientWithToken(RetrofitModule instance,
      ChuckerInterceptor chuckerInterceptor, HeaderInterceptor headerInterceptor,
      PrettyLogInterceptor prettyLogInterceptor, TokenAuthenticator tokenAuthenticator) {
    return Preconditions.checkNotNullFromProvides(instance.provideOkHttpClientWithToken(chuckerInterceptor, headerInterceptor, prettyLogInterceptor, tokenAuthenticator));
  }
}
