package ir.postex.pos.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class PrettyLogInterceptor_Factory implements Factory<PrettyLogInterceptor> {
  @Override
  public PrettyLogInterceptor get() {
    return newInstance();
  }

  public static PrettyLogInterceptor_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static PrettyLogInterceptor newInstance() {
    return new PrettyLogInterceptor();
  }

  private static final class InstanceHolder {
    private static final PrettyLogInterceptor_Factory INSTANCE = new PrettyLogInterceptor_Factory();
  }
}
