package ar.com.miura.api.domain

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class CustomDetails constructor(private val customer:Customer): UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val autorities:MutableCollection<GrantedAuthority> = ArrayList()
        return autorities
    }

    override fun getPassword(): String {
        return customer.pwd
    }

    override fun getUsername(): String {
       return customer.email
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
       return true
    }

    override fun isEnabled(): Boolean {
      return true
    }
}