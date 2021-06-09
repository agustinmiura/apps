package ar.com.miura.api.controller

import org.springframework.web.bind.annotation.GetMapping

import org.springframework.web.bind.annotation.RestController


@RestController
class LoansController {
    @GetMapping("/myLoans")
    fun getLoanDetails(input: String?): String {
        return "Here are the loan details from the DB"
    }
}
