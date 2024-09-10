package com.example.oman_paginationstatemanager
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest
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
    AsyncImage(
        modifier = modifier,
        model = ImageRequest.Builder(LocalContext.current).data(data).crossfade(true).build(),
        contentDescription = contentDescription,
        contentScale = contentScale,
        colorFilter = if (applyTint) ColorFilter.tint(color = tint) else null,
        onError = {
            loadingProgress(ImageState.Failure)
        },
        onLoading = {
            loadingProgress(ImageState.Loading)
        },
        onSuccess = {
            loadingProgress(ImageState.Success)
        },
    )
}