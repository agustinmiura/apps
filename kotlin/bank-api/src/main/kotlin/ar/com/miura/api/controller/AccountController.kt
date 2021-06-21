package ar.com.miura.api.controller

import ar.com.miura.api.domain.Accounts
import ar.com.miura.api.domain.Customer
import ar.com.miura.api.repository.AccountsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class AccountController @Autowired constructor(
    private val accountsRepository:AccountsRepository
) {
    @GetMapping("/myAccount")
    fun getAccountDetails(@RequestBody customer: Customer): Accounts? {
        val accounts = accountsRepository.findByCustomerId(customer.id)
        if (accounts!=null) {
            return accounts
        } else {
            return null
        }
    }
}