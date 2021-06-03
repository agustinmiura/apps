package ar.com.miura.mongodbapi.domain

import org.springframework.data.mongodb.core.mapping.Field

class Department(
    @Field("department_name")
    val departmentName: String?="",
    @Field("location")
    val location:String?=""
) {

}