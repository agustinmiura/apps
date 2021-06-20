package ar.com.miura.api.config

import ar.com.miura.api.enum.SecurityConfigEnum
import ar.com.miura.api.enum.UserDetailsEnum
import ar.com.miura.api.repository.CustomRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.provisioning.JdbcUserDetailsManager
import javax.sql.DataSource;

@Configuration
open class SecurityConfig(disableDefaults: Boolean = false) : WebSecurityConfigurerAdapter(disableDefaults) {

    val securityConfig: SecurityConfigEnum = SecurityConfigEnum.CUSTOM

    val userDetailsConfig: UserDetailsEnum = UserDetailsEnum.MEMORY

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
                .formLogin()
                .defaultSuccessUrl("/myAccount")
                .and()
                .httpBasic()

        } else if (securityConfig==SecurityConfigEnum.DENY_ALL) {
            http.authorizeRequests().anyRequest().denyAll().and()
                .formLogin().and().httpBasic()
        } else {
            http.authorizeRequests().anyRequest().permitAll().and()
                .formLogin().and().httpBasic()
        }
    }

    /* Uncomment to use in memory user details
    @Override
    override fun configure(auth:AuthenticationManagerBuilder) {
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
    */

    /**
     * Use with the default security schema
     */
    /*
    @Bean
    fun userDetailsService(dataSource:DataSource):UserDetailsService {
        return JdbcUserDetailsManager(dataSource)
    }
    */

    /**
     * PlainTextPasswordEncoder
     * BCryptPasswordEncoder
     */
    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

}