package ar.com.miura.mongodbapi.repository

import ar.com.miura.mongodbapi.domain.Student
import org.springframework.data.mongodb.repository.MongoRepository
<<<<<<< HEAD
<<<<<<< HEAD
import org.springframework.data.mongodb.repository.Query
=======
>>>>>>> 1125c07 (Feature/spring boot mongo kotlin)
=======
import org.springframework.data.mongodb.repository.Query
>>>>>>> d8a8e34 (Added queries and endpoints .)
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : MongoRepository<Student, String> {
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> d8a8e34 (Added queries and endpoints .)

    fun findByName(name:String):List<Student>

    fun findByNameAndEmail(name:String, email:String):Student

    fun findByNameOrEmail(name:String, email:String):Student

    fun findByDepartmentDepartmentName(departmentName:String):List<Student>;

    fun findBySubjectsSubjectName(subjectName:String):List<Student>;

    fun findByEmailIsLike(email:String):List<Student>

    fun findByNameStartsWith(name:String):List<Student>

    fun findByDepartmentId(id:String):List<Student>

    @Query("{\"name\":\"?0\"}")
    fun findByNameWithCustomQuery(name:String):List<Student>
<<<<<<< HEAD
=======
>>>>>>> 1125c07 (Feature/spring boot mongo kotlin)
=======
>>>>>>> d8a8e34 (Added queries and endpoints .)
}