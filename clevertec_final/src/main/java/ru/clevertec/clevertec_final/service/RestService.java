package ru.clevertec.clevertec_final.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface RestService {

    UserDetails loadUser(String headerValue);

}
