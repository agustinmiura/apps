package ar.com.miura.api.config

import ar.com.miura.api.domain.Customer
import ar.com.miura.api.repository.CustomRepository
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
    private val customRepository:CustomRepository,
    private val passwordEncoder:PasswordEncoder
):AuthenticationProvider{

    override fun authenticate(authentication: Authentication): Authentication? {
        val username = authentication.name
        val pwd = authentication.credentials.toString()
        val customer: List<Customer> = customRepository.findByEmail(username)
        return if (customer.size > 0) {
            if (passwordEncoder!!.matches(pwd, customer[0].pwd)) {
                val authorities: MutableList<GrantedAuthority> = ArrayList()
                authorities.add(SimpleGrantedAuthority(customer[0].role_column))
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