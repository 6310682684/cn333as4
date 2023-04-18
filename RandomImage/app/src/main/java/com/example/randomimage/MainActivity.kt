package com.example.randomimage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.randomimage.ui.theme.RandomImageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomImageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun MainScreen(navController: NavHostController = rememberNavController()) {
    Surface() {
        NavHost(
            navController = navController,
            startDestination = "main",
        ) {

            composable("main") {
                InputInformation(navController = navController)
            }
            composable("image/{width}/{height}/{category}",
                arguments = listOf(
                    navArgument("width") { type = NavType.StringType },
                    navArgument("height") { type = NavType.StringType },
                    navArgument("category") { type = NavType.StringType }
                )
            ) { Entry ->
                val category = Entry.arguments?.getString("category")
                val width = Entry.arguments?.getString("width")
                val height = Entry.arguments?.getString("height")
                if (width != null) {
                    if (height != null) {
                        if (category != null) {
                            View(navController, width, height, category)
                        }
                    }

                }
            }
        }
    }
}