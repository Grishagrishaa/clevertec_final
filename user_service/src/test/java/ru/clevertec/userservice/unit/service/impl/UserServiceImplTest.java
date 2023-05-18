package ru.clevertec.userservice.unit.service.impl;

import jakarta.persistence.EntityNotFoundException;
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
import org.springframework.security.core.userdetails.UserDetails;
import ru.clevertec.userservice.dto.request.UserCreateDto;
import ru.clevertec.userservice.repository.api.UserRepository;
import ru.clevertec.userservice.repository.entity.User;
import ru.clevertec.userservice.service.impl.UserServiceImpl;
import ru.clevertec.userservice.service.mappers.api.UserMapper;
import ru.clevertec.userservice.testUtils.builder.impl.UserTestBuilder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    private static final UUID ID = UUID.randomUUID();

    @Mock
    private UserRepository repository;
    @Spy
    private UserMapper mapper = Mappers.getMapper(UserMapper.class);
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void loadUserByUsernameShouldReturnUserDetails() {
        User user = UserTestBuilder.defaultValues().build();

        doReturn(Optional.of(user))
                .when(repository).findByNick(user.getNick());

        UserDetails actual = userService.loadUserByUsername(user.getNick());

        assertAll(
                () -> assertThat(actual.getUsername()).isEqualTo(user.getNick()),
                () -> assertThat(actual.getPassword()).isEqualTo(user.getPassword()),
                () -> assertThat(actual.isCredentialsNonExpired()).isTrue(),
                () -> assertThat(actual.isEnabled()).isTrue()
        );
    }

    @Test
    void loadUserByUsernameShouldThrowExceptionIfNickIncorrect() {
        User user = UserTestBuilder.defaultValues().build();

        doReturn(Optional.empty())
                .when(repository).findByNick(user.getNick());

        assertThatThrownBy(() -> userService.loadUserByUsername(user.getNick()))
                .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void createUserShouldReturnCorrectUser() {
        User expected = UserTestBuilder.defaultValues().build();
        UserCreateDto createDto = UserTestBuilder.toCreateDto(expected);

        doReturn(expected)
                .when(repository).save(any());
        doReturn(expected)
                .when(mapper).userCreateDtoToUser(createDto);
        
        User actual = userService.createUser(createDto);

        assertThat(expected).isEqualTo(actual);
    }


    @Test
    void findByIdShouldReturnCorrectUser() {
        User expected = UserTestBuilder.defaultValues().build();

        doReturn(Optional.of(expected))
                .when(repository).findById(expected.getUuid());


        User actual = userService.findById(expected.getUuid());

        verify(repository).findById(expected.getUuid());
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void findByIdShouldEntityNotFoundException() {
        doReturn(Optional.empty())
                .when(repository).findById(ID);

        assertThatThrownBy(() -> userService.findById(ID))
                .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void findAllShouldReturnExpectedResult() {
        PageImpl<User> expected = new PageImpl<>(List.of( UserTestBuilder.defaultValues().build() ));

        doReturn(expected)
                .when(repository).findAll(Pageable.unpaged());

        Page<User> actual = userService.findAllPageable(Pageable.unpaged());

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void updateUser() {
        User user = UserTestBuilder.defaultValues().build();
        UserCreateDto updateDto = UserTestBuilder.toCreateDto(user);

        doReturn(Optional.of(user))
                .when(repository).findById(user.getUuid());
        doReturn(user)
                .when(repository).save(user);
        doNothing()
                .when(mapper).update(user, updateDto);

        User actual = userService.updateByUuid(user.getUuid(), updateDto);

        assertAll(
                () -> assertThat(actual.getMail()).isEqualTo(updateDto.getMail()),
                () -> assertThat(actual.getNick()).isEqualTo(updateDto.getNick()),
                () -> assertThat(actual.getStatus().name()).isEqualTo(updateDto.getStatus()),
                () -> assertThat(actual.getRole().name()).isEqualTo(updateDto.getRole())
        );
    }

}