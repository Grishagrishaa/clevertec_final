package ru.clevertec.clevertec_final.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import ru.clevertec.clevertec_final.security.UserDetailsUser;
import ru.clevertec.clevertec_final.service.RestService;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

/**
 * Implementation of the RestService interface.
 */
@Service
@RequiredArgsConstructor
public class RestServiceImpl implements RestService {
    private final WebClient webClient;

    /**
     * Loads the user details by making a request to a remote service using WebClient.
     *
     * @param headerValue the header value to be included in the request
     * @return the UserDetailsUser object representing the user details
     * @throws UsernameNotFoundException if the user is not found or the token is invalid
     */
    @Override
    public UserDetails loadUser(String headerValue) throws UsernameNotFoundException {
        UserDetailsUser user = null;
        try {
            user = webClient
                    .get()
                    .header(AUTHORIZATION, headerValue)
                    .retrieve().bodyToMono(UserDetailsUser.class).block();
        } catch (WebClientResponseException e) {
            throw new UsernameNotFoundException("USER NOT FOUND | INVALID TOKEN");
        }
        return user;
    }
}

