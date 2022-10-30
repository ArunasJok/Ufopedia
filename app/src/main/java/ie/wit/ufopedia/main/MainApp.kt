package ie.wit.ufopedia.main

import android.app.Application
import ie.wit.ufopedia.models.UfoJSONStore
import ie.wit.ufopedia.models.UfoMemStore
import ie.wit.ufopedia.models.UfoModel
import ie.wit.ufopedia.models.UfoStore
import timber.log.Timber
import timber.log.Timber.i

class MainApp : Application() {

    lateinit var ufos: UfoStore

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        // ufos = UfoMemStore()
        ufos = UfoJSONStore(applicationContext)
        i("UFOpedia has started!")
    }
}