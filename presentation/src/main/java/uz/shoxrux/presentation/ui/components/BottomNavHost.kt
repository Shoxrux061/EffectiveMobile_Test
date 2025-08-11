package uz.shoxrux.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uz.shoxrux.core.constants.NavRoutes
import uz.shoxrux.presentation.screens.main.MainViewModel
import uz.shoxrux.presentation.screens.main.favourites.FavouritesPage
import uz.shoxrux.presentation.screens.main.home.HomePage
import uz.shoxrux.presentation.ui.colors.BackgroundColor

@Composable
fun BottomNavHost(navController: NavHostController, paddingValues: PaddingValues) {

    val viewModel = hiltViewModel<MainViewModel>()

    LaunchedEffect(Unit) {
        viewModel.getCourses()
    }

    NavHost(
        navController = navController,
        startDestination = NavRoutes.HOME_PAGE,
        modifier = Modifier
            .background(BackgroundColor)
            .padding(paddingValues)
    ) {

        composable(NavRoutes.HOME_PAGE) {
            HomePage(viewModel)
        }

        composable(NavRoutes.SAVED_PAGE) {
            FavouritesPage(viewModel)
        }
        composable(NavRoutes.PROFILE_PAGE) {
            Box(modifier = Modifier.fillMaxSize()) {

                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "Профиль"
                )

            }
        }

    }

}