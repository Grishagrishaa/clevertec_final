package ru.clevertec.userservice.unit.controller;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.clevertec.userservice.controller.UserController;
import ru.clevertec.userservice.dto.JwtResponse;
import ru.clevertec.userservice.dto.request.LoginDto;
import ru.clevertec.userservice.dto.request.SignDto;
import ru.clevertec.userservice.dto.request.UserCreateDto;
import ru.clevertec.userservice.repository.entity.User;
import ru.clevertec.userservice.security.UserDetailsUser;
import ru.clevertec.userservice.security.utils.JwtTokenUtil;
import ru.clevertec.userservice.service.UserService;
import ru.clevertec.userservice.service.mappers.api.UserMapper;
import ru.clevertec.userservice.testUtils.builder.impl.UserTestBuilder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.springframework.http.HttpStatus.CREATED;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @InjectMocks
    private UserController controller;
    @Mock
    private UserService service;
    @Spy
    private UserMapper mapper = Mappers.getMapper(UserMapper.class);
    @Mock
    private PasswordEncoder encoder;


    @Test
    @SneakyThrows
    void createShouldReturnCorrectUser() {
        User user = UserTestBuilder.defaultValues().build();
        UserCreateDto createDto = UserTestBuilder.toCreateDto(user);

        doReturn(user)
                .when(service).createUser(createDto);

        ResponseEntity<User> expected = ResponseEntity.status(CREATED).body(user);
        ResponseEntity<User> actual = controller.create(createDto);

        verify(service).createUser(createDto);
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void findAllPageableShouldReturnCorrectPage() {
        PageImpl<User> page = new PageImpl<>( List.of( UserTestBuilder.defaultValues().build()));

        doReturn(page)
                .when(service).findAllPageable(Pageable.unpaged());

        ResponseEntity<PageImpl<User>> expected = ResponseEntity.ok().body(page);
        ResponseEntity<Page<User>> actual = controller.findAllPageable(Pageable.unpaged());

        verify(service).findAllPageable(Pageable.unpaged());
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void findByIdShouldReturnCorrectUser() {
        User user = UserTestBuilder.defaultValues().build();

        doReturn(user)
                .when(service).findById(user.getUuid());

        ResponseEntity<User> expected = ResponseEntity.ok().body(user);
        ResponseEntity<User> actual = controller.findById(user.getUuid());

        verify(service).findById(user.getUuid());
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void updateByIdShouldReturnCorrectUser() {
        User user = UserTestBuilder.defaultValues().build();
        UserCreateDto updateDto = UserTestBuilder.toCreateDto(user);

        doReturn(user)
                .when(service).updateByUuid(user.getUuid(), updateDto);

        ResponseEntity<User> expected = ResponseEntity.ok().body(user);
        ResponseEntity<User> actual = controller.updateByUuid(user.getUuid(), updateDto);

        verify(service).updateByUuid(user.getUuid(), updateDto);
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void registrationShouldReturnCorrectRespEntityAndCallService() {
        User user = UserTestBuilder.defaultValues().build();

        SignDto signDto = UserTestBuilder.toSignDto(user);
        UserCreateDto createDto = UserTestBuilder.toCreateDto(user);

        doReturn(createDto)
                .when(mapper).signDtoToUserCreateDto(signDto);
        doReturn(user)
                .when(service).createUser(createDto);

        ResponseEntity<?> expected = ResponseEntity.status(CREATED).build();
        ResponseEntity<?> actual = controller.registration(signDto);

        assertThat(expected).isEqualTo(actual);
        verify(service).createUser(createDto);
    }

    @Test
    void loginShouldCallService() {
        User user = UserTestBuilder.defaultValues().build();

        LoginDto loginDto = UserTestBuilder.toLoginDto(user);
        UserDetailsUser details = UserTestBuilder.toUserDetailsUser(user);

        doReturn(details)
                .when(service).loadUserByUsername(details.getUsername());
        doReturn(true)
                .when(encoder).matches(loginDto.getPassword(), details.getPassword());

        JwtResponse expectedJwt = JwtResponse.builder()
                .username(details.getUsername())
                .authorities(details.getAuthorities())
                .activated(details.isEnabled())
                .jwtToken(JwtTokenUtil.generateAccessToken(details.getUsername()))
                .build();

        ResponseEntity<JwtResponse> actual = controller.login(loginDto);

        assertThat(JwtTokenUtil.validate(actual.getBody().getJwtToken())).isTrue();
        verify(service).loadUserByUsername(details.getUsername());
    }
}