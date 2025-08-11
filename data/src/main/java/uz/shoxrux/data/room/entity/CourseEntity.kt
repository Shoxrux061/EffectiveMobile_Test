package uz.shoxrux.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved")
data class CourseEntity(

    val hasLike: Boolean,
    @PrimaryKey val id: Int,
    val price: String,
    val publishDate: String,
    val rate: String,
    val startDate: String,
    val text: String,
    val title: String,
    val image: String

)
