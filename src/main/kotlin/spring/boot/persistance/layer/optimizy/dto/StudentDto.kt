package spring.boot.persistance.layer.optimizy.dto

import spring.boot.persistance.layer.optimizy.entity.StudentEntity
import java.util.*

data class StudentDto(
        var id:UUID?=null,
        var name: String? = null,
        var username: String? = null,
        var course: MutableSet<CourseDto>? = mutableSetOf()
)

fun StudentDto.toEntity():StudentEntity {
    val dto = this
    return StudentEntity().apply {
        this.id=dto.id
        this.name = dto.name
        this.username = username
        this.course = dto.course?.mapNotNull { it.toEntity() }?.toMutableSet() ?: mutableSetOf()
    }
}
