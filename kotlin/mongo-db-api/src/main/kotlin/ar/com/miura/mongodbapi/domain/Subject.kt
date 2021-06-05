package ar.com.miura.mongodbapi.domain

<<<<<<< HEAD
<<<<<<< HEAD
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection="subject")
class Subject(
    @Id
    val id: ObjectId = ObjectId.get(),
    @Field("subject_name")
    val subjectName: String?="",
=======
=======
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
>>>>>>> d8a8e34 (Added queries and endpoints .)
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection="subject")
class Subject(
    @Id
    val id: ObjectId = ObjectId.get(),
    @Field("subject_name")
<<<<<<< HEAD
    val name: String?="",
>>>>>>> 1125c07 (Feature/spring boot mongo kotlin)
=======
    val subjectName: String?="",
>>>>>>> d8a8e34 (Added queries and endpoints .)
    @Field("marks_obtained")
    val marksObtained: Int =Integer.valueOf("0")
) {
}