package ar.com.miura.api.repository

import ar.com.miura.api.domain.Accounts
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface AccountsRepository : CrudRepository<Accounts?, Long?> {
    fun findByCustomerId(customerId: Int): Accounts?
}
