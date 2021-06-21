package ar.com.miura.api.filter

import ar.com.miura.api.constants.Messages
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import java.nio.charset.StandardCharsets
import java.util.*
import javax.crypto.SecretKey
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class JWTTokenGeneratorFilter: OncePerRequestFilter() {

    /**
    * TODO : Move to constants
    */
    companion object {
        val JWT_KEY = "jxgEQeXHuPq8VdbyYFNkANdudQ53YUn4"
        val JWT_HEADER = "Authorization"
    }

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        val authentication: Authentication? = SecurityContextHolder.getContext().authentication
        if (null != authentication) {
            val key: SecretKey = Keys.hmacShaKeyFor(JWT_KEY.toByteArray(StandardCharsets.UTF_8))
            val jwt: String = Jwts.builder().setIssuer("bank").setSubject("JWT Token")
                .claim("username", authentication.getName())
                .claim("authorities", populateAuthorities(authentication.authorities))
                .setIssuedAt(Date())
                .setExpiration(Date(Date().getTime() + 3000000000))
                .signWith(key).compact()
            response.setHeader(Messages.ERROR_MSG, jwt)
        }
        chain.doFilter(request, response)
    }

    override fun shouldNotFilter(request: HttpServletRequest): Boolean {
        return request.servletPath != "/user"
    }

    private fun populateAuthorities(collection: MutableCollection<out GrantedAuthority>): String? {
        val authoritiesSet: MutableSet<String> = HashSet()
        for (authority in collection) {
            authoritiesSet.add(authority.authority)
        }
        return java.lang.String.join(",", authoritiesSet)
    }
}