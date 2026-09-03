package ir.postex.pos.data.repositories;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ir.postex.pos.data.source.remote.Services;
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
public final class AuthRepositoryImpl_Factory implements Factory<AuthRepositoryImpl> {
  private final Provider<Services> serviceProvider;

  public AuthRepositoryImpl_Factory(Provider<Services> serviceProvider) {
    this.serviceProvider = serviceProvider;
  }

  @Override
  public AuthRepositoryImpl get() {
    return newInstance(serviceProvider.get());
  }

  public static AuthRepositoryImpl_Factory create(Provider<Services> serviceProvider) {
    return new AuthRepositoryImpl_Factory(serviceProvider);
  }

  public static AuthRepositoryImpl newInstance(Services service) {
    return new AuthRepositoryImpl(service);
  }
}
