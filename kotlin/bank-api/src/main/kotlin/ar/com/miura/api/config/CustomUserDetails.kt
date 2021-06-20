package ar.com.miura.api.config

import ar.com.miura.api.domain.CustomDetails
import ar.com.miura.api.domain.Customer
import ar.com.miura.api.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

/**
 * Custom user details for the custom user
 */
@Service
class CustomUserDetails @Autowired constructor(
    private val customRepository: CustomerRepository) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val users: List<Customer>? = customRepository.findByEmail(username)
            if (users!=null && users.isEmpty()) {
                throw UsernameNotFoundException(" User not found : ${username}")
            }
        return CustomDetails(users?.get(0) ?: Customer())
    }
}