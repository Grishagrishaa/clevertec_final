package ru.clevertec.userservice.unit.service.mappers.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.clevertec.userservice.dto.request.UserCreateDto;
import ru.clevertec.userservice.repository.entity.User;
import ru.clevertec.userservice.repository.entity.enums.ERole;
import ru.clevertec.userservice.repository.entity.enums.EStatus;
import ru.clevertec.userservice.security.UserDetailsUser;
import ru.clevertec.userservice.service.mappers.api.UserMapper;
import ru.clevertec.userservice.testUtils.builder.impl.UserTestBuilder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


@ExtendWith(MockitoExtension.class)
class UserMapperTest {

    @Spy
    private PasswordEncoder encoder;

    @InjectMocks
    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Test
    void userCreateDtoToUserShouldReturnCorrectUser() {
        User expected = UserTestBuilder.defaultValues().build();
        User actual = userMapper.userCreateDtoToUser(UserTestBuilder.toCreateDto(expected));

        assertAll(
                () -> assertThat(actual.getMail()).isEqualTo(expected.getMail()),
                () -> assertThat(actual.getNick()).isEqualTo(expected.getNick()),
                () -> assertThat(actual.getStatus()).isEqualTo(expected.getStatus()),
                () -> assertThat(actual.getRole()).isEqualTo(expected.getRole())
        );
    }

    @Test
    void signDtoToUserCreateDtoShouldReturnCorrectUserCreateDto() {
        User user = UserTestBuilder.defaultValues().build();

        UserCreateDto expected = UserTestBuilder.toCreateDto(user);
        UserCreateDto actual = userMapper.signDtoToUserCreateDto(UserTestBuilder.toSignDto(user));

        assertAll(
                () -> assertThat(actual.getMail()).isEqualTo(expected.getMail()),
                () -> assertThat(actual.getNick()).isEqualTo(expected.getNick()),
                () -> assertThat(actual.getStatus()).isEqualTo(EStatus.ACTIVATED.name()),
                () -> assertThat(actual.getRole()).isEqualTo(ERole.USER.name())
        );
    }

    @Test
    void userToUserDetails() {
        User user = UserTestBuilder.defaultValues().build();
        UserDetailsUser expected = UserTestBuilder.toUserDetailsUser(user);

        UserDetailsUser actual = userMapper.userToUserDetailsUser(user);

        assertAll(
                () -> assertThat(actual.getMail()).isEqualTo(expected.getMail()),
                () -> assertThat(actual.getUsername()).isEqualTo(expected.getUsername()),
                () -> assertThat(actual.getPassword()).isEqualTo(expected.getPassword()),
                () -> assertThat(actual.getAccountNonExpired()).isTrue(),
                () -> assertThat(actual.getEnabled()).isTrue()
        );
    }

    @Test
    void update() {
        User user = UserTestBuilder.defaultValues().build();

        UserCreateDto updateDto = UserTestBuilder.toCreateDto(UserTestBuilder.randomValues().build());

        userMapper.update(user, updateDto);

        assertAll(
                () -> assertThat(user.getMail()).isEqualTo(updateDto.getMail()),
                () -> assertThat(user.getNick()).isEqualTo(updateDto.getNick()),
                () -> assertThat(user.getStatus().name()).isEqualTo(updateDto.getStatus()),
                () -> assertThat(user.getRole().name()).isEqualTo(updateDto.getRole())
        );
    }

}