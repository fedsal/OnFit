package org.dev.onfit.ui.home.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import qrgenerator.QRCodeImage

@Composable
fun ProfileCredentialDialog(
    name: String,
    documentNumber: String,
    userId: String,
    onDismissRequest: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                Modifier.fillMaxWidth().padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Tu credencial", fontWeight = FontWeight.Bold, fontSize = 24.sp)
                Spacer(Modifier.size(24.dp))
                Box(Modifier.size(200.dp)) {
                    QRCodeImage(
                        url = userId,
                        contentDescription = "Tu credencial",
                        modifier = Modifier.size(200.dp)
                    )
                }
                Spacer(Modifier.size(32.dp))
                Text(name, fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                Spacer(Modifier.size(8.dp))
                Text(
                    "DNI: $documentNumber",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp
                )
            }
        }
    }
}
