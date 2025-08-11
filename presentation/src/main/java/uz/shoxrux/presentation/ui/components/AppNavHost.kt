package uz.shoxrux.presentation.ui.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uz.shoxrux.core.cache.LocaleCache
import uz.shoxrux.core.constants.NavRoutes
import uz.shoxrux.presentation.screens.auth.LoginScreen
import uz.shoxrux.presentation.screens.main.MainScreen
import uz.shoxrux.presentation.screens.on_board.OnBoardScreen

@Composable
fun AppNavHost(cache: LocaleCache) {

    val navController = rememberNavController()

    NavHost(
        navController,
        startDestination = if (cache.isFirst()) NavRoutes.ONBOARD_SCREEN else NavRoutes.AUTH_SCREEN
    ) {

        composable(NavRoutes.AUTH_SCREEN) {
            LoginScreen(navController)
        }

        composable(NavRoutes.MAIN_SCREEN) {
            MainScreen()
        }

        composable(NavRoutes.SPLASH_SCREEN) { }

        composable(NavRoutes.ONBOARD_SCREEN) {
            OnBoardScreen(navController, cache)
        }

    }

}