package ar.com.miura.api.controller

import ar.com.miura.api.domain.Customer
import ar.com.miura.api.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal


@RestController
class LoginController @Autowired constructor(private val customerRepository: CustomerRepository) {
    @RequestMapping("/user")
    fun getUserDetailsAfterLogin(user: Principal): Customer? {
        val customers: List<Customer>? = customerRepository.findByEmail(user.name)
        return if (  customers!=null && customers.size > 0) {
            customers?.get(0)
        } else {
            null
        }
    }

}