package ir.postex.pos.presentation.home;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ir.postex.pos.data.source.local.DataStoreManager;
import ir.postex.pos.domain.repositories.MainRepository;
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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<MainRepository> repositoryProvider;

  private final Provider<DataStoreManager> storeProvider;

  public HomeViewModel_Factory(Provider<MainRepository> repositoryProvider,
      Provider<DataStoreManager> storeProvider) {
    this.repositoryProvider = repositoryProvider;
    this.storeProvider = storeProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(repositoryProvider.get(), storeProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<MainRepository> repositoryProvider,
      Provider<DataStoreManager> storeProvider) {
    return new HomeViewModel_Factory(repositoryProvider, storeProvider);
  }

  public static HomeViewModel newInstance(MainRepository repository, DataStoreManager store) {
    return new HomeViewModel(repository, store);
  }
}
