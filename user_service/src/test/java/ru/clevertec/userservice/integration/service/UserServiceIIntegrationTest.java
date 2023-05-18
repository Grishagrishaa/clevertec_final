package ru.clevertec.userservice.integration.service;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import ru.clevertec.userservice.dto.request.UserCreateDto;
import ru.clevertec.userservice.integration.BaseIntegrationTest;
import ru.clevertec.userservice.repository.entity.User;
import ru.clevertec.userservice.service.UserService;
import ru.clevertec.userservice.testUtils.builder.impl.UserTestBuilder;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class UserServiceIIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private UserService service;

    @Test
    void createUserShouldReturnUserWithUuid() {
        User user = UserTestBuilder.defaultValues().build();

        User actual = service.createUser(UserTestBuilder.toCreateDto(user));

        assertThat(actual).isNotNull();
    }

    @Test
    void findAllByPageableShouldReturnExpectedCountOfEntities() {
        Page<User> allByPageable = service.findAllPageable(PageRequest.of(0, COUNT_OF_ENTITIES));

        assertThat(allByPageable.getTotalElements()).isEqualTo(COUNT_OF_ENTITIES);
    }

    @Test
    void findByIdShouldReturnUser() {
        User actual = service.findById(LAST_ENTITY_UUID);

        assertThat(actual).isNotNull();
        assertThat(actual.getUuid()).isEqualTo(LAST_ENTITY_UUID);
    }

    @Test
    void findByIdShouldThrowExceptionIfIdInvalid() {
        assertThatThrownBy(() -> service.findById(UUID.randomUUID()))
                .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void updateByUuidShouldReturnUpdatedUser() {

        UserCreateDto toUpdate = UserTestBuilder.defaultValues().buildCreateDto();
        User notUpdated = service.findById(LAST_ENTITY_UUID);

        User updated = service.updateByUuid(LAST_ENTITY_UUID, toUpdate);

        assertAll(
                () -> assertThat(notUpdated).isNotEqualTo(toUpdate),

                () -> assertThat(updated.getNick()).isEqualTo(toUpdate.getNick()),
                () -> assertThat(updated.getMail()).isEqualTo(toUpdate.getMail()),
                () -> assertThat(updated.getRole().name()).isEqualTo(toUpdate.getRole()),
                () -> assertThat(updated.getStatus().name()).isEqualTo(toUpdate.getStatus())
        );
    }

    @Test
    void loadUserByUsernameShouldReturnUser() {
        UserDetails actual = service.loadUserByUsername(LAST_ENTITY_NICK);

        assertThat(actual).isNotNull();
        assertThat(actual.getUsername()).isEqualTo(LAST_ENTITY_NICK);
    }
}