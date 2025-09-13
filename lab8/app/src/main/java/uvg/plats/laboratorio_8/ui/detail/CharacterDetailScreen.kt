package uvg.plats.laboratorio_8.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import uvg.plats.laboratorio_8.data.CharacterDb

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterDetailScreen(characterId: Int, onBack: () -> Unit) {
    val c = CharacterDb().getCharacterById(characterId)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Character details") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(c.image),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
            Text(c.name)
            Text("Species: ${c.species}")
            Text("Status: ${c.status}")
            Text("Gender: ${c.gender}")
        }
    }
}
