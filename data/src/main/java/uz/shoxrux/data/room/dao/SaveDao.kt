package uz.shoxrux.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uz.shoxrux.data.room.entity.CourseEntity
@Dao
interface SaveDao {

    @Query("SELECT * FROM saved")
    fun getAllSaved(): Flow<List<CourseEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(savedEntity: CourseEntity)

    @Query("DELETE FROM saved WHERE id = :id")
    suspend fun deleteById(id: Int)
}