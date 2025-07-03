package ar.edu.ort.parcial

import android.app.Application
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ar.edu.ort.parcial.core.Config
import ar.edu.ort.parcial.ui.AppPetShop
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyAppShop : Application(){
    override fun onCreate() {

        super.onCreate()

        Config.baseUrl=resources.getString(R.string.api_base_url)

    }
}