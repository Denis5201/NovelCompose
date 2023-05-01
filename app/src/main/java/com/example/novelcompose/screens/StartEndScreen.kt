package com.example.novelcompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.example.novelcompose.R
import com.example.novelcompose.Screens
import com.example.novelcompose.ui.theme.lightBlue

@Composable
fun StartEndScreen(navController: NavController, isLastScreen: Boolean) {
    BackgroundImage(resourceId = R.drawable.main)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = if (isLastScreen) stringResource(R.string.end_text) else stringResource(R.string.start_text),
            modifier = Modifier
                .fillMaxWidth()
                .background(lightBlue),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h1
        )
        if (isLastScreen) {
            DarkButton(
                text = stringResource(R.string.again),
                click = {
                    navController.navigate("${Screens.StartEndScreen.route}/false") {
                        //Очищаем весь стэк навигации
                        popUpTo(navController.graph.id) { inclusive = true }
                    }
                }
            )
        } else {
            DarkButton(
                text = stringResource(R.string.begin),
                click = { navController.navigate(Screens.GreetingScreen.route) }
            )
        }
    }
}