package org.dev.onfit.ui.account

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp


data class ConfigItem(
    val icon: ImageVector,
    val title: String,
    val action: () -> Unit = {}
)

val items = listOf(
    ConfigItem(
        icon = Icons.Outlined.Security,
        title = "Revisa nuestros terminos y condiciones"
    ),
    ConfigItem(
        icon = Icons.Outlined.Public,
        title = "Visitanos en nuestra pagina web"
    ),
    ConfigItem(
        icon = Icons.Filled.Favorite,
        title = "Seguinos en Instagram"
    ),
    ConfigItem(
        icon = Icons.Filled.Whatsapp,
        title = "Escribinos por whatsapp"
    ),
    ConfigItem(
        icon = Icons.Filled.Email,
        title = "Envianos un mail"
    ),

    )

@Composable
fun AccountScreen() {
    Scaffold(
        topBar = {
            Box(modifier = Modifier.fillMaxWidth().background(Color.White)) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
                    contentDescription = "Back button",
                    modifier = Modifier.align(Alignment.CenterStart)
                )
                Text(modifier = Modifier.align(Alignment.Center), text = "Configuracion")
            }
        }
    ) {
        Column(Modifier.fillMaxSize().padding(20.dp)) {
            items.forEach {
                Column {
                    Spacer(Modifier.height(16.dp))
                    Row {
                        Icon(
                            imageVector = it.icon,
                            contentDescription = ""
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(it.title)
                        Spacer(
                            Modifier.weight(1f)
                        )
                        Icon(
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
                Modifier.fillMaxWidth().padding(vertical = 8.dp)
                    .clickable { /* TODO: close session */ },
                horizontalArrangement = Arrangement.Center
            ) {
                Text("Cerrar sesion", style = TextStyle())
            }
        }
    }
}

