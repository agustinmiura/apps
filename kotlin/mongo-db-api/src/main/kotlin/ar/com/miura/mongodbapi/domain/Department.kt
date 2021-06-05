package ar.com.miura.mongodbapi.domain

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection="department")
class Department(
    @Id
    val id: ObjectId = ObjectId.get(),
    @Field("department_name")
    val departmentName: String?="",
    @Field("location")
    val location:String?=""
) {

}