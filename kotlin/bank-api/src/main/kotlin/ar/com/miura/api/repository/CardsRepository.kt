package ar.com.miura.api.repository

import ar.com.miura.api.domain.Cards
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface CardsRepository : CrudRepository<Cards?, Long?> {
    fun findByCustomerId(customerId: Int): List<Cards?>?
}
