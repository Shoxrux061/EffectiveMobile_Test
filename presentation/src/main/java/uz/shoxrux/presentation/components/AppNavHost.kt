package uz.shoxrux.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uz.shoxrux.core.cache.LocaleCache
import uz.shoxrux.core.constants.NavRoutes
import uz.shoxrux.presentation.screens.auth.LoginScreen

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

        composable(NavRoutes.MAIN_SCREEN) { }

        composable(NavRoutes.SPLASH_SCREEN) { }

        composable(NavRoutes.ONBOARD_SCREEN) {
            Text("Onboard screen")
        }

    }

}