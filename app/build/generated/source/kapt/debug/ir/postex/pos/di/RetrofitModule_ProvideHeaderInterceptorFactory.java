package ir.postex.pos.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ir.postex.pos.data.source.local.DataStoreManager;
import ir.postex.pos.data.source.remote.network.HeaderInterceptor;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class RetrofitModule_ProvideHeaderInterceptorFactory implements Factory<HeaderInterceptor> {
  private final RetrofitModule module;

  private final Provider<DataStoreManager> dataStoreManagerProvider;

  public RetrofitModule_ProvideHeaderInterceptorFactory(RetrofitModule module,
      Provider<DataStoreManager> dataStoreManagerProvider) {
    this.module = module;
    this.dataStoreManagerProvider = dataStoreManagerProvider;
  }

  @Override
  public HeaderInterceptor get() {
    return provideHeaderInterceptor(module, dataStoreManagerProvider.get());
  }

  public static RetrofitModule_ProvideHeaderInterceptorFactory create(RetrofitModule module,
      Provider<DataStoreManager> dataStoreManagerProvider) {
    return new RetrofitModule_ProvideHeaderInterceptorFactory(module, dataStoreManagerProvider);
  }

  public static HeaderInterceptor provideHeaderInterceptor(RetrofitModule instance,
      DataStoreManager dataStoreManager) {
    return Preconditions.checkNotNullFromProvides(instance.provideHeaderInterceptor(dataStoreManager));
  }
}
