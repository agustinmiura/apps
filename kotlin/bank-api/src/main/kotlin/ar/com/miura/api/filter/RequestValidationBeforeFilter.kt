package ar.com.miura.api.filter

import org.apache.commons.lang3.StringUtils
import org.springframework.http.HttpHeaders.AUTHORIZATION
import org.springframework.security.authentication.BadCredentialsException
import java.io.IOException
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets
import java.util.*
import javax.servlet.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class RequestValidationBeforeFilter: Filter {

    val AUTHENTICATION_SCHEME_BASIC = "Basic"
    private val credentialsCharset: Charset = StandardCharsets.UTF_8

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        val req = request as HttpServletRequest
        val res = response as HttpServletResponse
        var header = req.getHeader(AUTHORIZATION)
        if (header != null) {
            header = header.trim { it <= ' ' }
            if (StringUtils.startsWithIgnoreCase(header, AUTHENTICATION_SCHEME_BASIC)) {
                val base64Token: ByteArray = header.substring(6).toByteArray(StandardCharsets.UTF_8)
                val decoded: ByteArray
                try {
                    decoded = Base64.getDecoder().decode(base64Token)
                    val token = String(decoded, getCredentialsCharset(req))
                    val delim = token.indexOf(":")
                    if (delim == -1) {
                        throw BadCredentialsException("Invalid basic authentication token")
                    }
                    val email = token.substring(0, delim)
                    if (email.toLowerCase().contains("test")) {
                        res.status = HttpServletResponse.SC_BAD_REQUEST
                        return
                    }
                } catch (e: IllegalArgumentException) {
                    throw BadCredentialsException("Failed to decode basic authentication token")
                }
            }
        }
        chain.doFilter(request, response)
    }

    protected fun getCredentialsCharset(request: HttpServletRequest?): Charset {
        return getCredentialsCharset()
    }

    fun getCredentialsCharset(): Charset {
        return credentialsCharset
    }
}