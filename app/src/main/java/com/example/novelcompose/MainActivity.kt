package com.example.novelcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.novelcompose.screens.GreetingScreen
import com.example.novelcompose.screens.SceneScreen
import com.example.novelcompose.screens.StartEndScreen
import com.example.novelcompose.ui.theme.NovelComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NovelComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val novelController = NovelController(applicationContext)

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "${Screens.StartEndScreen.route}/{${Constants.IS_LAST_SCREEN}}"
                    ) {
                        composable(
                            route = "${Screens.StartEndScreen.route}/{${Constants.IS_LAST_SCREEN}}",
                            arguments = listOf(
                                navArgument(Constants.IS_LAST_SCREEN) {
                                    type = NavType.BoolType
                                    defaultValue = false
                                }
                            )
                        ) {
                            val isLast = it.arguments?.getBoolean(Constants.IS_LAST_SCREEN)
                            StartEndScreen(navController, isLast ?: false)
                        }
                        composable(Screens.GreetingScreen.route) {
                            GreetingScreen(navController)
                        }
                        composable(
                            route = "${Screens.SceneScreen.route}/{${Constants.SCENE_ID}}" +
                            "?${Constants.USER_NAME}={${Constants.USER_NAME}}",
                            arguments = listOf(
                                navArgument(Constants.SCENE_ID) { type = NavType.IntType },
                                navArgument(Constants.USER_NAME) { nullable = true }
                            )
                        ) {
                            val id = it.arguments?.getInt(Constants.SCENE_ID)
                            val userName = it.arguments?.getString(Constants.USER_NAME)
                            SceneScreen(navController, novelController, id ?: -1, userName)
                        }
                    }
                }
            }
        }
    }
}