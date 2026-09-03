package ir.postex.pos.di;

import com.squareup.moshi.Moshi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class RetrofitModule_ProvideMoshiFactory implements Factory<Moshi> {
  private final RetrofitModule module;

  public RetrofitModule_ProvideMoshiFactory(RetrofitModule module) {
    this.module = module;
  }

  @Override
  public Moshi get() {
    return provideMoshi(module);
  }

  public static RetrofitModule_ProvideMoshiFactory create(RetrofitModule module) {
    return new RetrofitModule_ProvideMoshiFactory(module);
  }

  public static Moshi provideMoshi(RetrofitModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideMoshi());
  }
}
