package ru.clevertec.userservice.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.clevertec.userservice.dto.JwtResponse;
import ru.clevertec.userservice.dto.request.LoginDto;
import ru.clevertec.userservice.dto.request.SignDto;
import ru.clevertec.userservice.dto.request.UserCreateDto;
import ru.clevertec.userservice.repository.entity.User;
import ru.clevertec.userservice.security.utils.JwtTokenUtil;
import ru.clevertec.userservice.service.UserService;
import ru.clevertec.userservice.service.mappers.api.UserMapper;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 * Controller class for handling user-related requests.
 */
@RestController
@RequestMapping("${app.users.url}")
@RequiredArgsConstructor
public class UserController {
    private final UserMapper mapper;
    private final UserService service;
    private final PasswordEncoder encoder;

    /**
     * Creates a new user.
     *
     * @param dto the UserCreateDto object containing user data
     * @return ResponseEntity with the created User object
     */
    @RequestMapping(method = POST)
    public ResponseEntity<User> create(@RequestBody UserCreateDto dto){
        return ResponseEntity.status(CREATED).body(service.createUser(dto));
    }

    /**
     * Retrieves all users in a pageable format.
     *
     * @param pageable the Pageable object for pagination and sorting
     * @return ResponseEntity with the Page of User objects
     */
    @RequestMapping(method = GET)
    public ResponseEntity<Page<User>> findAllPageable(@PageableDefault Pageable pageable){
        return ResponseEntity.status(OK).body(service.findAllPageable(pageable));
    }

    /**
     * Retrieves a user by UUID.
     *
     * @param uuid the UUID of the user to retrieve
     * @return ResponseEntity with the retrieved User object
     */
    @RequestMapping(method = GET, path = "/{uuid}")
    public ResponseEntity<User> findById(@PathVariable UUID uuid){
        return ResponseEntity.status(OK).body(service.findById(uuid));
    }

    /**
     * Updates a user by UUID.
     *
     * @param uuid     the UUID of the user to update
     * @param userDto  the UserCreateDto object containing updated user data
     * @return ResponseEntity with the updated User object
     */
    @RequestMapping(method = PUT, path = "/{uuid}")
    public ResponseEntity<User> updateByUuid(@PathVariable UUID uuid, @RequestBody UserCreateDto userDto){
        return ResponseEntity.status(OK).body(service.updateByUuid(uuid, userDto));
    }



    /**
     * Registers a new user.
     *
     * @param dto the SignDto object containing registration data
     * @return ResponseEntity indicating a successful registration
     */
    @RequestMapping(method = POST, path = "/registration")
    public ResponseEntity<?> registration(@RequestBody SignDto dto){
        service.createUser(mapper.signDtoToUserCreateDto(dto));
        return ResponseEntity.status(CREATED).build();
    }

    /**
     * Authenticates a user and generates a JWT response.
     *
     * @param loginDto the LoginDto object containing login credentials
     * @return ResponseEntity with the JwtResponse object
     * @throws IllegalArgumentException if the credentials are incorrect
     */
    @RequestMapping(method = POST, path = "/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginDto loginDto){
        UserDetails details = service.loadUserByUsername(loginDto.getNick());

        if(!encoder.matches(loginDto.getPassword(), details.getPassword())){
            throw new IllegalArgumentException("Incorrect credentials");
        }

        return ResponseEntity.accepted().body(JwtResponse.builder()
                                        .username(details.getUsername())
                                        .authorities(details.getAuthorities())
                                        .activated(details.isEnabled())
                                        .jwtToken(JwtTokenUtil.generateAccessToken(details.getUsername()))
                                        .build());
    }

    /**
     * Retrieves details of the authenticated user.
     *
     * @param userDetails the UserDetails object representing the authenticated user
     * @return ResponseEntity with the UserDetails object
     */
    @RequestMapping(method = GET, path = "/me")
    public ResponseEntity<UserDetails> getUserDetails(@AuthenticationPrincipal UserDetails userDetails){
        return ResponseEntity.status(OK).body(userDetails);
    }

}
