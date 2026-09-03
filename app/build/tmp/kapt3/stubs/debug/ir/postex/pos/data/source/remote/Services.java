package ir.postex.pos.data.source.remote;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ<\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\u000f\u001a\u00020\r2\b\b\u0001\u0010\u0010\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u0011J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0014H\u00a7@\u00a2\u0006\u0002\u0010\u0015J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\b\b\u0001\u0010\u0018\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u0019\u00a8\u0006\u001a"}, d2 = {"Lir/postex/pos/data/source/remote/Services;", "", "enroll", "Lretrofit2/Response;", "Lir/postex/pos/domain/model/enroll/EnrollResponse;", "request", "Lir/postex/pos/domain/model/enroll/EnrollRequest;", "(Lir/postex/pos/domain/model/enroll/EnrollRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "Lcom/persianswitch/smartpos/webservice/LoginResponse;", "Lir/postex/pos/domain/model/poslogin/LoginRequest;", "(Lir/postex/pos/domain/model/poslogin/LoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "username", "", "password", "appName", "channel", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshToken", "Lir/postex/pos/domain/model/poslogin/RefreshTokenResponse;", "Lir/postex/pos/domain/model/poslogin/RefreshTokenRequest;", "(Lir/postex/pos/domain/model/poslogin/RefreshTokenRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendOtp", "Lir/postex/pos/domain/model/OTPResponse;", "phone", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface Services {
    
    @retrofit2.http.FormUrlEncoded()
    @retrofit2.http.Headers(value = {"Content-Type: application/x-www-form-urlencoded"})
    @retrofit2.http.POST(value = "/api/v1/auth/otp/send")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object sendOtp(@retrofit2.http.Field(value = "mobile")
    @org.jetbrains.annotations.NotNull()
    java.lang.String phone, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<ir.postex.pos.domain.model.OTPResponse>> $completion);
    
    @retrofit2.http.FormUrlEncoded()
    @retrofit2.http.Headers(value = {"Content-Type: application/json"})
    @retrofit2.http.POST(value = "/api/app/v1/auth/login")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object login(@retrofit2.http.Field(value = "username")
    @org.jetbrains.annotations.NotNull()
    java.lang.String username, @retrofit2.http.Field(value = "password")
    @org.jetbrains.annotations.NotNull()
    java.lang.String password, @retrofit2.http.Field(value = "app_name")
    @org.jetbrains.annotations.NotNull()
    java.lang.String appName, @retrofit2.http.Field(value = "channel")
    @org.jetbrains.annotations.NotNull()
    java.lang.String channel, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.persianswitch.smartpos.webservice.LoginResponse>> $completion);
    
    @retrofit2.http.POST(value = "/api/app/v1/auth/login")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object login(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    ir.postex.pos.domain.model.poslogin.LoginRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.persianswitch.smartpos.webservice.LoginResponse>> $completion);
    
    @retrofit2.http.POST(value = "/api/app/v1/pos/devices/enroll")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object enroll(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    ir.postex.pos.domain.model.enroll.EnrollRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<ir.postex.pos.domain.model.enroll.EnrollResponse>> $completion);
    
    @retrofit2.http.POST(value = "/api/app/v1/auth/refresh-token")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object refreshToken(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    ir.postex.pos.domain.model.poslogin.RefreshTokenRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<ir.postex.pos.domain.model.poslogin.RefreshTokenResponse>> $completion);
}