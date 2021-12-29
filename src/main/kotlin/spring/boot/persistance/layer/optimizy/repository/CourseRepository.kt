package spring.boot.persistance.layer.optimizy.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import spring.boot.persistance.layer.optimizy.entity.CourseEntity

@Repository
interface CourseRepository:JpaRepository<CourseEntity,Long>