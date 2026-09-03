package ir.postex.pos;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.chuckerteam.chucker.api.ChuckerInterceptor;
import com.squareup.moshi.Moshi;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.IdentifierNameString;
import dagger.internal.KeepFieldType;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import ir.postex.pos.data.repositories.AuthRepositoryImpl;
import ir.postex.pos.data.repositories.MainRepositoryImpl;
import ir.postex.pos.data.source.local.DataStoreManager;
import ir.postex.pos.data.source.remote.Services;
import ir.postex.pos.data.source.remote.network.HeaderInterceptor;
import ir.postex.pos.data.source.remote.network.MainServices;
import ir.postex.pos.data.source.remote.network.TokenAuthenticator;
import ir.postex.pos.di.ApiModule;
import ir.postex.pos.di.ApiModule_ProvideServiceWithOutTokenFactory;
import ir.postex.pos.di.ApiModule_ProvideServiceWithTokenFactory;
import ir.postex.pos.di.PrettyLogInterceptor;
import ir.postex.pos.di.RetrofitModule;
import ir.postex.pos.di.RetrofitModule_ProvideChuckerInterceptorFactory;
import ir.postex.pos.di.RetrofitModule_ProvideHeaderInterceptorFactory;
import ir.postex.pos.di.RetrofitModule_ProvideMoshiFactory;
import ir.postex.pos.di.RetrofitModule_ProvideOkHttpClientWithTokenFactory;
import ir.postex.pos.di.RetrofitModule_ProvideOkHttpClientWithoutTokenFactory;
import ir.postex.pos.di.RetrofitModule_ProvideRetrofitWithTokenFactory;
import ir.postex.pos.di.RetrofitModule_ProvideRetrofitWithoutTokenFactory;
import ir.postex.pos.di.RetrofitModule_ProvideTokenAuthenticatorFactory;
import ir.postex.pos.di.SecurityModule_ProvidePrivateKeyStorageFactory;
import ir.postex.pos.presentation.config.ConfigViewModel;
import ir.postex.pos.presentation.config.ConfigViewModel_HiltModules;
import ir.postex.pos.presentation.home.HomeViewModel;
import ir.postex.pos.presentation.home.HomeViewModel_HiltModules;
import ir.postex.pos.presentation.increaseBalanceScreen.IncreaseBalanceViewModel;
import ir.postex.pos.presentation.increaseBalanceScreen.IncreaseBalanceViewModel_HiltModules;
import ir.postex.pos.presentation.login.SignInViewModel;
import ir.postex.pos.presentation.login.SignInViewModel_HiltModules;
import ir.postex.pos.presentation.main.MainActivity;
import ir.postex.pos.presentation.main.MainViewModel;
import ir.postex.pos.presentation.main.MainViewModel_HiltModules;
import ir.postex.pos.presentation.orderdetail.OrderDetailsViewModel;
import ir.postex.pos.presentation.orderdetail.OrderDetailsViewModel_HiltModules;
import ir.postex.pos.presentation.payment.PaymentViewModel;
import ir.postex.pos.presentation.payment.PaymentViewModel_HiltModules;
import ir.postex.pos.presentation.reportScreen.ReportViewModel;
import ir.postex.pos.presentation.reportScreen.ReportViewModel_HiltModules;
import ir.postex.pos.presentation.splash.SplashViewModel;
import ir.postex.pos.presentation.splash.SplashViewModel_HiltModules;
import ir.postex.pos.security.PrivateKeyStorage;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

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
public final class DaggerMyApplication_HiltComponents_SingletonC {
  private DaggerMyApplication_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApiModule apiModule;

    private ApplicationContextModule applicationContextModule;

    private RetrofitModule retrofitModule;

    private Builder() {
    }

    public Builder apiModule(ApiModule apiModule) {
      this.apiModule = Preconditions.checkNotNull(apiModule);
      return this;
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public Builder retrofitModule(RetrofitModule retrofitModule) {
      this.retrofitModule = Preconditions.checkNotNull(retrofitModule);
      return this;
    }

    public MyApplication_HiltComponents.SingletonC build() {
      if (apiModule == null) {
        this.apiModule = new ApiModule();
      }
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      if (retrofitModule == null) {
        this.retrofitModule = new RetrofitModule();
      }
      return new SingletonCImpl(apiModule, applicationContextModule, retrofitModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements MyApplication_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements MyApplication_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements MyApplication_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements MyApplication_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements MyApplication_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements MyApplication_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements MyApplication_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends MyApplication_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends MyApplication_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends MyApplication_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends MyApplication_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Map<Class<?>, Boolean> getViewModelKeys() {
      return LazyClassKeyMap.<Boolean>of(MapBuilder.<String, Boolean>newMapBuilder(9).put(LazyClassKeyProvider.ir_postex_pos_presentation_config_ConfigViewModel, ConfigViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.ir_postex_pos_presentation_home_HomeViewModel, HomeViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.ir_postex_pos_presentation_increaseBalanceScreen_IncreaseBalanceViewModel, IncreaseBalanceViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.ir_postex_pos_presentation_main_MainViewModel, MainViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.ir_postex_pos_presentation_orderdetail_OrderDetailsViewModel, OrderDetailsViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.ir_postex_pos_presentation_payment_PaymentViewModel, PaymentViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.ir_postex_pos_presentation_reportScreen_ReportViewModel, ReportViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.ir_postex_pos_presentation_login_SignInViewModel, SignInViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.ir_postex_pos_presentation_splash_SplashViewModel, SplashViewModel_HiltModules.KeyModule.provide()).build());
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public void injectMainActivity(MainActivity arg0) {
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String ir_postex_pos_presentation_login_SignInViewModel = "ir.postex.pos.presentation.login.SignInViewModel";

      static String ir_postex_pos_presentation_orderdetail_OrderDetailsViewModel = "ir.postex.pos.presentation.orderdetail.OrderDetailsViewModel";

      static String ir_postex_pos_presentation_home_HomeViewModel = "ir.postex.pos.presentation.home.HomeViewModel";

      static String ir_postex_pos_presentation_payment_PaymentViewModel = "ir.postex.pos.presentation.payment.PaymentViewModel";

      static String ir_postex_pos_presentation_reportScreen_ReportViewModel = "ir.postex.pos.presentation.reportScreen.ReportViewModel";

      static String ir_postex_pos_presentation_increaseBalanceScreen_IncreaseBalanceViewModel = "ir.postex.pos.presentation.increaseBalanceScreen.IncreaseBalanceViewModel";

      static String ir_postex_pos_presentation_config_ConfigViewModel = "ir.postex.pos.presentation.config.ConfigViewModel";

      static String ir_postex_pos_presentation_splash_SplashViewModel = "ir.postex.pos.presentation.splash.SplashViewModel";

      static String ir_postex_pos_presentation_main_MainViewModel = "ir.postex.pos.presentation.main.MainViewModel";

      @KeepFieldType
      SignInViewModel ir_postex_pos_presentation_login_SignInViewModel2;

      @KeepFieldType
      OrderDetailsViewModel ir_postex_pos_presentation_orderdetail_OrderDetailsViewModel2;

      @KeepFieldType
      HomeViewModel ir_postex_pos_presentation_home_HomeViewModel2;

      @KeepFieldType
      PaymentViewModel ir_postex_pos_presentation_payment_PaymentViewModel2;

      @KeepFieldType
      ReportViewModel ir_postex_pos_presentation_reportScreen_ReportViewModel2;

      @KeepFieldType
      IncreaseBalanceViewModel ir_postex_pos_presentation_increaseBalanceScreen_IncreaseBalanceViewModel2;

      @KeepFieldType
      ConfigViewModel ir_postex_pos_presentation_config_ConfigViewModel2;

      @KeepFieldType
      SplashViewModel ir_postex_pos_presentation_splash_SplashViewModel2;

      @KeepFieldType
      MainViewModel ir_postex_pos_presentation_main_MainViewModel2;
    }
  }

  private static final class ViewModelCImpl extends MyApplication_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<ConfigViewModel> configViewModelProvider;

    private Provider<HomeViewModel> homeViewModelProvider;

    private Provider<IncreaseBalanceViewModel> increaseBalanceViewModelProvider;

    private Provider<MainViewModel> mainViewModelProvider;

    private Provider<OrderDetailsViewModel> orderDetailsViewModelProvider;

    private Provider<PaymentViewModel> paymentViewModelProvider;

    private Provider<ReportViewModel> reportViewModelProvider;

    private Provider<SignInViewModel> signInViewModelProvider;

    private Provider<SplashViewModel> splashViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.configViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.homeViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.increaseBalanceViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.mainViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.orderDetailsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
      this.paymentViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 5);
      this.reportViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 6);
      this.signInViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 7);
      this.splashViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 8);
    }

    @Override
    public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return LazyClassKeyMap.<javax.inject.Provider<ViewModel>>of(MapBuilder.<String, javax.inject.Provider<ViewModel>>newMapBuilder(9).put(LazyClassKeyProvider.ir_postex_pos_presentation_config_ConfigViewModel, ((Provider) configViewModelProvider)).put(LazyClassKeyProvider.ir_postex_pos_presentation_home_HomeViewModel, ((Provider) homeViewModelProvider)).put(LazyClassKeyProvider.ir_postex_pos_presentation_increaseBalanceScreen_IncreaseBalanceViewModel, ((Provider) increaseBalanceViewModelProvider)).put(LazyClassKeyProvider.ir_postex_pos_presentation_main_MainViewModel, ((Provider) mainViewModelProvider)).put(LazyClassKeyProvider.ir_postex_pos_presentation_orderdetail_OrderDetailsViewModel, ((Provider) orderDetailsViewModelProvider)).put(LazyClassKeyProvider.ir_postex_pos_presentation_payment_PaymentViewModel, ((Provider) paymentViewModelProvider)).put(LazyClassKeyProvider.ir_postex_pos_presentation_reportScreen_ReportViewModel, ((Provider) reportViewModelProvider)).put(LazyClassKeyProvider.ir_postex_pos_presentation_login_SignInViewModel, ((Provider) signInViewModelProvider)).put(LazyClassKeyProvider.ir_postex_pos_presentation_splash_SplashViewModel, ((Provider) splashViewModelProvider)).build());
    }

    @Override
    public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
      return Collections.<Class<?>, Object>emptyMap();
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String ir_postex_pos_presentation_increaseBalanceScreen_IncreaseBalanceViewModel = "ir.postex.pos.presentation.increaseBalanceScreen.IncreaseBalanceViewModel";

      static String ir_postex_pos_presentation_config_ConfigViewModel = "ir.postex.pos.presentation.config.ConfigViewModel";

      static String ir_postex_pos_presentation_orderdetail_OrderDetailsViewModel = "ir.postex.pos.presentation.orderdetail.OrderDetailsViewModel";

      static String ir_postex_pos_presentation_login_SignInViewModel = "ir.postex.pos.presentation.login.SignInViewModel";

      static String ir_postex_pos_presentation_home_HomeViewModel = "ir.postex.pos.presentation.home.HomeViewModel";

      static String ir_postex_pos_presentation_main_MainViewModel = "ir.postex.pos.presentation.main.MainViewModel";

      static String ir_postex_pos_presentation_splash_SplashViewModel = "ir.postex.pos.presentation.splash.SplashViewModel";

      static String ir_postex_pos_presentation_reportScreen_ReportViewModel = "ir.postex.pos.presentation.reportScreen.ReportViewModel";

      static String ir_postex_pos_presentation_payment_PaymentViewModel = "ir.postex.pos.presentation.payment.PaymentViewModel";

      @KeepFieldType
      IncreaseBalanceViewModel ir_postex_pos_presentation_increaseBalanceScreen_IncreaseBalanceViewModel2;

      @KeepFieldType
      ConfigViewModel ir_postex_pos_presentation_config_ConfigViewModel2;

      @KeepFieldType
      OrderDetailsViewModel ir_postex_pos_presentation_orderdetail_OrderDetailsViewModel2;

      @KeepFieldType
      SignInViewModel ir_postex_pos_presentation_login_SignInViewModel2;

      @KeepFieldType
      HomeViewModel ir_postex_pos_presentation_home_HomeViewModel2;

      @KeepFieldType
      MainViewModel ir_postex_pos_presentation_main_MainViewModel2;

      @KeepFieldType
      SplashViewModel ir_postex_pos_presentation_splash_SplashViewModel2;

      @KeepFieldType
      ReportViewModel ir_postex_pos_presentation_reportScreen_ReportViewModel2;

      @KeepFieldType
      PaymentViewModel ir_postex_pos_presentation_payment_PaymentViewModel2;
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // ir.postex.pos.presentation.config.ConfigViewModel 
          return (T) new ConfigViewModel(singletonCImpl.authRepositoryImpl(), singletonCImpl.dataStoreManager(), singletonCImpl.providePrivateKeyStorageProvider.get());

          case 1: // ir.postex.pos.presentation.home.HomeViewModel 
          return (T) new HomeViewModel(singletonCImpl.mainRepositoryImpl(), singletonCImpl.dataStoreManager());

          case 2: // ir.postex.pos.presentation.increaseBalanceScreen.IncreaseBalanceViewModel 
          return (T) new IncreaseBalanceViewModel(singletonCImpl.mainRepositoryImpl(), singletonCImpl.dataStoreManager(), singletonCImpl.provideMoshiProvider.get(), singletonCImpl.providePrivateKeyStorageProvider.get());

          case 3: // ir.postex.pos.presentation.main.MainViewModel 
          return (T) new MainViewModel();

          case 4: // ir.postex.pos.presentation.orderdetail.OrderDetailsViewModel 
          return (T) new OrderDetailsViewModel(singletonCImpl.mainRepositoryImpl(), singletonCImpl.dataStoreManager(), singletonCImpl.providePrivateKeyStorageProvider.get());

          case 5: // ir.postex.pos.presentation.payment.PaymentViewModel 
          return (T) new PaymentViewModel(singletonCImpl.mainRepositoryImpl(), singletonCImpl.dataStoreManager(), singletonCImpl.providePrivateKeyStorageProvider.get());

          case 6: // ir.postex.pos.presentation.reportScreen.ReportViewModel 
          return (T) new ReportViewModel(singletonCImpl.mainRepositoryImpl(), singletonCImpl.dataStoreManager(), singletonCImpl.providePrivateKeyStorageProvider.get());

          case 7: // ir.postex.pos.presentation.login.SignInViewModel 
          return (T) new SignInViewModel(singletonCImpl.authRepositoryImpl(), singletonCImpl.dataStoreManager(), singletonCImpl.providePrivateKeyStorageProvider.get());

          case 8: // ir.postex.pos.presentation.splash.SplashViewModel 
          return (T) new SplashViewModel(singletonCImpl.dataStoreManager());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends MyApplication_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends MyApplication_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends MyApplication_HiltComponents.SingletonC {
    private final ApiModule apiModule;

    private final RetrofitModule retrofitModule;

    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<ChuckerInterceptor> provideChuckerInterceptorProvider;

    private Provider<HeaderInterceptor> provideHeaderInterceptorProvider;

    private Provider<OkHttpClient> provideOkHttpClientWithoutTokenProvider;

    private Provider<Moshi> provideMoshiProvider;

    private Provider<Retrofit> provideRetrofitWithoutTokenProvider;

    private Provider<Services> provideServiceWithOutTokenProvider;

    private Provider<PrivateKeyStorage> providePrivateKeyStorageProvider;

    private Provider<TokenAuthenticator> provideTokenAuthenticatorProvider;

    private Provider<OkHttpClient> provideOkHttpClientWithTokenProvider;

    private Provider<Retrofit> provideRetrofitWithTokenProvider;

    private Provider<MainServices> provideServiceWithTokenProvider;

    private SingletonCImpl(ApiModule apiModuleParam,
        ApplicationContextModule applicationContextModuleParam,
        RetrofitModule retrofitModuleParam) {
      this.apiModule = apiModuleParam;
      this.retrofitModule = retrofitModuleParam;
      this.applicationContextModule = applicationContextModuleParam;
      initialize(apiModuleParam, applicationContextModuleParam, retrofitModuleParam);

    }

    private DataStoreManager dataStoreManager() {
      return new DataStoreManager(ApplicationContextModule_ProvideContextFactory.provideContext(applicationContextModule));
    }

    private AuthRepositoryImpl authRepositoryImpl() {
      return new AuthRepositoryImpl(provideServiceWithOutTokenProvider.get());
    }

    private MainRepositoryImpl mainRepositoryImpl() {
      return new MainRepositoryImpl(provideServiceWithTokenProvider.get(), dataStoreManager());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApiModule apiModuleParam,
        final ApplicationContextModule applicationContextModuleParam,
        final RetrofitModule retrofitModuleParam) {
      this.provideChuckerInterceptorProvider = DoubleCheck.provider(new SwitchingProvider<ChuckerInterceptor>(singletonCImpl, 3));
      this.provideHeaderInterceptorProvider = DoubleCheck.provider(new SwitchingProvider<HeaderInterceptor>(singletonCImpl, 4));
      this.provideOkHttpClientWithoutTokenProvider = DoubleCheck.provider(new SwitchingProvider<OkHttpClient>(singletonCImpl, 2));
      this.provideMoshiProvider = DoubleCheck.provider(new SwitchingProvider<Moshi>(singletonCImpl, 5));
      this.provideRetrofitWithoutTokenProvider = DoubleCheck.provider(new SwitchingProvider<Retrofit>(singletonCImpl, 1));
      this.provideServiceWithOutTokenProvider = DoubleCheck.provider(new SwitchingProvider<Services>(singletonCImpl, 0));
      this.providePrivateKeyStorageProvider = DoubleCheck.provider(new SwitchingProvider<PrivateKeyStorage>(singletonCImpl, 6));
      this.provideTokenAuthenticatorProvider = DoubleCheck.provider(new SwitchingProvider<TokenAuthenticator>(singletonCImpl, 10));
      this.provideOkHttpClientWithTokenProvider = DoubleCheck.provider(new SwitchingProvider<OkHttpClient>(singletonCImpl, 9));
      this.provideRetrofitWithTokenProvider = DoubleCheck.provider(new SwitchingProvider<Retrofit>(singletonCImpl, 8));
      this.provideServiceWithTokenProvider = DoubleCheck.provider(new SwitchingProvider<MainServices>(singletonCImpl, 7));
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return Collections.<Boolean>emptySet();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    @Override
    public void injectMyApplication(MyApplication myApplication) {
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // @javax.inject.Named("without_token") ir.postex.pos.data.source.remote.Services 
          return (T) ApiModule_ProvideServiceWithOutTokenFactory.provideServiceWithOutToken(singletonCImpl.apiModule, singletonCImpl.provideRetrofitWithoutTokenProvider.get());

          case 1: // @javax.inject.Named("without_token") retrofit2.Retrofit 
          return (T) RetrofitModule_ProvideRetrofitWithoutTokenFactory.provideRetrofitWithoutToken(singletonCImpl.retrofitModule, singletonCImpl.provideOkHttpClientWithoutTokenProvider.get(), singletonCImpl.provideMoshiProvider.get());

          case 2: // @javax.inject.Named("without_token") okhttp3.OkHttpClient 
          return (T) RetrofitModule_ProvideOkHttpClientWithoutTokenFactory.provideOkHttpClientWithoutToken(singletonCImpl.retrofitModule, singletonCImpl.provideChuckerInterceptorProvider.get(), singletonCImpl.provideHeaderInterceptorProvider.get(), new PrettyLogInterceptor());

          case 3: // com.chuckerteam.chucker.api.ChuckerInterceptor 
          return (T) RetrofitModule_ProvideChuckerInterceptorFactory.provideChuckerInterceptor(singletonCImpl.retrofitModule, ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 4: // ir.postex.pos.data.source.remote.network.HeaderInterceptor 
          return (T) RetrofitModule_ProvideHeaderInterceptorFactory.provideHeaderInterceptor(singletonCImpl.retrofitModule, singletonCImpl.dataStoreManager());

          case 5: // com.squareup.moshi.Moshi 
          return (T) RetrofitModule_ProvideMoshiFactory.provideMoshi(singletonCImpl.retrofitModule);

          case 6: // ir.postex.pos.security.PrivateKeyStorage 
          return (T) SecurityModule_ProvidePrivateKeyStorageFactory.providePrivateKeyStorage(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 7: // @javax.inject.Named("with_token") ir.postex.pos.data.source.remote.network.MainServices 
          return (T) ApiModule_ProvideServiceWithTokenFactory.provideServiceWithToken(singletonCImpl.apiModule, singletonCImpl.provideRetrofitWithTokenProvider.get());

          case 8: // @javax.inject.Named("with_token") retrofit2.Retrofit 
          return (T) RetrofitModule_ProvideRetrofitWithTokenFactory.provideRetrofitWithToken(singletonCImpl.retrofitModule, singletonCImpl.provideOkHttpClientWithTokenProvider.get(), singletonCImpl.provideMoshiProvider.get());

          case 9: // @javax.inject.Named("with_token") okhttp3.OkHttpClient 
          return (T) RetrofitModule_ProvideOkHttpClientWithTokenFactory.provideOkHttpClientWithToken(singletonCImpl.retrofitModule, singletonCImpl.provideChuckerInterceptorProvider.get(), singletonCImpl.provideHeaderInterceptorProvider.get(), new PrettyLogInterceptor(), singletonCImpl.provideTokenAuthenticatorProvider.get());

          case 10: // ir.postex.pos.data.source.remote.network.TokenAuthenticator 
          return (T) RetrofitModule_ProvideTokenAuthenticatorFactory.provideTokenAuthenticator(singletonCImpl.retrofitModule, singletonCImpl.dataStoreManager(), singletonCImpl.provideServiceWithOutTokenProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
