package org.dev.onfit.ui.common.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import qrgenerator.QRCodeImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QRBottomSheet(
    sheetState: SheetState,
    onDismissRequest: () -> Unit,
    accessToken: String,
    expirationTime: Int,
) {
    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        sheetState = sheetState,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().height(700.dp).padding(20.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Tu código de acceso:", style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.SemiBold))
            Spacer(Modifier.height(48.dp))
            QRCodeImage(
                modifier = Modifier.size(250.dp),
                url = accessToken,
                contentDescription = "Código de acceso al gimnasio"
            )
            Spacer(Modifier.height(48.dp))
            // Expires in functionality
            val expireCounter = remember { mutableStateOf(expirationTime) }
            val scope = rememberCoroutineScope()
            LaunchedEffect(Unit) {
                scope.launch(Dispatchers.IO) {
                    while (expireCounter.value > 0) {
                        delay(1000)
                        expireCounter.value -= 1
                    }
                    sheetState.hide()
                    onDismissRequest()
                }
            }
            Text("El código expira en ${expireCounter.value} segundos", style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold))
        }
    }
}