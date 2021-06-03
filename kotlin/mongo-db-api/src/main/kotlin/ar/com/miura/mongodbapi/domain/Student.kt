package ar.com.miura.mongodbapi.domain

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
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
    val department: Department? = Department(),

    @Field(name="subjects")
    val subjects: List<Subject> = ArrayList<Subject>(),

    @Field(name="created_date")
    val createdDate: LocalDateTime = LocalDateTime.now(),

    @Field(name="modified_date")
    val modifiedDate: LocalDateTime = LocalDateTime.now()


)