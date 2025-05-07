package uz.shoxrux.presentation.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import uz.shoxrux.core.constants.NavRoutes
import uz.shoxrux.presentation.R
import uz.shoxrux.presentation.components.AppButton
import uz.shoxrux.presentation.components.CustomTextFieldWithHeader
import uz.shoxrux.presentation.ui.colors.BackgroundColor
import uz.shoxrux.presentation.ui.colors.Blue
import uz.shoxrux.presentation.ui.colors.Green
import uz.shoxrux.presentation.ui.colors.Orange1
import uz.shoxrux.presentation.ui.colors.Stroke
import uz.shoxrux.presentation.ui.colors.White

@Composable
fun LoginScreen(navController: NavHostController) {

    val isSubmitted = remember { mutableStateOf(false) }

    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val emailPattern = Regex(stringResource(R.string.email_regax))

    val isValid by remember {
        derivedStateOf {
            emailPattern.matches(email.value.trim()) && password.value.isNotBlank()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Вход",
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                fontSize = 30.sp,
                color = White
            )
        )

        Spacer(modifier = Modifier.height(30.dp))

        CustomTextFieldWithHeader(
            hint = "Email",
            hint2 = "example@gmail.com",
            value = email.value,
            onValueChange = {
                email.value = it
            },
            isEmpty = isSubmitted.value && email.value.isEmpty()
        )

        Spacer(modifier = Modifier.height(10.dp))

        CustomTextFieldWithHeader(
            hint = "Пароль",
            hint2 = "Введите пароль",
            value = password.value,
            onValueChange = {
                password.value = it
            },
            isEmpty = isSubmitted.value && password.value.isEmpty()
        )

        Spacer(modifier = Modifier.height(30.dp))

        AppButton(

            onCLick = {
                navController.navigate(NavRoutes.MAIN_SCREEN)
            },
            text = "Вход",
            modifier = Modifier.alpha(if (!isValid) 0.5f else 1f)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = White)) {
                    append("Нету аккаунта? ")
                }
                withStyle(style = SpanStyle(color = Green)) {
                    append("Регистрация")
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.roboto_medium))
        )

        Spacer(modifier = Modifier.height(5.dp))


        Text(
            fontSize = 14.sp,
            color = Green,
            fontFamily = FontFamily(Font(R.font.roboto_medium)),
            text = "Забыл пароль",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Box(
            modifier = Modifier
                .padding(vertical = 30.dp)
                .fillMaxWidth()
                .height(1.dp)
                .background(Stroke)
        )

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            Button(
                onClick = {

                },
                modifier = Modifier
                    .weight(1f)
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(Blue)

            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_vkontakte),
                    contentDescription = null,
                    tint = Color.White
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            Button(
                onClick = {

                },
                modifier = Modifier
                    .weight(1f)
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(Orange1)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_odnoklassnik),
                    contentDescription = null,
                    tint = Color.White
                )
            }

        }

    }
}