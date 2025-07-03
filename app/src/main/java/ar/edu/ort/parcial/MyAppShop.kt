package ar.edu.ort.parcial

import android.app.Application
import ar.edu.ort.parcial.core.Config
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyAppShop : Application(){
    override fun onCreate() {

        super.onCreate()

        Config.baseUrl=resources.getString(R.string.api_base_url)

    }
}