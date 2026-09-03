package ir.postex.pos.data.source.remote.network;

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
public final class HeaderInterceptor_Factory implements Factory<HeaderInterceptor> {
  private final Provider<DataStoreManager> dataStoreManagerProvider;

  public HeaderInterceptor_Factory(Provider<DataStoreManager> dataStoreManagerProvider) {
    this.dataStoreManagerProvider = dataStoreManagerProvider;
  }

  @Override
  public HeaderInterceptor get() {
    return newInstance(dataStoreManagerProvider.get());
  }

  public static HeaderInterceptor_Factory create(
      Provider<DataStoreManager> dataStoreManagerProvider) {
    return new HeaderInterceptor_Factory(dataStoreManagerProvider);
  }

  public static HeaderInterceptor newInstance(DataStoreManager dataStoreManager) {
    return new HeaderInterceptor(dataStoreManager);
  }
}
