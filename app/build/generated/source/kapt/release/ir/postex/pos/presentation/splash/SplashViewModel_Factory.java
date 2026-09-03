package ir.postex.pos.presentation.splash;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ir.postex.pos.data.source.local.DataStoreManager;
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
public final class SplashViewModel_Factory implements Factory<SplashViewModel> {
  private final Provider<DataStoreManager> dataStoreManagerProvider;

  public SplashViewModel_Factory(Provider<DataStoreManager> dataStoreManagerProvider) {
    this.dataStoreManagerProvider = dataStoreManagerProvider;
  }

  @Override
  public SplashViewModel get() {
    return newInstance(dataStoreManagerProvider.get());
  }

  public static SplashViewModel_Factory create(
      Provider<DataStoreManager> dataStoreManagerProvider) {
    return new SplashViewModel_Factory(dataStoreManagerProvider);
  }

  public static SplashViewModel newInstance(DataStoreManager dataStoreManager) {
    return new SplashViewModel(dataStoreManager);
  }
}
