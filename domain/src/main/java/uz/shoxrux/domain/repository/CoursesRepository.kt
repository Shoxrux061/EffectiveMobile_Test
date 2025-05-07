package uz.shoxrux.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.shoxrux.core.handler.NetworkResult
import uz.shoxrux.domain.model.Course

interface CoursesRepository {

    suspend fun getCourses(): Flow<NetworkResult<List<Course>>>

}