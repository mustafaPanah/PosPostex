package ir.postex.pos.di;

import com.squareup.moshi.Moshi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

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
public final class RetrofitModule_ProvideRetrofitWithoutTokenFactory implements Factory<Retrofit> {
  private final RetrofitModule module;

  private final Provider<OkHttpClient> okHttpClientProvider;

  private final Provider<Moshi> moshiProvider;

  public RetrofitModule_ProvideRetrofitWithoutTokenFactory(RetrofitModule module,
      Provider<OkHttpClient> okHttpClientProvider, Provider<Moshi> moshiProvider) {
    this.module = module;
    this.okHttpClientProvider = okHttpClientProvider;
    this.moshiProvider = moshiProvider;
  }

  @Override
  public Retrofit get() {
    return provideRetrofitWithoutToken(module, okHttpClientProvider.get(), moshiProvider.get());
  }

  public static RetrofitModule_ProvideRetrofitWithoutTokenFactory create(RetrofitModule module,
      Provider<OkHttpClient> okHttpClientProvider, Provider<Moshi> moshiProvider) {
    return new RetrofitModule_ProvideRetrofitWithoutTokenFactory(module, okHttpClientProvider, moshiProvider);
  }

  public static Retrofit provideRetrofitWithoutToken(RetrofitModule instance,
      OkHttpClient okHttpClient, Moshi moshi) {
    return Preconditions.checkNotNullFromProvides(instance.provideRetrofitWithoutToken(okHttpClient, moshi));
  }
}
