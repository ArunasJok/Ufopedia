package ie.wit.ufopedia.main

import android.app.Application
import ie.wit.ufopedia.models.UfoMemStore
import ie.wit.ufopedia.models.UfoModel
import timber.log.Timber
import timber.log.Timber.i

class MainApp : Application() {

    // val ufos = ArrayList<UfoModel>()
    val ufos = UfoMemStore()


    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        i("UFOpedia has started")
        // ufos.add(UfoModel("One", "About one..."))
        // ufos.add(UfoModel("Two", "About two..."))
        // ufos.add(UfoModel("Three", "About three..."))
    }
}