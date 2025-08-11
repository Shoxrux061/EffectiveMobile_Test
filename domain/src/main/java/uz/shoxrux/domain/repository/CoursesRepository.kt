package uz.shoxrux.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.shoxrux.core.handler.NetworkResult
import uz.shoxrux.domain.model.course.Course

interface CoursesRepository {

    suspend fun getCourses(): Flow<NetworkResult<List<Course>>>

    suspend fun getCourseFromDB(): Flow<List<Course>>

    suspend fun saveCourse(course: Course)

    suspend fun deleteCourse(id: Int)

}