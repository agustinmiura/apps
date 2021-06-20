package ar.com.miura.api.config

import ar.com.miura.api.enum.SecurityConfigEnum
import ar.com.miura.api.enum.UserDetailsEnum
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.csrf.CookieCsrfTokenRepository
import org.springframework.web.cors.CorsConfiguration
import java.util.*


@Configuration
class SecurityConfig(disableDefaults: Boolean = false) : WebSecurityConfigurerAdapter(disableDefaults) {

    val securityConfig: SecurityConfigEnum = SecurityConfigEnum.CUSTOM

    val userDetailsConfig: UserDetailsEnum = UserDetailsEnum.MEMORY

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
        }.and().csrf().ignoringAntMatchers("/contact")
            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and().authorizeRequests()
            .antMatchers("/myAccount").authenticated().antMatchers("/myBalance").authenticated()
            .antMatchers("/myLoans").authenticated().antMatchers("/myCards").authenticated()
            .antMatchers("/user").authenticated().antMatchers("/notices").permitAll()
            .antMatchers("/contact").permitAll().and().httpBasic()
    }

    private fun getCorsConfiguration():CorsConfiguration {
        var config:CorsConfiguration = CorsConfiguration()
        config.allowedOrigins = Collections.singletonList("http://localhost:4200")
        config.allowedMethods = Collections.singletonList("*")
        config.allowCredentials = true
        config.allowedHeaders = Collections.singletonList("*")
        config.maxAge = 3600L
        return config
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


