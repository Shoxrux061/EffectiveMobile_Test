package uz.shoxrux.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uz.shoxrux.core.constants.NavRoutes
import uz.shoxrux.presentation.screens.main.home.HomePage
import uz.shoxrux.presentation.screens.main.home.HomePageViewModel
import uz.shoxrux.presentation.ui.colors.BackgroundColor

@Composable
fun BottomNavHost(navController: NavHostController, paddingValues: PaddingValues) {

    val viewModel = hiltViewModel<HomePageViewModel>()

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
            Text("saved")
        }
        composable(NavRoutes.PROFILE_PAGE) {
            Text("profile")
        }

    }

}