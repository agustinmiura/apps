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
        }.and().csrf().disable()
            /*
            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            .and().addFilterBefore(RequestValidationBeforeFilter(), BasicAuthenticationFilter::class.java)
            .addFilterAfter(AuthoritiesLoggingAfterFilter(), BasicAuthenticationFilter::class.java)
            .addFilterAt(AuthoritiesLoggingAtFilter(), BasicAuthenticationFilter::class.java)
            */
            /*
            .and()
            .authorizeRequests()
            .antMatchers("/myAccount").hasRole("USER")
            .antMatchers("/myBalance").hasAnyRole("USER", "ADMIN")
            .antMatchers("/myLoans").hasRole("ROOT")
            .antMatchers("/myCards").hasAnyRole("USER", "ADMIN")
            .antMatchers("/user").permitAll()
            .antMatchers("/notices").permitAll()
            */
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


