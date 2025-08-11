package uz.shoxrux.data.mapper

import uz.shoxrux.data.dto.CourseDTO
import uz.shoxrux.data.room.entity.CourseEntity
import uz.shoxrux.domain.model.course.Course

fun CourseDTO.toDomain(): Course {

    return Course(
        hasLike = this.hasLike,
        id = this.id,
        price = this.price,
        publishDate = this.publishDate,
        rate = this.rate,
        startDate = this.startDate,
        text = this.text,
        title = this.title,
        image = this.image
    )

}

fun CourseEntity.toDomain(): Course {
    return Course(
        hasLike = this.hasLike,
        id = this.id,
        price = this.price,
        publishDate = this.publishDate,
        rate = this.rate,
        startDate = this.startDate,
        text = this.text,
        title = this.title,
        image = this.image
    )
}

fun Course.toEntity(): CourseEntity {

    return CourseEntity(
        hasLike = this.hasLike,
        id = this.id,
        price = this.price,
        publishDate = this.publishDate,
        rate = this.rate,
        startDate = this.startDate,
        text = this.text,
        title = this.title,
        image = this.image
    )

}