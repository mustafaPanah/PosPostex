package ir.postex.pos.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.postex.pos.security.PrivateKeyStorage
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SecurityModule {

    @Provides
    @Singleton
    fun providePrivateKeyStorage(
        @ApplicationContext context: Context
    ): PrivateKeyStorage =
        PrivateKeyStorage(context)
}