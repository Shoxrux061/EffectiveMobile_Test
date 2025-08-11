package uz.shoxrux.effectivemobiletest.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.shoxrux.data.room.AppDatabase
import uz.shoxrux.data.room.dao.SaveDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "notes_database"
        ).build()
    }

    @Provides
    fun provideNoteDao(db: AppDatabase): SaveDao {
        return db.saveDao()
    }
}