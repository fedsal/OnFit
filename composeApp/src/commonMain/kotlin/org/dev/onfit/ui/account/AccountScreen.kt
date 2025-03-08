package org.dev.onfit.ui.account

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Whatsapp
import androidx.compose.material.icons.outlined.Public
import androidx.compose.material.icons.outlined.Security
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import org.dev.onfit.ui.common.composables.OnFitTopBar
import org.dev.onfit.ui.common.openWhatsapp
import org.dev.onfit.ui.navigation.AuthDestination
import org.dev.onfit.ui.navigation.HomeDestination
import org.dev.onfit.ui.theme.errorContainerLightMediumContrast
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel


data class ConfigItem(
    val icon: ImageVector, val title: String, val action: () -> Unit = {}
)

const val ONFIT_URL = "https://onfit.com.ar"
const val ONFIT_IG = "https://www.instagram.com/onfitarg/"
const val ONFIT_MAIL = "info@onfit.com.ar"

fun getItems(uriHandler: UriHandler) = listOf(
    ConfigItem(
        icon = Icons.Outlined.Security, title = "Revisa nuestros terminos y condiciones"
    ),
    ConfigItem(icon = Icons.Outlined.Public, title = "Visitanos en nuestra pagina web", action = {
        uriHandler.openUri(ONFIT_URL)
    }),
    ConfigItem(icon = Icons.Filled.Favorite, title = "Seguinos en Instagram", action = {
        uriHandler.openUri(ONFIT_IG)
    }),
    ConfigItem(icon = Icons.Filled.Whatsapp, title = "Escribinos por whatsapp", action = {
        openWhatsapp(
            phoneNumber = "541131903642", uriHandler
        )
    }),
    ConfigItem(icon = Icons.Filled.Email, title = "Envianos un mail", action = {
        uriHandler.openUri("mailto:$ONFIT_MAIL")
    }),

    )

@Composable
fun AccountScreen(
    navController: NavHostController = koinInject(), viewModel: AccountViewModel = koinViewModel()
) {
    val sessionClosed = viewModel.sessionClosed.collectAsState()
    if (sessionClosed.value) {
        navController.navigate(AuthDestination.Login) {
            popUpTo(HomeDestination.HomeGraph) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }
    val uriHandler = LocalUriHandler.current
    Scaffold(topBar = {
        OnFitTopBar {
            Box(modifier = Modifier.fillMaxSize().padding(10.dp)) {
                Box(
                    modifier = Modifier.align(Alignment.CenterStart).width(60.dp).fillMaxHeight()
                        .clickable(interactionSource = null,
                            indication = null,
                            onClick = { navController.navigateUp() })
                ) {
                    Icon(
                        modifier = Modifier.size(30.dp).align(Alignment.CenterStart),
                        imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
                        contentDescription = "Back button"
                    )
                }
                Text(modifier = Modifier.align(Alignment.Center), text = "Configuracion")
            }
        }
    }) { padding ->
        Column(
            Modifier.fillMaxSize().padding(
                top = padding.calculateTopPadding(), bottom = 20.dp, start = 20.dp, end = 20.dp
            )
        ) {
            Spacer(Modifier.height(16.dp))
            getItems(uriHandler).forEach {
                Column(
                    modifier = Modifier.clickable(onClick = it.action),
                    verticalArrangement = Arrangement.Center
                ) {
                    Spacer(Modifier.height(16.dp))
                    Row(
                        Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = it.icon, contentDescription = ""
                        )
                        Spacer(Modifier.width(16.dp))
                        Text(
                            modifier = Modifier.weight(1f),
                            text = it.title,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                        Spacer(Modifier.width(16.dp))
                        Icon(
                            modifier = Modifier.size(30.dp),
                            imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                            contentDescription = ""
                        )
                    }
                    Spacer(Modifier.height(16.dp))
                    HorizontalDivider(modifier = Modifier.fillMaxWidth())
                }
            }
            Spacer(Modifier.weight(1f))
            Row(
                Modifier.fillMaxWidth().height(50.dp).clickable { viewModel.closeSession() },
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Cerrar sesion", style = TextStyle(
                        color = errorContainerLightMediumContrast, fontSize = 18.sp
                    )
                )
            }
            Spacer(Modifier.height(16.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Versión 1.0",
                fontSize = 12.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

