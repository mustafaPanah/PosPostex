package ir.postex.pos.data.source.remote.network;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ir.postex.pos.data.source.local.DataStoreManager;
import ir.postex.pos.data.source.remote.Services;
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
public final class TokenAuthenticator_Factory implements Factory<TokenAuthenticator> {
  private final Provider<DataStoreManager> dataStoreManagerProvider;

  private final Provider<Services> serviceProvider;

  public TokenAuthenticator_Factory(Provider<DataStoreManager> dataStoreManagerProvider,
      Provider<Services> serviceProvider) {
    this.dataStoreManagerProvider = dataStoreManagerProvider;
    this.serviceProvider = serviceProvider;
  }

  @Override
  public TokenAuthenticator get() {
    return newInstance(dataStoreManagerProvider.get(), serviceProvider.get());
  }

  public static TokenAuthenticator_Factory create(
      Provider<DataStoreManager> dataStoreManagerProvider, Provider<Services> serviceProvider) {
    return new TokenAuthenticator_Factory(dataStoreManagerProvider, serviceProvider);
  }

  public static TokenAuthenticator newInstance(DataStoreManager dataStoreManager,
      Services service) {
    return new TokenAuthenticator(dataStoreManager, service);
  }
}
