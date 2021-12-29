package spring.boot.persistance.layer.optimizy.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import spring.boot.persistance.layer.optimizy.dto.StudentDto
import spring.boot.persistance.layer.optimizy.service.StudentService
import java.util.*
import javax.print.attribute.standard.Media

@Controller
@RestController
class StudentController @Autowired constructor(private val studentService: StudentService) {

    @GetMapping("/students/{id}",produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getStudent(@PathVariable id: UUID): StudentDto? {
        return studentService.getStudent(id)
    }

    @PostMapping("/students", consumes =[MediaType.APPLICATION_JSON_VALUE],produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createStudent(@RequestBody student: StudentDto): StudentDto {
        return studentService.createStudent(student)
    }
}