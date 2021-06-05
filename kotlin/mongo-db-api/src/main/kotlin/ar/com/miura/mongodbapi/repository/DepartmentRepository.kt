package ar.com.miura.mongodbapi.repository

import ar.com.miura.mongodbapi.domain.Department
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface DepartmentRepository : MongoRepository<Department, String> {
}