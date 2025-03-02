package org.dev.onfit.ui.home.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Whatsapp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import onfit.composeapp.generated.resources.Res
import onfit.composeapp.generated.resources.logo_icon
import org.dev.onfit.ui.theme.whatsappGreen
import org.jetbrains.compose.resources.painterResource

@Composable
fun SportCenterCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)
                .height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(verticalArrangement = Arrangement.Top, modifier = Modifier.fillMaxHeight()) {
                Image(
                    painter = painterResource(Res.drawable.logo_icon),
                    modifier = Modifier.size(90.dp).clip(RoundedCornerShape(10.dp))
                        .background(Color.Gray),
                    contentDescription = null
                )
                Spacer(Modifier.size(8.dp))
            }
            Spacer(Modifier.size(16.dp))
            Column(
                Modifier.weight(1f).padding(bottom = 8.dp).fillMaxSize(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                Row {
                    Column(modifier = Modifier.weight(1f).fillMaxWidth()) {
                        Text(
                            text = "OnFit Maschwitz",
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(Modifier.size(4.dp))
                        HorizontalDivider(thickness = 2.dp, color = Color.LightGray)
                    }
                    Spacer(Modifier.width(16.dp))
                    Icon(
                        imageVector = Icons.Default.Whatsapp,
                        "",
                        tint = whatsappGreen,
                        modifier = Modifier.size(24.dp)
                    )
                }
                Spacer(Modifier.size(8.dp))
                Text(
                    text = "Calle rosales, entre Santiago del estero y Colectora este",
                    style = TextStyle(fontSize = 14.sp, color = Color.DarkGray),
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.size(12.dp))
                Box(Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier.align(Alignment.CenterStart),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "",
                            tint = Color.Gray,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(Modifier.width(2.dp))
                        Text(
                            "0.2 km",
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Gray,
                            fontSize = 14.sp
                        )
                    }
                    Row(modifier = Modifier.align(Alignment.CenterEnd)) {
                        Text(
                            text = "Como llegar",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp
                        )
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = ""
                        )
                    }
                }
            }
            Box(Modifier.fillMaxHeight(), contentAlignment = Alignment.TopEnd) {

            }
        }
    }
}