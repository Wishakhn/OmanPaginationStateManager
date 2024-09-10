package com.example.oman_paginationstatemanager

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()

@Composable
actual fun PMAsyncImage(
    data: Any,
    contentScale: ContentScale,
    contentDescription: String?,
    modifier: Modifier,
    applyTint: Boolean,
    tint: Color,
    loadingProgress: (ImageState) -> Unit
) {

}