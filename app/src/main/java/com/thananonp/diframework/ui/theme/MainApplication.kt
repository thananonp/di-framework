package com.thananonp.diframework.ui.theme

import android.app.Application
import com.thananonp.diframework.AppContainer

class MainApplication: Application() {
    companion object {
        val appContainer = AppContainer()
    }
}