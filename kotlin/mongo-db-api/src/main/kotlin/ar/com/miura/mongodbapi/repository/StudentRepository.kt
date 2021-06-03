package ar.com.miura.mongodbapi.repository

import ar.com.miura.mongodbapi.domain.Student
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : MongoRepository<Student, String> {
}