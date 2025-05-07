package uz.shoxrux.presentation.screens.on_board

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import uz.shoxrux.core.cache.LocaleCache
import uz.shoxrux.core.constants.NavRoutes
import uz.shoxrux.presentation.R
import uz.shoxrux.presentation.components.AppButton
import uz.shoxrux.presentation.ui.colors.BackgroundColor
import uz.shoxrux.presentation.ui.colors.White

@Composable
fun OnBoardScreen(navController: NavHostController, cache: LocaleCache) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ) {

        Spacer(modifier = Modifier.height(80.dp))

        Text(
            text = "Тысячи курсов\nв одном месте",
            fontFamily = FontFamily(Font(R.font.roboto_medium)),
            fontSize = 30.sp,
            color = White,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(40.dp))


        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(316.dp),
            painter = painterResource(R.drawable.courses_onboard),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        Spacer(modifier = Modifier.weight(1f))

        AppButton(
            text = "Продолжить",
            onCLick = {
                navController.navigate(NavRoutes.AUTH_SCREEN)
                cache.saveIsNotFirst()
            },
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

    }

}