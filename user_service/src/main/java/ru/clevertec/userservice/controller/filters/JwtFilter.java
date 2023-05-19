package ru.clevertec.userservice.controller.filters;

import ru.clevertec.userservice.service.UserService;
import ru.clevertec.userservice.security.utils.JwtTokenUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import java.io.IOException;
import java.util.List;

import static org.apache.logging.log4j.util.Strings.isEmpty;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;


/**
 * Component for filtering and processing JWT authentication in a web application.
 */
@Component
public class JwtFilter extends OncePerRequestFilter {

    private final UserService service;

    public JwtFilter(UserService service) {
        this.service = service;
    }

    @Override
    /**
     * Filters and processes the JWT authentication for each incoming request.
     *
     * @param request       The incoming HTTP request.
     * @param response      The HTTP response.
     * @param filterChain   The filter chain for invoking subsequent filters.
     * @throws ServletException     If the filter encounters a servlet-related issue.
     * @throws IOException          If an I/O error occurs during the filter execution.
     */
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {


        final String header = request.getHeader(AUTHORIZATION);

        if (isEmpty(header) || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        final String token = header.substring(7);
        if(!JwtTokenUtil.validate(token)){
            filterChain.doFilter(request, response);
            return;
        }

        UserDetails userDetails = service.loadUserByUsername(JwtTokenUtil.getUsername(token));

        if(!userDetails.isEnabled()){
            filterChain.doFilter(request, response);
            return;
        }


        UsernamePasswordAuthenticationToken
                authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null,
                userDetails == null ?
                        List.of() : userDetails.getAuthorities()
        );

        authentication.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }

}
