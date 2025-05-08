package uz.shoxrux.data.mapper

import uz.shoxrux.data.dto.CourseDTO
import uz.shoxrux.domain.model.Course

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