package spring.boot.persistance.layer.optimizy.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import spring.boot.persistance.layer.optimizy.entity.StudentEntity
import java.util.*

@Repository
interface StudentRepository:JpaRepository<StudentEntity,UUID> {

    fun  findStudentEntityById(id:UUID):StudentEntity?
}
