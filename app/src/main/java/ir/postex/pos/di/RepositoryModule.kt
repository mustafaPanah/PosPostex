package ir.postex.pos.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.postex.pos.data.repositories.AuthRepositoryImpl
import ir.postex.pos.data.repositories.MainRepositoryImpl
import ir.postex.pos.domain.repositories.AuthRepository
import ir.postex.pos.domain.repositories.MainRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository

    @Binds
    abstract fun bindMainRepository(mainRepositoryImpl: MainRepositoryImpl): MainRepository
}