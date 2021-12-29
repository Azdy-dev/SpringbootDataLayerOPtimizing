package spring.boot.persistance.layer.optimizy.entity

import spring.boot.persistance.layer.optimizy.dto.CourseDto
import javax.persistence.*

@Entity
@Table(name = "course", indexes = [Index(name = "title_index", columnList = "title")])
class CourseEntity : BaseModel() {
    @Column
    private var title: String? = null

    @Column
    private var syllabus: String? = null

    @Column
    @ManyToMany(mappedBy = "course")
    private var student = mutableSetOf<StudentEntity>()

    override fun equals(obj: Any?): Boolean {
        if (this === obj) {
            return true
        }
        if (obj == null) {
            return false
        }
        return if (javaClass != obj.javaClass) {
            false
        } else id != null && id == (obj as CourseEntity).id
    }

    override fun hashCode(): Int {
        return java.util.Objects.hashCode(this.id)
    }
}

fun CourseEntity.toDto(): CourseDto {
    return CourseDto()
}