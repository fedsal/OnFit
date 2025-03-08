package org.dev.onfit.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.dev.onfit.ui.common.openWhatsapp
import org.dev.onfit.ui.home.composables.ProfileCredentialDialog
import org.dev.onfit.ui.home.composables.ProfileSection
import org.dev.onfit.ui.home.composables.SportCenterCard

@Composable
fun HomeScreen() {
    val uriHandler = LocalUriHandler.current
    Surface(modifier = Modifier.fillMaxSize()) {
        Box(Modifier.fillMaxSize()) {
            var showCredential by remember { mutableStateOf(false) }

            Column(Modifier.padding(20.dp)) {
                ProfileSection(
                    name = "Federico Salgado",
                    subscriptionInfo = "Plan: Vidriera 12 meses",
                    expirationDate = "02/08/2025",
                    healthAffidavitExpirationDate = "01/08/2025"
                ) {
                    showCredential = true
                }
                Spacer(Modifier.size(16.dp))
                Text(
                    "Tu sede:",
                    color = Color.DarkGray,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp
                )
                Spacer(Modifier.size(8.dp))
                SportCenterCard(
                    name = "OnFit Maschwitz",
                    address = "Calle rosales, entre Santiago del estero y Colectora este",
                    distance = "0.5 km",
                    onWhatsappTapped = {
                        openWhatsapp(
                            phoneNumber = "5491123456789",
                            uriHandler
                        )
                    },
                    onDirectionsTapped = { /*TODO*/ }
                )
            }
            if (showCredential) {
                ProfileCredentialDialog(
                    name = "Federico Salgado",
                    documentNumber = "43971990",
                    userId = "12345678",
                    onDismissRequest = { showCredential = false }
                )
            }
        }
    }
}
