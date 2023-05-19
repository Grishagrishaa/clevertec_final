package ru.clevertec.clevertec_final.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface RestService {

    /**
     * Load user details based on the provided header value.
     *
     * @param headerValue The value extracted from the request header.
     * @return The UserDetails object representing the loaded user details.
     */
    UserDetails loadUser(String headerValue);

}
