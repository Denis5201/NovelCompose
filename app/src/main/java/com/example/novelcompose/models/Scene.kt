package com.example.novelcompose.models

import kotlinx.serialization.Serializable

@Serializable
data class Scene(
    val id: Int,
    val backgroundResource: String,
    val mainText: String,
    val sceneButtons: List<SceneButton>
)
