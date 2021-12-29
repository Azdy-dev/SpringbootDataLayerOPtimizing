package spring.boot.persistance.layer.optimizy.dto

import spring.boot.persistance.layer.optimizy.entity.CourseEntity

data class CourseDto(var title:String?=null)


fun CourseDto.toEntity():CourseEntity{
    return CourseEntity()
}
