package ir.postex.pos.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\'\u00a8\u0006\u000b"}, d2 = {"Lir/postex/pos/di/RepositoryModule;", "", "()V", "bindAuthRepository", "Lir/postex/pos/domain/repositories/AuthRepository;", "authRepositoryImpl", "Lir/postex/pos/data/repositories/AuthRepositoryImpl;", "bindMainRepository", "Lir/postex/pos/domain/repositories/MainRepository;", "mainRepositoryImpl", "Lir/postex/pos/data/repositories/MainRepositoryImpl;", "app_release"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract class RepositoryModule {
    
    public RepositoryModule() {
        super();
    }
    
    @dagger.Binds()
    @org.jetbrains.annotations.NotNull()
    public abstract ir.postex.pos.domain.repositories.AuthRepository bindAuthRepository(@org.jetbrains.annotations.NotNull()
    ir.postex.pos.data.repositories.AuthRepositoryImpl authRepositoryImpl);
    
    @dagger.Binds()
    @org.jetbrains.annotations.NotNull()
    public abstract ir.postex.pos.domain.repositories.MainRepository bindMainRepository(@org.jetbrains.annotations.NotNull()
    ir.postex.pos.data.repositories.MainRepositoryImpl mainRepositoryImpl);
}