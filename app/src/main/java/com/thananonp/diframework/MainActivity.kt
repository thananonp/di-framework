package com.thananonp.diframework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thananonp.diframework.ui.theme.DIFrameworkTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity(), ScreenOneViewDelegate {

    private lateinit var navController: NavHostController

    private val screenTwoViewModel: ScreenTwoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val screenOneViewModel = ScreenOneViewModel(delegate = this)

        setContent {
            navController = rememberNavController()
            DIFrameworkTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = "profile") {
                        composable("profile") { ScreenOne(screenOneViewModel) }
                        composable("friendslist") { ScreenTwo(screenTwoViewModel) }
                    }
                }
            }
        }
    }

    override fun onNextScreen() {
        navController.navigate("friendslist")
    }
}

class ScreenTwoServiceImpl @Inject constructor() : ScreenTwoService {
    override suspend fun getPlusTwo(original: Int): Int {
        delay(1000)
        return original + 2
    }
}