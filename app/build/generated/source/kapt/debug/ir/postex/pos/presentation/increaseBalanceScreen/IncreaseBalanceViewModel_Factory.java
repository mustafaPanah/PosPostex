package ir.postex.pos.presentation.increaseBalanceScreen;

import com.squareup.moshi.Moshi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ir.postex.pos.data.source.local.DataStoreManager;
import ir.postex.pos.domain.repositories.MainRepository;
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
public final class IncreaseBalanceViewModel_Factory implements Factory<IncreaseBalanceViewModel> {
  private final Provider<MainRepository> repositoryProvider;

  private final Provider<DataStoreManager> dataStoreManagerProvider;

  private final Provider<Moshi> moshiProvider;

  private final Provider<PrivateKeyStorage> privateKeyStorageProvider;

  public IncreaseBalanceViewModel_Factory(Provider<MainRepository> repositoryProvider,
      Provider<DataStoreManager> dataStoreManagerProvider, Provider<Moshi> moshiProvider,
      Provider<PrivateKeyStorage> privateKeyStorageProvider) {
    this.repositoryProvider = repositoryProvider;
    this.dataStoreManagerProvider = dataStoreManagerProvider;
    this.moshiProvider = moshiProvider;
    this.privateKeyStorageProvider = privateKeyStorageProvider;
  }

  @Override
  public IncreaseBalanceViewModel get() {
    return newInstance(repositoryProvider.get(), dataStoreManagerProvider.get(), moshiProvider.get(), privateKeyStorageProvider.get());
  }

  public static IncreaseBalanceViewModel_Factory create(Provider<MainRepository> repositoryProvider,
      Provider<DataStoreManager> dataStoreManagerProvider, Provider<Moshi> moshiProvider,
      Provider<PrivateKeyStorage> privateKeyStorageProvider) {
    return new IncreaseBalanceViewModel_Factory(repositoryProvider, dataStoreManagerProvider, moshiProvider, privateKeyStorageProvider);
  }

  public static IncreaseBalanceViewModel newInstance(MainRepository repository,
      DataStoreManager dataStoreManager, Moshi moshi, PrivateKeyStorage privateKeyStorage) {
    return new IncreaseBalanceViewModel(repository, dataStoreManager, moshi, privateKeyStorage);
  }
}
