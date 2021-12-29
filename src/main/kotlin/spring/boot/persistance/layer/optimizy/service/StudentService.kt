package spring.boot.persistance.layer.optimizy.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.webjars.NotFoundException
import spring.boot.persistance.layer.optimizy.dto.StudentDto
import spring.boot.persistance.layer.optimizy.dto.toEntity
import spring.boot.persistance.layer.optimizy.entity.toDto
import spring.boot.persistance.layer.optimizy.repository.StudentRepository
import java.util.*

@Service
class StudentService @Autowired constructor(private val studentRepository: StudentRepository) {

    fun getStudent(id: UUID): StudentDto? =
            studentRepository.findStudentEntityById(id)?.toDto()?:null

    fun createStudent(studentDto: StudentDto): StudentDto {
        val studentEntity = studentDto.toEntity()
        val result = studentRepository.save(studentEntity)
        return result.toDto()
    }

    fun updateStudent(studentDto: StudentDto): StudentDto {
        if (studentDto.id == null)
            throw NoSuchFieldException("Id of student not found")
        val studentEntity = studentRepository.findStudentEntityById(studentDto.id!!)
                ?: throw NotFoundException("User not found exception")
        studentEntity?.apply {
            this.name = studentDto.name
            this.username = studentDto.username
            this.course = studentDto.course?.map { it.toEntity() }?.toMutableSet() ?: mutableSetOf()
        }
        val result = studentRepository.save(studentEntity)
        return result.toDto()
    }

    fun deleteStudent(id: UUID): Boolean {
        studentRepository.deleteById(id)
        return true
    }

}