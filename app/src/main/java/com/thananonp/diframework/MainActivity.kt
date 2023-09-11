package com.thananonp.diframework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thananonp.diframework.ui.theme.DIFrameworkTheme

class MainActivity : ComponentActivity(), ScreenOneViewDelegate {

    val screenOneViewModel = ScreenOneViewModel(delegate = this)
    val screenTwoViewModel = ScreenTwoViewModel()

    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DIFrameworkTheme {
        Greeting("Android")
    }
}