package ir.postex.pos

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import ir.postex.pos.BuildConfig
import org.bouncycastle.jce.provider.BouncyCastleProvider
import timber.log.Timber
import java.security.Security

@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Security.removeProvider("BC")
        Security.insertProviderAt(
            BouncyCastleProvider(),
            1
        )
        if(BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
    }

}