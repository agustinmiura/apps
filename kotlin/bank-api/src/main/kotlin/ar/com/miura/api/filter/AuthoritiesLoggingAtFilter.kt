package ar.com.miura.api.filter

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.IOException
import javax.servlet.*


class AuthoritiesLoggingAtFilter: Filter {
    private val LOG: Logger = LoggerFactory.getLogger(javaClass)

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain) {
        LOG.info("Authentication Validation is in progress")
        chain.doFilter(request, response)
    }
}