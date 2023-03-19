package com.example.novelcompose.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.novelcompose.Constants
import com.example.novelcompose.NovelController
import com.example.novelcompose.R
import com.example.novelcompose.Screens
import com.example.novelcompose.ui.theme.grey

@Composable
fun GreetingScreen(navController: NavController, novelController: NovelController) {
    var text by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current

    BackgroundImage(resourceId = R.drawable.main)
    Kirysha()

    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.fillMaxHeight(0.55f))

        SceneText(text = stringResource(R.string.greeting))
        Spacer(modifier = Modifier.padding(20.dp))

        TextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = stringResource(R.string.input_your_name),
                    style = MaterialTheme.typography.body2
                )
            },
            textStyle = MaterialTheme.typography.subtitle1,
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = grey,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
        Spacer(modifier = Modifier.padding(8.dp))

        DarkButton(
            text = stringResource(R.string.confirm),
            click = {
                if (text.isEmpty()) {
                    Toast.makeText(
                        context,
                        context.resources.getString(R.string.name_is_empty),
                        Toast.LENGTH_SHORT
                    ).show()
                    return@DarkButton
                }
                novelController.userName = text
                navController.navigate("${Screens.SceneScreen.route}/${Constants.FIRST_SCENE_ID}")
            }
        )
    }
}