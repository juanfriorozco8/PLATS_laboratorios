package uvg.plats.laboratorio_8.ui.characters

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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
fun CharactersScreen(onCharacterClick: (Int) -> Unit) {
    val list = CharacterDb().getAllCharacters()

    Scaffold(
        topBar = { TopAppBar(title = { Text("Characters") }) }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = padding
        ) {
            items(list) { c ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onCharacterClick(c.id) }
                        .padding(16.dp)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(c.image),
                        contentDescription = null,
                        modifier = Modifier.size(56.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(c.name, style = MaterialTheme.typography.titleMedium)
                        Text("${c.species} - ${c.status}")
                        Text("Gender: ${c.gender}")
                    }
                }
            }
        }
    }
}
