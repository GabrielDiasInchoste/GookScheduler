package com.br.gook.config

import org.jboss.logging.Logger
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AuthorizationFilter(
    authenticationManager: AuthenticationManager
) : BasicAuthenticationFilter(authenticationManager) {

    private val log = Logger.getLogger(javaClass)

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        val securityContext = SecurityContextHolder.getContext()
        securityContext.authentication = UsernamePasswordAuthenticationToken(
            null,
            null,
            request.getHeader("userPermissions")?.split(",")?.map { SimpleGrantedAuthority("ROLE_$it") }
        )
        chain.doFilter(request, response)
    }
}
