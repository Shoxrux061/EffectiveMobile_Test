package uz.shoxrux.data.room

import androidx.room.RoomDatabase
import androidx.room.Database
import uz.shoxrux.data.room.dao.SaveDao
import uz.shoxrux.data.room.entity.CourseEntity

@Database(entities = [CourseEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun saveDao(): SaveDao
}