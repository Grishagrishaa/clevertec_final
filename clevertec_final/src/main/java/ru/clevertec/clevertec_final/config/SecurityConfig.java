package ru.clevertec.clevertec_final.config;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.clevertec.clevertec_final.controller.filters.JwtFilter;
import ru.clevertec.clevertec_final.security.enums.ERole;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtFilter filter;
    private static final String PUBLIC_ENDPOINTS = "/**";
    private static final String NEWS_ENDPOINTS = "/news/**";
    private static final String COMMENT_ENDPOINTS = "/comments/**";



    public SecurityConfig(JwtFilter filter) {
        this.filter = filter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable().cors().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()
                .authenticationEntryPoint(
                        (request, response, ex) -> {
                            response.sendError(
                                    HttpServletResponse.SC_UNAUTHORIZED,
                                    ex.getMessage()
                            );
                        }
                )
                .and()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, PUBLIC_ENDPOINTS).permitAll()
                .requestMatchers(HttpMethod.POST, COMMENT_ENDPOINTS).hasAuthority(ERole.USER.name())
                .requestMatchers(HttpMethod.POST, NEWS_ENDPOINTS).hasAnyAuthority(ERole.ADMIN.name(), ERole.JOURNALIST.name())
                .requestMatchers(HttpMethod.PUT, NEWS_ENDPOINTS).hasAnyAuthority(ERole.ADMIN.name(), ERole.JOURNALIST.name())
                .requestMatchers(HttpMethod.PUT, COMMENT_ENDPOINTS).hasAnyAuthority(ERole.USER.name())
                .requestMatchers(HttpMethod.DELETE, NEWS_ENDPOINTS, COMMENT_ENDPOINTS).hasAnyAuthority(ERole.ADMIN.name())
                .anyRequest().authenticated()
                .and()
                .httpBasic(Customizer.withDefaults()) // (4)
                .build();
    }

}
