package ru.clevertec.userservice.service;

import org.springframework.validation.annotation.Validated;
import ru.clevertec.userservice.dto.request.UserCreateDto;
import ru.clevertec.userservice.repository.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import jakarta.validation.Valid;

import java.util.UUID;

@Validated
public interface UserService extends UserDetailsService {

    /**
     * Retrieves a user by their UUID.
     *
     * @param uuid the UUID of the user
     * @return the user with the specified UUID
     */
    User findById(UUID uuid);

    /**
     * Retrieves a pageable list of users.
     *
     * @param pageable the pageable parameters
     * @return a page of users
     */
    Page<User> findAllPageable(Pageable pageable);

    /**
     * Creates a new user.
     *
     * @param user the user to be created
     * @return the created user
     */
    User createUser(@Valid UserCreateDto user);

    /**
     * Updates a user identified by their UUID.
     *
     * @param uuid     the UUID of the user to be updated
     * @param userDto  the DTO containing the fields to be updated
     * @return the updated user
     */
    User updateByUuid(UUID uuid, @Valid UserCreateDto userDto);

    /**
     * Loads a user by their username.
     *
     * @param nick the username identifying the user
     * @return the fully populated user record (never null)
     */
    UserDetails loadUserByUsername(String nick);
}
