package uz.shoxrux.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.shoxrux.core.handler.NetworkResult
import uz.shoxrux.data.mapper.toDomain
import uz.shoxrux.data.network.CourseService
import uz.shoxrux.domain.model.Course
import uz.shoxrux.domain.repository.CoursesRepository
import javax.inject.Inject

class CoursesRepositoryImpl @Inject constructor(
    private val service: CourseService
) : CoursesRepository {

    override suspend fun getCourses(): Flow<NetworkResult<List<Course>>> = flow {
        emit(NetworkResult.Loading())

        try {
            val result = service.getCourses()
            if (result.isSuccessful) {
                val body = result.body()
                val courses = body?.firstOrNull()?.courses?.map { it.toDomain() }

                if (courses != null) {
                    emit(NetworkResult.Success(courses))
                } else {
                    emit(NetworkResult.Error("Courses not found"))
                }
            } else {
                emit(NetworkResult.Error("Error: ${result.code()} ${result.message()}"))
            }
        } catch (e: Exception) {
            emit(NetworkResult.Error(e.localizedMessage ?: "Unknown error"))
        }
    }


}