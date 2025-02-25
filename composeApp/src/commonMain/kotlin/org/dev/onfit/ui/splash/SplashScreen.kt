package org.dev.onfit.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import onfit.composeapp.generated.resources.Res
import onfit.composeapp.generated.resources.logo
import org.dev.onfit.ui.Destination
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = koinViewModel(),
    navController: NavHostController = koinInject()
) {
    val uiState = viewModel.uiState.collectAsState()

    if (uiState.value.goToHome) {
        navController.navigate(Destination.Home)
    } else if (uiState.value.goToLogin) {
        navController.navigate(Destination.Login)
    }

    Surface {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Image(
                modifier = Modifier.width(220.dp).height(100.dp),
                painter = painterResource(Res.drawable.logo),
                contentDescription = null
            )
        }
    }
}