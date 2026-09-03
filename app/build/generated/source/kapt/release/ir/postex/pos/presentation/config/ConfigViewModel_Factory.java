package ir.postex.pos.presentation.config;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ir.postex.pos.data.source.local.DataStoreManager;
import ir.postex.pos.domain.repositories.AuthRepository;
import ir.postex.pos.security.PrivateKeyStorage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
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
public final class ConfigViewModel_Factory implements Factory<ConfigViewModel> {
  private final Provider<AuthRepository> authRepositoryProvider;

  private final Provider<DataStoreManager> dataStoreManagerProvider;

  private final Provider<PrivateKeyStorage> privateKeyStorageProvider;

  public ConfigViewModel_Factory(Provider<AuthRepository> authRepositoryProvider,
      Provider<DataStoreManager> dataStoreManagerProvider,
      Provider<PrivateKeyStorage> privateKeyStorageProvider) {
    this.authRepositoryProvider = authRepositoryProvider;
    this.dataStoreManagerProvider = dataStoreManagerProvider;
    this.privateKeyStorageProvider = privateKeyStorageProvider;
  }

  @Override
  public ConfigViewModel get() {
    return newInstance(authRepositoryProvider.get(), dataStoreManagerProvider.get(), privateKeyStorageProvider.get());
  }

  public static ConfigViewModel_Factory create(Provider<AuthRepository> authRepositoryProvider,
      Provider<DataStoreManager> dataStoreManagerProvider,
      Provider<PrivateKeyStorage> privateKeyStorageProvider) {
    return new ConfigViewModel_Factory(authRepositoryProvider, dataStoreManagerProvider, privateKeyStorageProvider);
  }

  public static ConfigViewModel newInstance(AuthRepository authRepository,
      DataStoreManager dataStoreManager, PrivateKeyStorage privateKeyStorage) {
    return new ConfigViewModel(authRepository, dataStoreManager, privateKeyStorage);
  }
}
