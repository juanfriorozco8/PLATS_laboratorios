package uvg.plats.laboratorio_8.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val Light = lightColorScheme(
    primary = Primary,
    secondary = Secondary,
    tertiary = Secondary
)

@Composable
fun Laboratorio8Theme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = Light, content = content)
}
