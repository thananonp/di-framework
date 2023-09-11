package com.thananonp.diframework.ui.theme

import android.app.Application
import com.thananonp.diframework.ScreenTwoService
import com.thananonp.diframework.ScreenTwoServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.components.ViewModelComponent

@HiltAndroidApp
class MainApplication : Application()

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppContainer {
    @Binds
    abstract fun bindScreenTwoService(
        screenTwoServiceImpl: ScreenTwoServiceImpl
    ): ScreenTwoService
}