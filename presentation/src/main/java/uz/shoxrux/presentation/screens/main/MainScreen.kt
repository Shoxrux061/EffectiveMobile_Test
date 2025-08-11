package uz.shoxrux.presentation.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import uz.shoxrux.presentation.ui.colors.BackgroundColor
import uz.shoxrux.presentation.ui.components.BottomNavHost
import uz.shoxrux.presentation.ui.components.BottomNavigation

@Composable
fun MainScreen() {

    val navController = rememberNavController()


    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor),
        bottomBar = {
            BottomNavigation(navController)
        }
    ) { paddingValues ->


        BottomNavHost(
            navController = navController,
            paddingValues
        )

    }

}