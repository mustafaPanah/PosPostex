package ir.postex.pos.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ir.postex.pos.data.source.local.DataStoreManager;
import ir.postex.pos.data.source.remote.Services;
import ir.postex.pos.data.source.remote.network.TokenAuthenticator;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class RetrofitModule_ProvideTokenAuthenticatorFactory implements Factory<TokenAuthenticator> {
  private final RetrofitModule module;

  private final Provider<DataStoreManager> dataStoreManagerProvider;

  private final Provider<Services> serviceProvider;

  public RetrofitModule_ProvideTokenAuthenticatorFactory(RetrofitModule module,
      Provider<DataStoreManager> dataStoreManagerProvider, Provider<Services> serviceProvider) {
    this.module = module;
    this.dataStoreManagerProvider = dataStoreManagerProvider;
    this.serviceProvider = serviceProvider;
  }

  @Override
  public TokenAuthenticator get() {
    return provideTokenAuthenticator(module, dataStoreManagerProvider.get(), serviceProvider.get());
  }

  public static RetrofitModule_ProvideTokenAuthenticatorFactory create(RetrofitModule module,
      Provider<DataStoreManager> dataStoreManagerProvider, Provider<Services> serviceProvider) {
    return new RetrofitModule_ProvideTokenAuthenticatorFactory(module, dataStoreManagerProvider, serviceProvider);
  }

  public static TokenAuthenticator provideTokenAuthenticator(RetrofitModule instance,
      DataStoreManager dataStoreManager, Services service) {
    return Preconditions.checkNotNullFromProvides(instance.provideTokenAuthenticator(dataStoreManager, service));
  }
}
