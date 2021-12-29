package spring.boot.persistance.layer.optimizy.entity

import spring.boot.persistance.layer.optimizy.dto.StudentDto
import javax.persistence.*


@Entity
@Table(name = "student")
class StudentEntity : BaseModel() {

    @Column
    var name: String? = null

    @Column
    var username: String? = null

    @Column
    @ManyToMany(cascade = [CascadeType.MERGE, CascadeType.PERSIST])
    @JoinTable(name = "student_course", joinColumns = [JoinColumn(name = "student_id")], inverseJoinColumns = [JoinColumn(name = "course_id")])
    var course = mutableSetOf<CourseEntity>()

    override fun equals(obj: Any?): Boolean {
        if (this === obj) {
            return true
        }
        if (obj == null) {
            return false
        }
        return if (javaClass != obj.javaClass) {
            false
        } else id != null && id == (obj as StudentEntity).id
    }

    override fun hashCode(): Int {
        return return java.util.Objects.hashCode(this.id)
    }
}

fun StudentEntity.toDto(): StudentDto {
    val entity = this
  return  StudentDto().apply {
        this.name = entity.name
        this.username = entity.username
        this.course = entity.course.mapNotNull { it.toDto() }.toMutableSet()
    }
}