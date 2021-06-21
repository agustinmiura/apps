package ar.com.miura.api.controller

import ar.com.miura.api.domain.AccountTransactions
import ar.com.miura.api.domain.Customer
import ar.com.miura.api.repository.AccountTransactionsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class CardsController {
    @Autowired
    private val accountTransactionsRepository: AccountTransactionsRepository? = null

    @PostMapping("/myBalance")
    fun getBalanceDetails(@RequestBody customer: Customer): List<AccountTransactions?>? {
        return accountTransactionsRepository!!.findByCustomerIdOrderByTransactionDtDesc(customer.id)
    }
}