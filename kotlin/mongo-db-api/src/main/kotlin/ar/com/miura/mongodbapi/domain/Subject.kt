package ar.com.miura.mongodbapi.domain

import org.springframework.data.mongodb.core.mapping.Field

class Subject(
    @Field("subject_name")
    val name: String?="",
    @Field("marks_obtained")
    val marksObtained: Int =Integer.valueOf("0")
) {
}