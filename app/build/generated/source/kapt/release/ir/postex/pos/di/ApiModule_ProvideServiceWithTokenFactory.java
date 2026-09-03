package ir.postex.pos.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ir.postex.pos.data.source.remote.network.MainServices;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
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
public final class ApiModule_ProvideServiceWithTokenFactory implements Factory<MainServices> {
  private final ApiModule module;

  private final Provider<Retrofit> retrofitProvider;

  public ApiModule_ProvideServiceWithTokenFactory(ApiModule module,
      Provider<Retrofit> retrofitProvider) {
    this.module = module;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public MainServices get() {
    return provideServiceWithToken(module, retrofitProvider.get());
  }

  public static ApiModule_ProvideServiceWithTokenFactory create(ApiModule module,
      Provider<Retrofit> retrofitProvider) {
    return new ApiModule_ProvideServiceWithTokenFactory(module, retrofitProvider);
  }

  public static MainServices provideServiceWithToken(ApiModule instance, Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(instance.provideServiceWithToken(retrofit));
  }
}
