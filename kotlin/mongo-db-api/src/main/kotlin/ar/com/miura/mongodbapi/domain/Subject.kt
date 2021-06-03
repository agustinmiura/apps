package ar.com.miura.mongodbapi.domain

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
import org.springframework.data.mongodb.core.mapping.Field

class Subject(
    @Field("subject_name")
    val name: String?="",
>>>>>>> 1125c07 (Feature/spring boot mongo kotlin)
    @Field("marks_obtained")
    val marksObtained: Int =Integer.valueOf("0")
) {
}