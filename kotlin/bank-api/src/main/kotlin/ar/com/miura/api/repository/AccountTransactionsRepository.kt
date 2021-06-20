package ar.com.miura.api.repository

import ar.com.miura.api.domain.AccountTransactions
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface AccountTransactionsRepository : CrudRepository<AccountTransactions?, Long?> {
    fun findByCustomerIdOrderByTransactionDtDesc(customerId: Int): List<AccountTransactions?>?
}
