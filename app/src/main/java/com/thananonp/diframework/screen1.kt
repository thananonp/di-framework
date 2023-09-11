package com.thananonp.diframework

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY

import com.thananonp.diframework.ui.theme.MainApplication

@Composable
fun ScreenOne(viewModel: ScreenOneViewModel) {
    Column {
        Text(text = "Screen 1")
        Button(onClick = viewModel::onNextScreen) {
            Text(text = "Navigate to next screen")
        }
    }
}

class ScreenOneViewModel(delegate: ScreenOneViewDelegate) : ViewModel(), ScreenOneViewDelegate by delegate {
}

interface ScreenOneViewDelegate {
    fun onNextScreen()
}