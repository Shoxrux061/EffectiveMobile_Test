package uz.shoxrux.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import uz.shoxrux.presentation.R
import uz.shoxrux.presentation.ui.colors.BackgroundColor
import uz.shoxrux.presentation.ui.colors.DarkGray
import uz.shoxrux.presentation.ui.colors.Green
import uz.shoxrux.presentation.ui.colors.SemiTransparent
import uz.shoxrux.presentation.ui.colors.Stroke
import uz.shoxrux.presentation.ui.colors.White

@Composable
fun BottomNavigation(
    navController: NavController
) {

    val listItem = listOf(
        BottomNavigationItem.HomePage,
        BottomNavigationItem.SavedPage,
        BottomNavigationItem.ProfilePage,
    )
    Column {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.5.dp)
                .background(Stroke)
        )

        NavigationBar(
            containerColor = DarkGray,
            modifier = Modifier.background(BackgroundColor)
        ) {
            val backStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = backStackEntry?.destination?.route
            listItem.forEach { item ->
                NavigationBarItem(
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route)
                    },
                    icon = {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(item.iconId),
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_regular))
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Green,
                        selectedTextColor = Green,
                        unselectedIconColor = White,
                        unselectedTextColor = White,
                        indicatorColor = SemiTransparent
                    )
                )
            }
        }
    }
}
