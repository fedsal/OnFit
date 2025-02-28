package org.dev.onfit.ui.navigation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
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
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
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
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProfileScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(Modifier.padding(20.dp)) {
            ProfileCard()
        }
    }
}

@Composable
fun ProfileCard() {
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
                Text("Federico Salgado", color = Color.Black, fontSize = 18.sp, style = TextStyle(fontWeight = FontWeight.Bold))
                Spacer(Modifier.size(8.dp))
                Text("Plan: Vidriera 12 meses")
                Text("Vencimiento: 02/08/2025")
            }
            Spacer(Modifier.size(8.dp))
            Box(Modifier.weight(1f).fillMaxHeight(), contentAlignment = Alignment.BottomEnd) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = ""
                )
            }
        }
    }
}