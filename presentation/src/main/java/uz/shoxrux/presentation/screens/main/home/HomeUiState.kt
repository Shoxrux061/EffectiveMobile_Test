package uz.shoxrux.presentation.screens.main.home

import uz.shoxrux.domain.model.course.Course

data class HomeUiState(
    val courses: List<Course>? = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
