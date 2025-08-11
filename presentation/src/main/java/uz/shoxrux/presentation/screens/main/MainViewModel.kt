package uz.shoxrux.presentation.screens.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import uz.shoxrux.core.handler.NetworkResult
import uz.shoxrux.domain.model.course.Course
import uz.shoxrux.domain.use_case.CourseUseCase
import uz.shoxrux.presentation.screens.main.home.HomeUiState
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: CourseUseCase
) : ViewModel() {

    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState: StateFlow<HomeUiState> = _homeUiState

    private val _favourites = MutableStateFlow<List<Course>>(emptyList())
    val favourites: StateFlow<List<Course>> = _favourites

    fun getCourses() {
        viewModelScope.launch {
            combine(
                useCase.getCourses(),
                useCase.getSavedCourses()
            ) { result, savedCourses ->
                when (result) {
                    is NetworkResult.Loading -> {
                        _homeUiState.update { state ->
                            state.copy(isLoading = true, error = null)
                        }
                    }

                    is NetworkResult.Success -> {
                        val savedIds = savedCourses.map { it.id }.toSet()
                        val updatedCourses = result.data.orEmpty().map { course ->
                            course.copy(hasLike = course.id in savedIds)
                        }
                        _homeUiState.update { state ->
                            state.copy(
                                isLoading = false,
                                courses = updatedCourses,
                                error = null
                            )
                        }
                    }

                    is NetworkResult.Error -> {
                        _homeUiState.update { state ->
                            state.copy(isLoading = false, error = result.message)
                        }
                    }
                }
            }.collect {}
        }
    }

    init {
        viewModelScope.launch {
            useCase.getSavedCourses().collect { result ->
                _favourites.value = result.map { it.copy(hasLike = true) }
            }
        }

    }

    fun saveCourse(course: Course) {

        viewModelScope.launch {
            useCase.saveCourse(course)
        }

    }

    fun deleteCourse(id: Int) {
        viewModelScope.launch {
            useCase.deleteCourse(id)
        }
    }

}
