package ar.com.miura.api.repository

import ar.com.miura.api.domain.Customer
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomRepository : CrudRepository<Customer, String>{
    fun findByEmail(email:String):List<Customer>
}