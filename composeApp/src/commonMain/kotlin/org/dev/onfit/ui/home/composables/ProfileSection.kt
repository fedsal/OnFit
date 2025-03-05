package org.dev.onfit.ui.home.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import onfit.composeapp.generated.resources.Res
import onfit.composeapp.generated.resources.logo_icon
import org.dev.onfit.ui.theme.errorContainerLightMediumContrast
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProfileSection(
    name: String,
    subscriptionInfo: String,
    expirationDate: String,
    healthAffidavitExpirationDate: String,
    onQrTapped: () -> Unit
) {
    Column {
        ProfileCard(
            name = name,
            subscriptionInfo = subscriptionInfo,
            expirationDate = expirationDate,
            onQrTapped = onQrTapped
        )
        Spacer(Modifier.height(16.dp))
        Card(
            Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    modifier = Modifier.size(35.dp),
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "",
                    tint = errorContainerLightMediumContrast
                )
                Spacer(Modifier.width(16.dp))
                Column(Modifier.fillMaxWidth().weight(1f)) {
                    Text("Declaracion jurada", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 18.sp))
                    Text("Vencimiento: $healthAffidavitExpirationDate", style = TextStyle(color = Color.DarkGray, fontSize = 14.sp))

                }
            }
        }
    }
}

@Composable
fun ProfileCard(
    name: String,
    subscriptionInfo: String,
    expirationDate: String,
    onQrTapped: () -> Unit
) {
    Card(
        Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp).height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(Res.drawable.logo_icon),
                modifier = Modifier.size(50.dp),
                contentDescription = null
            )
            Spacer(Modifier.width(16.dp))
            Column {
                Text(name, color = Color.Black, fontSize = 18.sp, style = TextStyle(fontWeight = FontWeight.Bold))
                Spacer(Modifier.size(8.dp))
                Text("Plan: $subscriptionInfo")
                Text("Vencimiento: $expirationDate")
            }
            Spacer(Modifier.size(8.dp))
            Box(Modifier.weight(1f).fillMaxHeight(), contentAlignment = Alignment.TopEnd) {
                Icon(
                    modifier = Modifier.clickable(onClick = onQrTapped),
                    imageVector = Icons.Default.QrCode,
                    contentDescription = ""
                )
            }
        }
    }
}