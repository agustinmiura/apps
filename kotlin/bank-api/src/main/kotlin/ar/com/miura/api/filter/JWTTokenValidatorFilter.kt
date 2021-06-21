package ar.com.miura.api.filter

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import java.nio.charset.StandardCharsets
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class JWTTokenValidatorFilter: OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        val requestServlet: HttpServletRequest = request as HttpServletRequest
        val jwt: String = requestServlet.getHeader(JWTTokenGeneratorFilter.JWT_HEADER)
        if (null != jwt) {
            try {
                val key = Keys.hmacShaKeyFor(
                    JWTTokenGeneratorFilter.JWT_KEY.toByteArray(StandardCharsets.UTF_8)
                )
                val claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(jwt)
                    .body
                val username = claims["username"].toString()
                val authorities = claims["authorities"] as String?
                val auth: Authentication = UsernamePasswordAuthenticationToken(
                    username, null,
                    AuthorityUtils.commaSeparatedStringToAuthorityList(authorities)
                )
                SecurityContextHolder.getContext().authentication = auth
            } catch (e: Exception) {
                throw BadCredentialsException("Invalid Token received!")
            }
        }
        chain.doFilter(request, response)
    }

    override protected fun shouldNotFilter(request: HttpServletRequest): Boolean {
        return request.getServletPath().equals("/user");
    }

}