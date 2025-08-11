package uz.shoxrux.domain.use_case

import uz.shoxrux.domain.model.course.Course
import uz.shoxrux.domain.repository.CoursesRepository
import javax.inject.Inject

class CourseUseCase @Inject constructor(
    private val repository: CoursesRepository
) {

    suspend fun getCourses() = repository.getCourses()

    suspend fun saveCourse(course: Course) = repository.saveCourse(course)

    suspend fun deleteCourse(id: Int) = repository.deleteCourse(id)

    suspend fun getSavedCourses() = repository.getCourseFromDB()

}