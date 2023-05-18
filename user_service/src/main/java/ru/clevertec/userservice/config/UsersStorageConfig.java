package ru.clevertec.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.clevertec.userservice.repository.api.UserRepository;
import ru.clevertec.userservice.service.impl.UserServiceImpl;
import ru.clevertec.userservice.service.mappers.api.UserMapper;


@Configuration
public class UsersStorageConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserMapper userMapper, UserRepository userRepository) {

        return new UserServiceImpl(userRepository, userMapper);
    }
}
