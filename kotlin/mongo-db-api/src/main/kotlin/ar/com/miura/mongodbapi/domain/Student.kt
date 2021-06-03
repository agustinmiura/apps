package ar.com.miura.mongodbapi.domain

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
<<<<<<< HEAD
import org.springframework.data.mongodb.core.mapping.DBRef
=======
>>>>>>> 1125c07 (Feature/spring boot mongo kotlin)
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
<<<<<<< HEAD
    @DBRef(lazy=false)
    val department: Department? = Department(),

    @Field(name="subjects")
    @DBRef(lazy=false)
    val subjects: List<Subject> = ArrayList(),
=======
    val department: Department? = Department(),

    @Field(name="subjects")
    val subjects: List<Subject> = ArrayList<Subject>(),
>>>>>>> 1125c07 (Feature/spring boot mongo kotlin)

    @Field(name="created_date")
    val createdDate: LocalDateTime = LocalDateTime.now(),

    @Field(name="modified_date")
<<<<<<< HEAD
    val modifiedDate: LocalDateTime = LocalDateTime.now(),

    @Transient
    val percentage: Double = 0.0
=======
    val modifiedDate: LocalDateTime = LocalDateTime.now()

>>>>>>> 1125c07 (Feature/spring boot mongo kotlin)

)