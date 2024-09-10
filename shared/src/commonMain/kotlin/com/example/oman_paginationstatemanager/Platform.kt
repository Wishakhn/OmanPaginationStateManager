package com.example.oman_paginationstatemanager

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

enum class ImageState {
    Loading,
    Success,
    Failure
}

@Composable
expect fun PMAsyncImage(
    data: Any,
    contentScale: ContentScale,
    contentDescription: String?,
    modifier: Modifier,
    applyTint: Boolean = false,
    tint: Color = Color.Transparent,
    loadingProgress: (ImageState) -> Unit
)