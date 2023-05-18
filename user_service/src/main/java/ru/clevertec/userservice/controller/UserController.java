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

@RestController
@RequestMapping("${app.users.url}")
@RequiredArgsConstructor
public class UserController {
    private final UserMapper mapper;
    private final UserService service;
    private final PasswordEncoder encoder;


    @RequestMapping(method = POST)
    public ResponseEntity<User> create(@RequestBody UserCreateDto dto){
        return ResponseEntity.status(CREATED).body(service.createUser(dto));
    }

    @RequestMapping(method = GET)
    public ResponseEntity<Page<User>> findAllPageable(@PageableDefault Pageable pageable){
        return ResponseEntity.status(OK).body(service.findAllPageable(pageable));
    }

    @RequestMapping(method = GET, path = "/{uuid}")
    public ResponseEntity<User> findById(@PathVariable UUID uuid){
        return ResponseEntity.status(OK).body(service.findById(uuid));
    }

    @RequestMapping(method = PUT, path = "/{uuid}")
    public ResponseEntity<User> updateByUuid(@PathVariable UUID uuid, @RequestBody UserCreateDto userDto){
        return ResponseEntity.status(OK).body(service.updateByUuid(uuid, userDto));
    }



    @RequestMapping(method = POST, path = "/registration")
    public ResponseEntity<?> registration(@RequestBody SignDto dto){
        service.createUser(mapper.signDtoToUserCreateDto(dto));
        return ResponseEntity.status(CREATED).build();
    }

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

    @RequestMapping(method = GET, path = "/me")
    public ResponseEntity<UserDetails> getUserDetails(@AuthenticationPrincipal UserDetails userDetails){
        return ResponseEntity.status(OK).body(userDetails);
    }

}
