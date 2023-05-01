package com.example.novelcompose

sealed class Screens(val route: String) {
    object StartEndScreen : Screens("startЕnd")
    object GreetingScreen : Screens("greeting")
    object SceneScreen : Screens("scene")
}
