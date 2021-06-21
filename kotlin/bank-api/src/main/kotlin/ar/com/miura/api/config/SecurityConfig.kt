package ar.com.miura.api.config

<<<<<<< HEAD
import ar.com.miura.api.enum.SecurityConfigEnum
<<<<<<< HEAD
<<<<<<< HEAD
import ar.com.miura.api.enum.UserDetailsEnum
=======
import ar.com.miura.api.domain.Authority
<<<<<<< HEAD
>>>>>>> 4146936 (feature/security roles)
=======
import ar.com.miura.api.filter.*
>>>>>>> a5a8c6a (Feature/jwt)
import org.springframework.context.annotation.Bean
=======
>>>>>>> f17257c (Created api with security)
=======
import ar.com.miura.api.enum.UserDetailsEnum
import org.springframework.context.annotation.Bean
>>>>>>> 75427a7 (feature/security)
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
<<<<<<< HEAD
=======
>>>>>>> f17257c (Created api with security)
=======
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
>>>>>>> 75427a7 (feature/security)
=======
import org.springframework.security.provisioning.JdbcUserDetailsManager
import javax.sql.DataSource;
>>>>>>> 99c6fa6 (feature/security)
=======
=======
=======
import org.springframework.security.config.http.SessionCreationPolicy
>>>>>>> 397d0f8 (Feature/jwt)
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
>>>>>>> 4146936 (feature/security roles)
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import org.springframework.security.web.csrf.CookieCsrfTokenRepository
import org.springframework.web.cors.CorsConfiguration
import java.util.*
import kotlin.collections.ArrayList

>>>>>>> f0f8522 (feature/security Added repositories and services.)

@Configuration
class SecurityConfig(disableDefaults: Boolean = false) : WebSecurityConfigurerAdapter(disableDefaults) {

<<<<<<< HEAD
    val securityConfig: SecurityConfigEnum = SecurityConfigEnum.CUSTOM

<<<<<<< HEAD
<<<<<<< HEAD
    val userDetailsConfig: UserDetailsEnum = UserDetailsEnum.MEMORY

=======
>>>>>>> f17257c (Created api with security)
=======
    val userDetailsConfig: UserDetailsEnum = UserDetailsEnum.MEMORY

<<<<<<< HEAD
>>>>>>> 75427a7 (feature/security)
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 75427a7 (feature/security)
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

=======
>>>>>>> f0f8522 (feature/security Added repositories and services.)
=======
>>>>>>> 4146936 (feature/security roles)
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
<<<<<<< HEAD
        }.and().csrf()
<<<<<<< HEAD
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
=======
        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
        .and().addFilterBefore(RequestValidationBeforeFilter(), BasicAuthenticationFilter::class.java)
=======
        }.and().csrf().disable()
        /*
        .addFilterBefore(RequestValidationBeforeFilter(), BasicAuthenticationFilter::class.java)
>>>>>>> 397d0f8 (Feature/jwt)
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
>>>>>>> a5a8c6a (Feature/jwt)
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
<<<<<<< HEAD
        return PlainTextPasswordEncoder()
<<<<<<< HEAD
=======
        auth.inMemoryAuthentication().withUser("admin").password("12345").authorities("admin")
        .and()
        .withUser("user").password("12345").authorities("read")
        .and().passwordEncoder((PlainTextPasswordEncoder()))
>>>>>>> f17257c (Created api with security)
=======
>>>>>>> 75427a7 (feature/security)
=======
        return BCryptPasswordEncoder()
>>>>>>> e4ab3b2 (feature/security Added custom authentication provider.)
    }

}


