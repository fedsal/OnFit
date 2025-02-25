package org.dev.onfit.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import onfit.composeapp.generated.resources.Res
import onfit.composeapp.generated.resources.logo
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = koinViewModel()
) {
    val uiState = viewModel.uiState.collectAsState()

    if (uiState.value.goToHome) {
        // Navigate to the home screen
        Text("Home")
        //return
    } else if (uiState.value.goToLogin) {
        // Navigate to the login screen
        Text("Login")
        //return
    }

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            modifier = Modifier.width(220.dp).height(100.dp),
            painter = painterResource(Res.drawable.logo),
            contentDescription = null
        )
    }
}