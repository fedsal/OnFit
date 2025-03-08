package org.dev.onfit.ui.home.shop

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import com.multiplatform.webview.request.RequestInterceptor
import com.multiplatform.webview.request.WebRequest
import com.multiplatform.webview.request.WebRequestInterceptResult
import com.multiplatform.webview.web.LoadingState
import com.multiplatform.webview.web.WebView
import com.multiplatform.webview.web.WebViewNavigator
import com.multiplatform.webview.web.rememberWebViewNavigator
import com.multiplatform.webview.web.rememberWebViewState

@Composable
fun ShopScreen() {
    val urlHandler = LocalUriHandler.current
    Surface(modifier = Modifier.fillMaxSize()) {
        Box(contentAlignment = Alignment.Center) {
            val state = rememberWebViewState("https://tienda.onfit.com.ar/")
            val webViewNavigator = rememberWebViewNavigator(
                requestInterceptor = object: RequestInterceptor {
                    override fun onInterceptUrlRequest(
                        request: WebRequest,
                        navigator: WebViewNavigator
                    ): WebRequestInterceptResult {
                        if (request.url.contains("whatsapp") || request.url.contains("instagram")) {
                            urlHandler.openUri(request.url)
                            return WebRequestInterceptResult.Reject
                        }
                        return WebRequestInterceptResult.Allow
                    }
                }
            )
            val loadingState = state.loadingState
            if (loadingState is LoadingState.Loading) {
                CircularProgressIndicator()
            }
            WebView(
                modifier = Modifier.fillMaxSize(),
                state = state,
                navigator = webViewNavigator
            )
        }
    }
}