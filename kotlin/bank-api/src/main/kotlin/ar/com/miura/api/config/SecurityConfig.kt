package ar.com.miura.api.config

import ar.com.miura.api.enum.SecurityConfigEnum
<<<<<<< HEAD
import ar.com.miura.api.enum.UserDetailsEnum
import org.springframework.context.annotation.Bean
=======
>>>>>>> f17257c (Created api with security)
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
<<<<<<< HEAD
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
=======
>>>>>>> f17257c (Created api with security)

@Configuration
open class SecurityConfig(disableDefaults: Boolean = false) : WebSecurityConfigurerAdapter(disableDefaults) {

    val securityConfig: SecurityConfigEnum = SecurityConfigEnum.CUSTOM

<<<<<<< HEAD
    val userDetailsConfig: UserDetailsEnum = UserDetailsEnum.MEMORY

=======
>>>>>>> f17257c (Created api with security)
    @Override
    override fun configure(http:HttpSecurity) {
        if (securityConfig==SecurityConfigEnum.CUSTOM) {
            http.authorizeRequests()
                .antMatchers("/myAccount").authenticated()
                .antMatchers("/myBalance").authenticated()
                .antMatchers("/myLoans").authenticated()
                .antMatchers("/myCards").authenticated()
                .antMatchers("/notices").permitAll()
                .antMatchers("/contact").permitAll()
                .and()
                .formLogin().and()
                .httpBasic()
        } else if (securityConfig==SecurityConfigEnum.DENY_ALL) {
            http.authorizeRequests().anyRequest().denyAll().and()
                .formLogin().and().httpBasic()
        } else {
            http.authorizeRequests().anyRequest().permitAll().and()
                .formLogin().and().httpBasic()
        }
    }

    @Override
    override fun configure(auth:AuthenticationManagerBuilder) {
<<<<<<< HEAD
        if (userDetailsConfig==UserDetailsEnum.MEMORY) {
            val userDetailsService = InMemoryUserDetailsManager()
            val user = User.withUsername("admin").password("12345").authorities("admin").build()
            val user1 = User.withUsername("user").password("12345").authorities("read").build()
            userDetailsService.createUser(user)
            userDetailsService.createUser(user1)
            auth.userDetailsService(userDetailsService)

        } else {
            auth.inMemoryAuthentication().withUser("admin").password("12345").authorities("admin")
                .and()
                .withUser("user").password("12345").authorities("read")
                .and().passwordEncoder((PlainTextPasswordEncoder()))
        }
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return PlainTextPasswordEncoder()
=======
        auth.inMemoryAuthentication().withUser("admin").password("12345").authorities("admin")
        .and()
        .withUser("user").password("12345").authorities("read")
        .and().passwordEncoder((PlainTextPasswordEncoder()))
>>>>>>> f17257c (Created api with security)
    }

}