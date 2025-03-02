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
import org.dev.onfit.ui.home.composables.ProfileCard
import org.dev.onfit.ui.home.composables.SportCenterCard

@Composable
fun HomeScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(Modifier.padding(20.dp)) {
            ProfileCard()
            Spacer(Modifier.size(16.dp))
            Text("Tu sede:", color = Color.DarkGray, fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
            Spacer(Modifier.size(8.dp))
            SportCenterCard()
        }
    }
}
