package com.example.novelcompose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.novelcompose.Constants
import com.example.novelcompose.NovelController
import com.example.novelcompose.R
import com.example.novelcompose.Screens

@Composable
fun SceneScreen(navController: NavController, novelController: NovelController, sceneId: Int) {

    val scene = novelController.script.find { it.id == sceneId } ?: novelController.script.last()
    val countButtons = scene.sceneButtons.size
    val indexesForButtons = novelController.getIndexesForButton(countButtons)

    val context = LocalContext.current
    val nameId = context.resources.getIdentifier(scene.backgroundResource, "drawable", context.packageName)

    BackgroundImage(resourceId = nameId)

    if (sceneId == Constants.FIRST_SCENE_ID) {
        Kirysha()
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.fillMaxHeight(0.55f))

        SceneText(
            text = if (sceneId == Constants.FIRST_SCENE_ID) {
                stringResource(R.string.beginning_novel, novelController.userName)
            } else {
                scene.mainText
            }
        )
        Spacer(modifier = Modifier.padding(novelController.calculateFirstPadding(countButtons).dp))

        if (countButtons == 3) {
            SceneButton(
                text = scene.sceneButtons[indexesForButtons[0]].text,
                click = { goToNextScene(navController, scene.sceneButtons[indexesForButtons[0]].nextSceneId) }
            )
        }
        Spacer(modifier = Modifier.padding(12.dp))
        SceneButton(
            text = scene.sceneButtons[indexesForButtons[1]].text,
            click = { goToNextScene(navController, scene.sceneButtons[indexesForButtons[1]].nextSceneId) }
        )
        if (countButtons > 1) {
            Spacer(modifier = Modifier.padding(12.dp))
            SceneButton(
                text = scene.sceneButtons[indexesForButtons[2]].text,
                click = { goToNextScene(navController, scene.sceneButtons[indexesForButtons[2]].nextSceneId) }
            )
        }
    }
}

private fun goToNextScene(navController: NavController, nextSceneId: Int) {
    if (nextSceneId == Constants.GO_TO_LAST_SCENE) {
        navController.navigate("${Screens.StartEndScreen.route}/true")
    } else {
        navController.navigate("${Screens.SceneScreen.route}/$nextSceneId")
    }
}