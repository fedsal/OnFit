package org.dev.onfit.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import onfit.composeapp.generated.resources.Res
import onfit.composeapp.generated.resources.logo
import org.dev.onfit.ui.common.composables.CustomTextField
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = koinViewModel()
) {
    val uiState = viewModel.uiState.collectAsState()
    var rememberUser = remember { mutableStateOf(false) }
    if (uiState.value.loggedIn) {
        // TODO: Navigate to the next screen
        return
    }
    Surface {
        Column(
            modifier = Modifier.fillMaxSize().padding(vertical = 32.dp, horizontal = 20.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(16.dp))
            Image(
                modifier = Modifier.width(220.dp).height(100.dp),
                painter = painterResource(Res.drawable.logo),
                contentDescription = null
            )
            Spacer(Modifier.height(32.dp))
            // Email field
            var email by remember { mutableStateOf("") }
            CustomTextField(
                modifier = Modifier.fillMaxWidth(),
                value = email,
                onValueChange = { email = it },
                placeholder = "Ingrese su email",
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Email,
                        tint = MaterialTheme.colorScheme.primary,
                        contentDescription = null
                    )
                }
            )
            Spacer(Modifier.height(16.dp))
            // Password field
            var password by remember { mutableStateOf("") }
            CustomTextField(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                onValueChange = { password = it },
                isPassword = true,
                placeholder = "Ingrese su contraseña",
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Visibility,
                        tint = Color.LightGray,
                        contentDescription = null
                    )
                }
            )
            // Remember me
            Spacer(Modifier.height(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Recuérdame", Modifier.weight(1f), fontSize = 18.sp)
                Spacer(Modifier.width(8.dp))
                Switch(checked = rememberUser.value, onCheckedChange = { rememberUser.value = it })
            }
            // Login button
            Spacer(Modifier.height(16.dp))
            Button(
                onClick = {
                    viewModel.login(email, password, rememberUser.value)
                },
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(16.dp),
                enabled = uiState.value.isLoading.not(),
            ) {
                if (uiState.value.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.width(24.dp).height(24.dp),
                        color = Color.White
                    )
                } else {
                    Text("Ingresar", color = Color.White)
                }
            }
            // Forgot password
            Spacer(Modifier.height(24.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Recuperar contraseña",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 18.sp,
                    textDecoration = TextDecoration.Underline,
                    textAlign = TextAlign.Start
                )
            )
            // Terminos y condiciones
            Spacer(Modifier.weight(1f))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Terminos y condiciones",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.Underline,
                )
            )
        }
    }
}
