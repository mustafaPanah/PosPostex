package ir.postex.pos.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import okhttp3.logging.HttpLoggingInterceptor;

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
public final class RetrofitModule_ProvideHttpLoggingInterceptorFactory implements Factory<HttpLoggingInterceptor> {
  private final RetrofitModule module;

  public RetrofitModule_ProvideHttpLoggingInterceptorFactory(RetrofitModule module) {
    this.module = module;
  }

  @Override
  public HttpLoggingInterceptor get() {
    return provideHttpLoggingInterceptor(module);
  }

  public static RetrofitModule_ProvideHttpLoggingInterceptorFactory create(RetrofitModule module) {
    return new RetrofitModule_ProvideHttpLoggingInterceptorFactory(module);
  }

  public static HttpLoggingInterceptor provideHttpLoggingInterceptor(RetrofitModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideHttpLoggingInterceptor());
  }
}
