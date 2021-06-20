package ar.com.miura.api.config

import ar.com.miura.api.domain.Customer
import ar.com.miura.api.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component


@Component
class CustomAuthenticationProvider @Autowired constructor(
    private val customRepository:CustomerRepository,
    private val passwordEncoder:PasswordEncoder
):AuthenticationProvider{

    override fun authenticate(authentication: Authentication): Authentication? {
        val username = authentication.name
        val pwd = authentication.credentials.toString()
        val customers: List<Customer>? = customRepository.findByEmail(username)
        return if (customers!=null && customers.isNotEmpty()) {
            if (passwordEncoder!!.matches(pwd, customers[0].pwd)) {
                val authorities: MutableList<GrantedAuthority> = ArrayList()
                authorities.add(SimpleGrantedAuthority(customers[0].role))
                UsernamePasswordAuthenticationToken(username, pwd, authorities)
            } else {
                throw BadCredentialsException("Invalid password!")
            }
        } else {
            throw BadCredentialsException("No user registered with this details!")
        }
    }
    override fun supports(authenticationType: Class<*>): Boolean {
        return authenticationType == UsernamePasswordAuthenticationToken::class.java
    }
}