package org.dev.onfit.ui.home.shop

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.multiplatform.webview.web.LoadingState
import com.multiplatform.webview.web.WebView
import com.multiplatform.webview.web.rememberWebViewState

@Composable
fun ShopScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Box(contentAlignment = Alignment.Center) {
            val state = rememberWebViewState("https://tienda.onfit.com.ar/")
            val loadingState = state.loadingState
            if (loadingState is LoadingState.Loading) {
                CircularProgressIndicator()
            }
            WebView(
                modifier = Modifier.fillMaxSize(),
                state = state
            )
        }
    }
}