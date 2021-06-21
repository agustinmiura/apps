package ar.com.miura.api.filter


import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.core.context.SecurityContextHolder
import javax.servlet.*


class AuthoritiesLoggingAfterFilter:Filter {

    private val LOG: Logger = LoggerFactory.getLogger(javaClass)

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain) {
        val authentication = SecurityContextHolder.getContext().authentication
        if (null != authentication) {
            LOG.info(
                "User " + authentication.name + " is successfully authenticated and "
                        + "has the authorities " + authentication.authorities.toString()
            )
        }
        chain.doFilter(request, response)
    }

}