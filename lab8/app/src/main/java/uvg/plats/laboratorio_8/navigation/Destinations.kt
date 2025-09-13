package uvg.plats.laboratorio_8.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import uvg.plats.laboratorio_8.ui.characters.CharactersScreen
import uvg.plats.laboratorio_8.ui.detail.CharacterDetailScreen
import uvg.plats.laboratorio_8.ui.login.LoginScreen

@Serializable object Login
@Serializable object Characters
@Serializable data class CharacterDetail(val id: Int)

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Login) {

        composable<Login> {
            LoginScreen(
                onStartClick = {
                    navController.navigate(Characters) {
                        popUpTo(Login) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<Characters> {
            CharactersScreen(
                onCharacterClick = { id -> navController.navigate(CharacterDetail(id)) }
            )
        }

        composable<CharacterDetail> { entry ->
            val args = entry.toRoute<CharacterDetail>()
            CharacterDetailScreen(
                characterId = args.id,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
