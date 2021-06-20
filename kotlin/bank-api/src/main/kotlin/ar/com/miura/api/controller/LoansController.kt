package ar.com.miura.api.controller

import ar.com.miura.api.domain.Customer
import ar.com.miura.api.domain.Loans
import ar.com.miura.api.repository.LoanRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class LoansController {

    @Autowired
    private val loanRepository: LoanRepository? = null

    @PostMapping("/myLoans")
    fun getLoanDetails(@RequestBody customer: Customer): List<Loans?>? {
        return loanRepository!!.findByCustomerIdOrderByStartDtDesc(customer.id)
    }

}
