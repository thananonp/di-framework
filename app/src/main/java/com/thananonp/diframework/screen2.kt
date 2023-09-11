package com.thananonp.diframework

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel

@Composable
fun ScreenTwo(viewModel: ScreenTwoViewModel) {
    Column {
        Text(text = "Screen 2")
    }
}

class ScreenTwoViewModel() : ViewModel() {}

interface ScreenTwoService {
    fun getPlusTwo(original: Int)
}