package ir.postex.pos.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.postex.pos.data.source.remote.Services
import ir.postex.pos.data.source.remote.network.MainServices
import ir.postex.pos.utils.WITHOUT_TOKEN_ANNOTATION
import ir.postex.pos.utils.WITH_TOKEN_ANNOTATION
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Singleton
    @Provides
    @Named(WITHOUT_TOKEN_ANNOTATION)
    fun provideServiceWithOutToken(
        @Named(WITHOUT_TOKEN_ANNOTATION)
        retrofit: Retrofit
    ): Services =
        retrofit.create(Services::class.java)

    @Singleton
    @Provides
    @Named(WITH_TOKEN_ANNOTATION)
    fun provideServiceWithToken(
        @Named(WITH_TOKEN_ANNOTATION)
        retrofit: Retrofit
    ): MainServices =
        retrofit.create(MainServices::class.java)

}
