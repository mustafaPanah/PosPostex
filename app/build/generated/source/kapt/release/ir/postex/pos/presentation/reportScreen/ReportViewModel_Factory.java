package ir.postex.pos.presentation.reportScreen;

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
public final class ReportViewModel_Factory implements Factory<ReportViewModel> {
  private final Provider<MainRepository> repositoryProvider;

  private final Provider<DataStoreManager> dataStoreManagerProvider;

  private final Provider<PrivateKeyStorage> privateKeyStorageProvider;

  public ReportViewModel_Factory(Provider<MainRepository> repositoryProvider,
      Provider<DataStoreManager> dataStoreManagerProvider,
      Provider<PrivateKeyStorage> privateKeyStorageProvider) {
    this.repositoryProvider = repositoryProvider;
    this.dataStoreManagerProvider = dataStoreManagerProvider;
    this.privateKeyStorageProvider = privateKeyStorageProvider;
  }

  @Override
  public ReportViewModel get() {
    return newInstance(repositoryProvider.get(), dataStoreManagerProvider.get(), privateKeyStorageProvider.get());
  }

  public static ReportViewModel_Factory create(Provider<MainRepository> repositoryProvider,
      Provider<DataStoreManager> dataStoreManagerProvider,
      Provider<PrivateKeyStorage> privateKeyStorageProvider) {
    return new ReportViewModel_Factory(repositoryProvider, dataStoreManagerProvider, privateKeyStorageProvider);
  }

  public static ReportViewModel newInstance(MainRepository repository,
      DataStoreManager dataStoreManager, PrivateKeyStorage privateKeyStorage) {
    return new ReportViewModel(repository, dataStoreManager, privateKeyStorage);
  }
}
