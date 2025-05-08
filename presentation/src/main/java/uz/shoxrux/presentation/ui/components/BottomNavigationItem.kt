package uz.shoxrux.presentation.ui.components

import uz.shoxrux.core.constants.NavRoutes
import uz.shoxrux.presentation.R

sealed class BottomNavigationItem(val title: String, val iconId: Int, val route: String) {

    data object HomePage : BottomNavigationItem(
        title = "Главная",
        iconId = R.drawable.ic_home,
        route = NavRoutes.HOME_PAGE
    )

    data object SavedPage : BottomNavigationItem(
        title = "Избранные",
        iconId = R.drawable.ic_not_saved,
        route = NavRoutes.SAVED_PAGE
    )

    data object ProfilePage : BottomNavigationItem(
        title = "Аккаунт",
        iconId = R.drawable.ic_person,
        route = NavRoutes.PROFILE_PAGE
    )

}