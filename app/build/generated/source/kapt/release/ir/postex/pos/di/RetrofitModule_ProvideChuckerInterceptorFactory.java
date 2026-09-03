package ir.postex.pos.di;

import android.content.Context;
import com.chuckerteam.chucker.api.ChuckerInterceptor;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
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
public final class RetrofitModule_ProvideChuckerInterceptorFactory implements Factory<ChuckerInterceptor> {
  private final RetrofitModule module;

  private final Provider<Context> contextProvider;

  public RetrofitModule_ProvideChuckerInterceptorFactory(RetrofitModule module,
      Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public ChuckerInterceptor get() {
    return provideChuckerInterceptor(module, contextProvider.get());
  }

  public static RetrofitModule_ProvideChuckerInterceptorFactory create(RetrofitModule module,
      Provider<Context> contextProvider) {
    return new RetrofitModule_ProvideChuckerInterceptorFactory(module, contextProvider);
  }

  public static ChuckerInterceptor provideChuckerInterceptor(RetrofitModule instance,
      Context context) {
    return Preconditions.checkNotNullFromProvides(instance.provideChuckerInterceptor(context));
  }
}
