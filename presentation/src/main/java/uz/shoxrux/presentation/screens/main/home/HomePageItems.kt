package uz.shoxrux.presentation.screens.main.home

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import uz.shoxrux.presentation.R
import uz.shoxrux.presentation.ui.colors.DarkGray
import uz.shoxrux.presentation.ui.colors.Green
import uz.shoxrux.presentation.ui.colors.SemiTransparent
import uz.shoxrux.presentation.ui.colors.TextSecondary
import uz.shoxrux.presentation.ui.colors.White

@Composable
fun CourseItem(
    title: String,
    description: String,
    rating: String,
    liked: Boolean,
    date: String,
    price: String,
    image: String
) {

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(DarkGray),
        elevation = CardDefaults.elevatedCardElevation(0.dp)
    ) {
        Column {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(114.dp),
                shape = RoundedCornerShape(15.dp)
            ) {

                Box {

                    AsyncImage(
                        model = image,
                        modifier = Modifier.fillMaxSize(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )

                    Box(
                        modifier = Modifier
                            .padding(10.dp)
                            .size(28.dp)
                            .clip(CircleShape)
                            .background(SemiTransparent)
                            .align(Alignment.TopEnd)
                    ) {
                        Image(
                            modifier = Modifier.align(Alignment.Center),
                            painter = painterResource(if (liked) R.drawable.ic_saved else R.drawable.ic_not_saved),
                            contentDescription = null
                        )
                    }

                    Row(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                    ) {


                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .clip(CircleShape)
                                .background(SemiTransparent)
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(horizontal = 8.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {

                                Image(
                                    painter = painterResource(R.drawable.ic_star),
                                    contentDescription = null
                                )

                                Spacer(modifier = Modifier.width(5.dp))

                                Text(
                                    text = rating,
                                    style = TextStyle(
                                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                                        color = White,
                                        fontSize = 14.sp
                                    )
                                )
                            }
                        }
                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .clip(CircleShape)
                                .background(SemiTransparent)
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(horizontal = 8.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {

                                Text(
                                    text = date,
                                    style = TextStyle(
                                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                                        color = White,
                                        fontSize = 14.sp
                                    )
                                )
                            }
                        }
                    }
                }
            }

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = title,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_semi_bold)),
                        color = White
                    )
                )

                Text(
                    modifier = Modifier.padding(vertical = 10.dp),
                    text = description,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        fontSize = 14.sp,
                        color = TextSecondary
                    )
                )

                Box(modifier = Modifier.fillMaxWidth()) {

                    Text(
                        text = "$price ₽",
                        fontFamily = FontFamily(Font(R.font.roboto_semi_bold)),
                        color = White,
                        fontSize = 18.sp
                    )

                    Text(
                        modifier = Modifier.align(Alignment.CenterEnd),
                        text = "Подробнее ->",
                        fontFamily = FontFamily(Font(R.font.roboto_semi_bold)),
                        color = Green,
                        fontSize = 18.sp
                    )

                }

            }
        }
    }
}