package ir.postex.pos.di;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ir.postex.pos.security.PrivateKeyStorage;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class SecurityModule_ProvidePrivateKeyStorageFactory implements Factory<PrivateKeyStorage> {
  private final Provider<Context> contextProvider;

  public SecurityModule_ProvidePrivateKeyStorageFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public PrivateKeyStorage get() {
    return providePrivateKeyStorage(contextProvider.get());
  }

  public static SecurityModule_ProvidePrivateKeyStorageFactory create(
      Provider<Context> contextProvider) {
    return new SecurityModule_ProvidePrivateKeyStorageFactory(contextProvider);
  }

  public static PrivateKeyStorage providePrivateKeyStorage(Context context) {
    return Preconditions.checkNotNullFromProvides(SecurityModule.INSTANCE.providePrivateKeyStorage(context));
  }
}
