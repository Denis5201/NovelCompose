package com.example.novelcompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.novelcompose.R

val Roboto = FontFamily(
    Font(R.font.roboto, FontWeight.Medium),
    Font(R.font.roboto_italic, FontWeight.Normal)
)
val Quattrocento = FontFamily(
    Font(R.font.quattrocento_sans)
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Medium,
        fontSize = 17.sp,
        color = Color.White,
        lineHeight = 22.sp,
        letterSpacing = 0.2.sp
    ),
    body2 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = tint
    ),
    h1 = TextStyle(
        fontFamily = Quattrocento,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        color = Color.White,
        lineHeight = 40.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
        color = Color.Black
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)