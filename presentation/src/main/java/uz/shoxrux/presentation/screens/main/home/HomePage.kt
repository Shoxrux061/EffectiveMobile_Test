package uz.shoxrux.presentation.screens.main.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.shoxrux.presentation.R
import uz.shoxrux.presentation.ui.components.ErrorBar
import uz.shoxrux.presentation.ui.components.LoadingBar
import uz.shoxrux.presentation.ui.colors.BackgroundColor
import uz.shoxrux.presentation.ui.colors.DarkGray
import uz.shoxrux.presentation.ui.colors.Green
import uz.shoxrux.presentation.ui.colors.TextHint
import uz.shoxrux.presentation.ui.colors.TextSecondary

@Composable
fun HomePage(viewModel: HomePageViewModel) {

    val courses = viewModel.courses.collectAsState().value
    val isLoading = viewModel.isLoading.collectAsState().value
    val error = viewModel.error.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .padding(horizontal = 16.dp)

    ) {

        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier.fillMaxWidth()) {

            Card(
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp),
                shape = RoundedCornerShape(30.dp),
                colors = CardDefaults.cardColors(DarkGray),

                ) {

                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_search),
                        contentDescription = null,
                        tint = Color.White
                    )

                    Spacer(Modifier.width(15.dp))

                    Text(
                        text = "Search courses...",
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.roboto_regular)),
                            color = TextHint,
                            fontSize = 16.sp
                        )
                    )
                }
            }

            Spacer(Modifier.width(20.dp))

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(56.dp)
                    .background(DarkGray)
            ) {
                Icon(
                    modifier = Modifier.align(Alignment.Center),
                    painter = painterResource(R.drawable.ic_filter),
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }


        Row(
            modifier = Modifier
                .align(Alignment.End)
                .padding(vertical = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "По дате обновления",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    color = Green,
                    fontSize = 16.sp
                )
            )

            Spacer(Modifier.width(5.dp))

            Icon(
                painter = painterResource(R.drawable.ic_sort),
                contentDescription = null,
                tint = Green
            )

        }

        if (courses != null) {

            LazyColumn {
                items(4) {
                    CourseItem(
                        title = courses[it].title,
                        description = courses[it].text,
                        price = courses[it].price,
                        date = courses[it].startDate,
                        rating = courses[it].rate,
                        liked = courses[it].hasLike,
                        image = courses[it].image
                    )

                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        } else if (isLoading) {
            LoadingBar()
        } else {
            ErrorBar(error ?: "Unknown error")
        }
    }
}