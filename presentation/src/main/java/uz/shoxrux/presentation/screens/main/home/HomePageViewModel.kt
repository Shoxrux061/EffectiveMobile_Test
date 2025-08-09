package uz.shoxrux.presentation.screens.main.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import uz.shoxrux.core.handler.NetworkResult
import uz.shoxrux.domain.model.Course
import uz.shoxrux.domain.use_case.CourseUseCase
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor(
    private val useCase: CourseUseCase
) : ViewModel() {

    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState: StateFlow<HomeUiState> = _homeUiState

    fun getCourses() {
        viewModelScope.launch {
            useCase.getCourses().collect { result ->
                _homeUiState.update { state ->
                    when (result) {
                        is NetworkResult.Loading -> state.copy(
                            isLoading = true,
                            error = null
                        )

                        is NetworkResult.Success -> state.copy(
                            isLoading = false,
                            courses = result.data,
                            error = null
                        )

                        is NetworkResult.Error -> state.copy(
                            isLoading = false,
                            error = result.message
                        )
                    }
                }
            }
        }
    }
}
