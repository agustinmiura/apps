package ar.com.miura.mongodbapi.repository

import ar.com.miura.mongodbapi.domain.Subject
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface SubjectRepository : MongoRepository<Subject, String> {
}