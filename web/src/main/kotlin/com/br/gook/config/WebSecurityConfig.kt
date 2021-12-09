package com.br.gook.config

import org.jboss.logging.Logger
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    private val log = Logger.getLogger(javaClass)

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .anyRequest().permitAll()
            .and().cors().and().csrf().disable()
            .addFilter(AuthorizationFilter(authenticationManager()))
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        http.exceptionHandling().accessDeniedHandler { _, response, accessDeniedException ->
            response.status = HttpStatus.UNAUTHORIZED.value()
            response.writer.println("Invalid userPermissions")
            log.warn(accessDeniedException.message, accessDeniedException)
        }
        http.headers().cacheControl()
    }
}
