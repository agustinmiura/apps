package ar.com.miura.api.controller

import org.springframework.web.bind.annotation.GetMapping

import org.springframework.web.bind.annotation.RestController


@RestController
class BalanceController {
    @GetMapping("/myBalance")
    fun getBalanceDetails(input: String?): String {
        return "Here are the balance details from the DB"
    }
}
