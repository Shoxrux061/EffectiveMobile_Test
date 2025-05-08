package uz.shoxrux.presentation.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.shoxrux.presentation.R
import uz.shoxrux.presentation.ui.colors.Blue
import uz.shoxrux.presentation.ui.colors.Green
import uz.shoxrux.presentation.ui.colors.Error1
import uz.shoxrux.presentation.ui.colors.Error2
import uz.shoxrux.presentation.ui.colors.LightGray
import uz.shoxrux.presentation.ui.colors.TextSecondary
import uz.shoxrux.presentation.ui.colors.Transparent
import uz.shoxrux.presentation.ui.colors.White

@Composable
fun CustomTextFieldWithHeader(
    hint: String,
    value: String,
    hint2: String,
    onValueChange: (String) -> Unit,
    isEmpty: Boolean
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    Column {
        Text(
            text = hint,
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                fontSize = 18.sp,
                color = Color.White
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .border(
                    width = 1.dp,
                    color = when {
                        isFocused -> Blue
                        isEmpty -> Error1
                        else -> Transparent
                    },
                    shape = RoundedCornerShape(30.dp)
                )
                .background(LightGray, shape = RoundedCornerShape(30.dp)),
            contentAlignment = Alignment.CenterStart
        ) {
            if (value.isEmpty()) {
                Text(
                    text = hint2,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    color = TextSecondary,
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .align(Alignment.CenterStart)
                )
            }

            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                interactionSource = interactionSource,
                cursorBrush = SolidColor(Blue),
                singleLine = true,
                textStyle = TextStyle(
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    fontSize = 14.sp,
                    color = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 10.dp)
            )
        }
    }
}


@Composable
fun AppButton(
    text: String,
    onCLick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Button(
        onClick = {
            onCLick.invoke()
        },
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp),
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.buttonColors(Green)
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                color = White,
                fontSize = 16.sp
            )
        )
    }

}

@Composable
fun LoadingBar() {

    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(56.dp)
                .align(Alignment.Center),
            color = Green
        )
    }

}

@Composable
fun ErrorBar(error: String) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(Error2),
        border = BorderStroke(width = 1.dp, color = Error1),
        shape = RoundedCornerShape(10.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = error,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Error1,
                    fontFamily = FontFamily(Font(R.font.roboto_semi_bold))
                )
            )
        }

    }
}