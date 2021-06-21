package ar.com.miura.api.repository

import ar.com.miura.api.domain.Customer
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : CrudRepository<Customer, Long> {
    fun findByEmail(email: String): List<Customer>
}
