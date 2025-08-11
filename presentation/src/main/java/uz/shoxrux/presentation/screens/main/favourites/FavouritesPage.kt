package uz.shoxrux.presentation.screens.main.favourites

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import uz.shoxrux.presentation.R
import uz.shoxrux.presentation.screens.main.MainViewModel
import uz.shoxrux.presentation.screens.main.home.CourseItem

@Composable
fun FavouritesPage(viewModel: MainViewModel) {

    val favourites = viewModel.favourites.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {

        Spacer(Modifier.height(20.dp))

        Text(
            text = stringResource(R.string.saveds),
            style = MaterialTheme.typography.titleLarge,
        )

        LazyColumn(modifier = Modifier.fillMaxSize()) {

            item {
                Spacer(Modifier.height(30.dp))
            }

            if (favourites.isNotEmpty()) {

                items(favourites.size) {

                    CourseItem(
                        title = favourites[it].title,
                        description = favourites[it].text,
                        price = favourites[it].price,
                        date = favourites[it].startDate,
                        rating = favourites[it].rate,
                        liked = favourites[it].hasLike,
                        image = favourites[it].image,
                        onSaveClick = {
                            if (favourites[it].hasLike) {
                                viewModel.deleteCourse(favourites[it].id)
                            } else {
                                viewModel.saveCourse(favourites[it])
                            }
                        }
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                }
            } else {
                item {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(
                            modifier = Modifier.align(Alignment.Center),
                            text = "Нет сохраненных курсов",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }
}