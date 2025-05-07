package uz.shoxrux.data.network

import retrofit2.Response
import retrofit2.http.GET
import uz.shoxrux.data.dto.CoursesResponseDTO

interface CourseService {

    @GET("/effective_test")
    suspend fun getCourses(): Response<CoursesResponseDTO>

}