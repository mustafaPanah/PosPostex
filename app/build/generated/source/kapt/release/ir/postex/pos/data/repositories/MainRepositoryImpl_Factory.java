package ir.postex.pos.data.repositories;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ir.postex.pos.data.source.local.DataStoreManager;
import ir.postex.pos.data.source.remote.network.MainServices;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class MainRepositoryImpl_Factory implements Factory<MainRepositoryImpl> {
  private final Provider<MainServices> mServicesProvider;

  private final Provider<DataStoreManager> dataStoreManagerProvider;

  public MainRepositoryImpl_Factory(Provider<MainServices> mServicesProvider,
      Provider<DataStoreManager> dataStoreManagerProvider) {
    this.mServicesProvider = mServicesProvider;
    this.dataStoreManagerProvider = dataStoreManagerProvider;
  }

  @Override
  public MainRepositoryImpl get() {
    return newInstance(mServicesProvider.get(), dataStoreManagerProvider.get());
  }

  public static MainRepositoryImpl_Factory create(Provider<MainServices> mServicesProvider,
      Provider<DataStoreManager> dataStoreManagerProvider) {
    return new MainRepositoryImpl_Factory(mServicesProvider, dataStoreManagerProvider);
  }

  public static MainRepositoryImpl newInstance(MainServices mServices,
      DataStoreManager dataStoreManager) {
    return new MainRepositoryImpl(mServices, dataStoreManager);
  }
}
