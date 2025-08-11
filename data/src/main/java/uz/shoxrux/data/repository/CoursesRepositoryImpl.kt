package uz.shoxrux.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import uz.shoxrux.core.handler.NetworkResult
import uz.shoxrux.data.mapper.toDomain
import uz.shoxrux.data.mapper.toEntity
import uz.shoxrux.data.network.CourseService
import uz.shoxrux.data.room.dao.SaveDao
import uz.shoxrux.domain.model.course.Course
import uz.shoxrux.domain.repository.CoursesRepository
import javax.inject.Inject

class CoursesRepositoryImpl @Inject constructor(
    private val service: CourseService,
    private val dao: SaveDao
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

    override suspend fun getCourseFromDB(): Flow<List<Course>> = flow {

        dao.getAllSaved().collect { result ->
            emit(result.map { it.toDomain() })
        }

    }

    override suspend fun saveCourse(course: Course) {
        dao.insert(course.toEntity())
    }

    override suspend fun deleteCourse(id: Int) {
        dao.deleteById(id)
    }

}