package org.smilesb101.kangaroo

import android.app.Application
import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidContext

class KangarooApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@KangarooApp)
//            modules(appModules)
//            lazyModules()
        }
    }
}