package ar.com.miura.mongodbapi.domain

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> d8a8e34 (Added queries and endpoints .)
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection="department")
class Department(
    @Id
    val id: ObjectId = ObjectId.get(),
<<<<<<< HEAD
=======
import org.springframework.data.mongodb.core.mapping.Field

class Department(
>>>>>>> 1125c07 (Feature/spring boot mongo kotlin)
=======
>>>>>>> d8a8e34 (Added queries and endpoints .)
    @Field("department_name")
    val departmentName: String?="",
    @Field("location")
    val location:String?=""
) {

}