package uvg.plats.laboratorio_8.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import uvg.plats.laboratorio_8.R

@Composable
fun LoginScreen(onStartClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.rnm_logo),
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )
        Spacer(Modifier.height(24.dp))
        Button(onClick = onStartClick) { Text("Entrar") }
        Spacer(Modifier.height(24.dp))
        Text("Juan Francisco Orozco Mijangos (24647)")
    }
}
