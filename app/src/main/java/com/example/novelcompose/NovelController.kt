package com.example.novelcompose

import android.content.Context
import com.example.novelcompose.models.Scene
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class NovelController {

    var script: List<Scene> = emptyList()
    var userName = ""

    fun init(context: Context) {
        val jsonString =
            context.assets.open(Constants.FILE_NAME).bufferedReader().use { it.readText() }
        script = Json.decodeFromString(jsonString)
    }

    fun getIndexesForButton(size: Int): List<Int> {
        return when (size) {
            3 -> listOf(0, 1, 2)
            2 -> listOf(0, 0, 1)
            else -> listOf(0, 0, 0)
        }
    }

    fun calculateFirstPadding(size: Int): Int {
        return when (size) {
            3 -> 10
            else -> 26
        }
    }
}