package org.dev.onfit.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.dev.onfit.ui.home.composables.ProfileSection
import org.dev.onfit.ui.home.composables.SportCenterCard

@Composable
fun HomeScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(Modifier.padding(20.dp)) {
            ProfileSection(
                name = "Federico Salgado",
                subscriptionInfo = "Plan: Vidriera 12 meses",
                expirationDate = "02/08/2025",
                healthAffidavitExpirationDate = "01/08/2025"
            ) {
                // TODO: handle QR tapped
            }
            Spacer(Modifier.size(16.dp))
            Text("Tu sede:", color = Color.DarkGray, fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
            Spacer(Modifier.size(8.dp))
            SportCenterCard(
                name = "OnFit Maschwitz",
                address = "Calle rosales, entre Santiago del estero y Colectora este",
                distance = "0.5 km",
                onWhatsappTapped = { /*TODO*/ },
                onDirectionsTapped = { /*TODO*/ }
            )
        }
    }
}
