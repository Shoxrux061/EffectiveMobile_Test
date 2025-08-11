package uz.shoxrux.effectivemobiletest.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import uz.shoxrux.data.network.CourseService
import uz.shoxrux.data.repository.CoursesRepositoryImpl
import uz.shoxrux.data.room.dao.SaveDao
import uz.shoxrux.domain.repository.CoursesRepository
import uz.shoxrux.domain.use_case.CourseUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoursesModule {

    @[Provides Singleton]
    fun provideCourseService(retrofit: Retrofit): CourseService {
        return retrofit.create(CourseService::class.java)
    }

    @[Provides Singleton]
    fun provideCourseRepository(service: CourseService, dao: SaveDao): CoursesRepository {
        return CoursesRepositoryImpl(service, dao)
    }

    @[Provides Singleton]
    fun provideCourseUseCase(repository: CoursesRepository): CourseUseCase {
        return CourseUseCase(repository)
    }

}