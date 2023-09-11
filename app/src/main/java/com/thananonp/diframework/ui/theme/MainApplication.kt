package com.thananonp.diframework.ui.theme

import android.app.Application
import com.thananonp.diframework.ScreenTwoService
import com.thananonp.diframework.ScreenTwoServiceImpl
import com.thananonp.diframework.ScreenTwoViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@MainApplication)
            modules(appContainer)
        }
    }
}

val appContainer = module {
    // Create `ScreenTwoServiceImpl` as a singleton
    // Need to bind Interface to Implementation
    singleOf(::ScreenTwoServiceImpl){ bind<ScreenTwoService>() }
    // Create `ScreenTwoViewModel`
    // or viewModelOf(::ScreenTwoViewModel)
    viewModel{ ScreenTwoViewModel(get()) }
}