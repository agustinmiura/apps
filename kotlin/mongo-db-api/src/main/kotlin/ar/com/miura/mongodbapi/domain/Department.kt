package ar.com.miura.mongodbapi.domain

<<<<<<< HEAD
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection="department")
class Department(
    @Id
    val id: ObjectId = ObjectId.get(),
=======
import org.springframework.data.mongodb.core.mapping.Field

class Department(
>>>>>>> 1125c07 (Feature/spring boot mongo kotlin)
    @Field("department_name")
    val departmentName: String?="",
    @Field("location")
    val location:String?=""
) {

}