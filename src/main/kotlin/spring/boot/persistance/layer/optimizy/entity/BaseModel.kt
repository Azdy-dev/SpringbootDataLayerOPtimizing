package spring.boot.persistance.layer.optimizy.entity

import org.hibernate.annotations.GenericGenerator
import org.springframework.data.annotation.*
import org.springframework.data.annotation.Id
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.util.*
import javax.persistence.*

@EntityListeners(AuditingEntityListener::class)
@MappedSuperclass
abstract class BaseModel {

    @javax.persistence.Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
    )
    @Column
    var id: UUID? = null

    @CreatedBy
    @Column(name = "CREATED_BY")
    private var createdBy: String? = null

    @CreatedDate
    @Column(name = "CREATED_DATE")
    private var createdDate: Date? = null

    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    private var lastModifiedBy: String? = null


    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE")
    private var lastModifiedDate: Date? = null

}