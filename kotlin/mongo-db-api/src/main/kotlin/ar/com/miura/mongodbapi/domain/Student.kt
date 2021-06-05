package ar.com.miura.mongodbapi.domain

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime

@Document(collection="student")
data class Student (
    @Id
    val id: ObjectId = ObjectId.get(),

    @Field(name="name")
    val name: String? = "",

    @Field(name="email")
    val email: String? = "",

    @Field(name="department")
    @DBRef(lazy=false)
    val department: Department? = Department(),

    @Field(name="subjects")
    @DBRef(lazy=false)
    val subjects: List<Subject> = ArrayList(),

    @Field(name="created_date")
    val createdDate: LocalDateTime = LocalDateTime.now(),

    @Field(name="modified_date")
    val modifiedDate: LocalDateTime = LocalDateTime.now(),

    @Transient
    val percentage: Double = 0.0

)