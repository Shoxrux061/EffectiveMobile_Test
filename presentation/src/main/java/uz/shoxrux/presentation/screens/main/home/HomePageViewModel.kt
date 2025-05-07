package uz.shoxrux.presentation.screens.main.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import uz.shoxrux.core.handler.NetworkResult
import uz.shoxrux.domain.model.Course
import uz.shoxrux.domain.use_case.CourseUseCase
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor(
    private val useCase: CourseUseCase
) : ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _courses = MutableStateFlow<List<Course>?>(null)
    val courses: StateFlow<List<Course>?> = _courses

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun getCourses() {

        try {
            viewModelScope.launch {
                useCase.getCourses().collect { result ->

                    when (result) {

                        is NetworkResult.Loading -> {
                            _isLoading.value = true
                            _error.value = null
                        }

                        is NetworkResult.Success -> {
                            _isLoading.value = false
                            _courses.value = result.data
                            _error.value = null
                        }

                        is NetworkResult.Error -> {
                            _isLoading.value = false
                            _error.value = result.message
                        }

                    }

                }
            }

        } catch (e: Exception) {
            _error.value = e.localizedMessage ?: "ViewModel: unknown error"
        }

    }

}