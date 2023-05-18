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
     *
     * @param uuid  user id
     * @return one user
     */
    User findById(UUID uuid);

    /**
     *
     * @param pageable - page parameters
     * @return page of users
     */
    Page<User> findAllPageable(Pageable pageable);

    /**
     * @param user user provided for saving in db
     * @return
     */
    User createUser(@Valid UserCreateDto user);

    /**
     * @param uuid       user id
     * @param userDto    dto, provided with fields needed to update
     * @return
     */
    User updateByUuid(UUID uuid, @Valid UserCreateDto userDto);

    /**
     *
     * @param nick the username identifying the user whose data is required.
     * @return  fully populated user record (never null)
     */
    UserDetails loadUserByUsername(String nick);
}
