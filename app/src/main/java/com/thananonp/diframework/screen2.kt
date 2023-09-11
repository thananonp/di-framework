@file:OptIn(ExperimentalMaterial3Api::class)

package com.thananonp.diframework

import android.widget.EditText
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.thananonp.diframework.ui.theme.MainApplication
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

@Composable
fun ScreenTwo(viewModel: ScreenTwoViewModel) {
    Column {
        Text(text = "Screen 2")
        TextField(value = viewModel.state, onValueChange = {
            viewModel.state = it
        }, label = {
            Text("Input your number")
        })
        Button(onClick = viewModel::getPlusTwo) {
            Text("Plus 2!!!!!!!")
        }
    }
}

class ScreenTwoViewModel(private val service: ScreenTwoService) : ViewModel() {
    var state by mutableStateOf<String>("0")

    fun getPlusTwo() {
        viewModelScope.launch {
            state = service.getPlusTwo(state.toInt()).toString()
        }
    }
}

interface ScreenTwoService {
    suspend fun getPlusTwo(original: Int): Int
}