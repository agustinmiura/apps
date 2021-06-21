package ar.com.miura.api.config

import ar.com.miura.api.domain.Authority
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.csrf.CookieCsrfTokenRepository
import org.springframework.web.cors.CorsConfiguration
import java.util.*
import kotlin.collections.ArrayList


@Configuration
class SecurityConfig(disableDefaults: Boolean = false) : WebSecurityConfigurerAdapter(disableDefaults) {

    /**
     * /myAccount - Secured /myBalance - Secured /myLoans - Secured /myCards -
     * Secured /notices - Not Secured /contact - Not Secured
     */
    override fun configure(http: HttpSecurity) {
        http.cors().configurationSource {
            val config = CorsConfiguration()
            config.allowedOrigins = Collections.singletonList("http://localhost:4200")
            config.allowedMethods = Collections.singletonList("*")
            config.allowCredentials = true
            config.allowedHeaders = Collections.singletonList("*")
            config.maxAge = 3600L
            config
        }.and().csrf()
            .ignoringAntMatchers("/contact").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
            .authorizeRequests()
            .antMatchers("/myAccount").hasAnyAuthority("UPDATE","READ")
            .antMatchers("/myBalance").authenticated()
            .antMatchers("/myLoans").authenticated()
            .antMatchers("/myCards").authenticated()
            .antMatchers("/user").authenticated()
            .antMatchers("/notices")
            .permitAll()
            .antMatchers("/contact").permitAll().and().httpBasic();
    }

    private fun getGrantedAuthorities(authorities: Set<Authority>): List<GrantedAuthority>? {
        val grantedAuthorities: MutableList<GrantedAuthority> = ArrayList()
        for (authority in authorities) {
            grantedAuthorities.add(SimpleGrantedAuthority(authority.name))
        }
        return grantedAuthorities
    }

    /**
     * PlainTextPasswordEncoder
     * BCryptPasswordEncoder
     */
    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

}


