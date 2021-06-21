package ar.com.miura.api.config

import ar.com.miura.api.domain.Authority
import ar.com.miura.api.filter.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
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
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .cors().configurationSource {
            val config = CorsConfiguration()
            config.allowedOrigins = Collections.singletonList("http://localhost:4200")
            config.allowedMethods = Collections.singletonList("*")
            config.allowCredentials = true
            config.allowedHeaders = Collections.singletonList("*")
            config.exposedHeaders = Arrays.asList("Authorization")
            config.maxAge = 3600L
            config
        }.and().csrf().disable()
        /*
        .addFilterBefore(RequestValidationBeforeFilter(), BasicAuthenticationFilter::class.java)
        .addFilterAfter(AuthoritiesLoggingAfterFilter(), BasicAuthenticationFilter::class.java)
        .addFilterAt(AuthoritiesLoggingAtFilter(), BasicAuthenticationFilter::class.java)
        */
        .addFilterBefore(JWTTokenValidatorFilter(), BasicAuthenticationFilter::class.java)
        .addFilterAfter(JWTTokenGeneratorFilter(), BasicAuthenticationFilter::class.java)
        .authorizeRequests()
        .antMatchers("/myAccount").hasRole("USER")
        .antMatchers("/myBalance").hasAnyRole("USER", "ADMIN")
        .antMatchers("/myLoans").hasRole("ROOT")
        .antMatchers("/myCards").hasAnyRole("USER", "ADMIN")
        .antMatchers("/user").authenticated()
        .antMatchers("/notices").permitAll()
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


