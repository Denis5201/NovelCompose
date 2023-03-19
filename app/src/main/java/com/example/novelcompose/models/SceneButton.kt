package com.example.novelcompose.models

import kotlinx.serialization.Serializable

@Serializable
data class SceneButton(
    val text: String,
    val nextSceneId: Int
)
