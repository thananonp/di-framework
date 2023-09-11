package com.thananonp.diframework

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel

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