package com.example.novelcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.novelcompose.R
import com.example.novelcompose.ui.theme.darkGreen
import com.example.novelcompose.ui.theme.lightBlue

@Composable
fun BackgroundImage(resourceId: Int) {
    Image(
        bitmap = ImageBitmap.imageResource(resourceId),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
}

@Composable
fun Kirysha() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomStart
    ) {
        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.kirysha),
            contentDescription = null,
            modifier = Modifier.fillMaxHeight(0.9f),
            contentScale = ContentScale.FillHeight
        )
    }
}

@Composable
fun DarkButton(
    text: String,
    click: () -> Unit
) {
    Button(
        onClick = click,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = darkGreen
        ),
        shape = RoundedCornerShape(0.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
fun SceneText(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(34.dp)
            .background(darkGreen),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
fun SceneButton(
    text: String,
    click: () -> Unit
) {
    Button(
        onClick = click,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = lightBlue
        ),
        shape = RoundedCornerShape(0.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.body1
        )
    }
}