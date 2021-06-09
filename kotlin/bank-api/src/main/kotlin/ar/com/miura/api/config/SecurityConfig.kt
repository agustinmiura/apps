package ar.com.miura.api.config

import ar.com.miura.api.enum.SecurityConfigEnum
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
open class SecurityConfig(disableDefaults: Boolean = false) : WebSecurityConfigurerAdapter(disableDefaults) {

    val securityConfig: SecurityConfigEnum = SecurityConfigEnum.CUSTOM

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
        auth.inMemoryAuthentication().withUser("admin").password("12345").authorities("admin")
        .and()
        .withUser("user").password("12345").authorities("read")
        .and().passwordEncoder((PlainTextPasswordEncoder()))
    }

}