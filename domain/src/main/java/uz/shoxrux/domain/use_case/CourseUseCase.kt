package uz.shoxrux.domain.use_case

import uz.shoxrux.domain.repository.CoursesRepository
import javax.inject.Inject

class CourseUseCase @Inject constructor(
    private val repository: CoursesRepository
) {

    suspend fun getCourses() = repository.getCourses()

}