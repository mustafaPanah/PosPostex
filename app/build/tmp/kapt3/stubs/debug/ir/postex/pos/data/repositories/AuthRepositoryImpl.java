package ir.postex.pos.data.repositories;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005JB\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0096@\u00a2\u0006\u0002\u0010\u0011J*\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\b0\u00072\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0096@\u00a2\u0006\u0002\u0010\u0016J\"\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\b0\u00072\u0006\u0010\u0019\u001a\u00020\u000bH\u0096@\u00a2\u0006\u0002\u0010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lir/postex/pos/data/repositories/AuthRepositoryImpl;", "Lir/postex/pos/domain/repositories/AuthRepository;", "Lir/postex/pos/data/source/remote/network/SafeApiRequest;", "service", "Lir/postex/pos/data/source/remote/Services;", "(Lir/postex/pos/data/source/remote/Services;)V", "enroll", "Lkotlinx/coroutines/flow/Flow;", "Lir/postex/pos/data/source/remote/network/Resource;", "Lir/postex/pos/domain/model/enroll/EnrollResponse;", "publicKey", "", "terminalId", "", "merchantId", "masterKey", "serial", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "Lcom/persianswitch/smartpos/webservice/LoginResponse;", "userName", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshToken", "Lir/postex/pos/domain/model/poslogin/RefreshTokenResponse;", "token", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class AuthRepositoryImpl extends ir.postex.pos.data.source.remote.network.SafeApiRequest implements ir.postex.pos.domain.repositories.AuthRepository {
    @org.jetbrains.annotations.NotNull()
    private final ir.postex.pos.data.source.remote.Services service = null;
    
    @javax.inject.Inject()
    public AuthRepositoryImpl(@javax.inject.Named(value = "without_token")
    @org.jetbrains.annotations.NotNull()
    ir.postex.pos.data.source.remote.Services service) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object login(@org.jetbrains.annotations.NotNull()
    java.lang.String userName, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends ir.postex.pos.data.source.remote.network.Resource<com.persianswitch.smartpos.webservice.LoginResponse>>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object refreshToken(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends ir.postex.pos.data.source.remote.network.Resource<ir.postex.pos.domain.model.poslogin.RefreshTokenResponse>>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object enroll(@org.jetbrains.annotations.NotNull()
    java.lang.String publicKey, int terminalId, int merchantId, @org.jetbrains.annotations.NotNull()
    java.lang.String masterKey, @org.jetbrains.annotations.NotNull()
    java.lang.String serial, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends ir.postex.pos.data.source.remote.network.Resource<ir.postex.pos.domain.model.enroll.EnrollResponse>>> $completion) {
        return null;
    }
}