package org.dev.onfit.ui.common.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import onfit.composeapp.generated.resources.Res
import onfit.composeapp.generated.resources.logo
import org.jetbrains.compose.resources.painterResource

@Composable
fun OnFitTopBar(
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = Modifier.background(MaterialTheme.colorScheme.surfaceContainer).drawBehind {
            val shadowColor = Color.Black.copy(alpha = 0.1f)
            val shadowHeight = 1.dp.toPx()
            val yOffset = size.height
            drawRect(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, shadowColor),
                    startY = yOffset - shadowHeight,
                    endY = yOffset
                ),
                topLeft = Offset(0f, yOffset - shadowHeight),
            )
        }, content = content
    )
}

@Composable
fun HomeTopBarContent(onAccountTapped: () -> Unit) {
    Box(modifier = Modifier.fillMaxWidth().height(60.dp).padding(10.dp)) {
        Row(
            modifier = Modifier.align(Alignment.Center), horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(Res.drawable.logo),
                contentDescription = "Centered Image",
                modifier = Modifier.size(90.dp)
            )
        }
        Icon(
            imageVector = Icons.Rounded.AccountCircle,
            contentDescription = "Settings Icon",
            modifier = Modifier.size(30.dp).align(Alignment.CenterEnd)
                .clickable(onClick = onAccountTapped),
            tint = Color.DarkGray
        )
    }
}