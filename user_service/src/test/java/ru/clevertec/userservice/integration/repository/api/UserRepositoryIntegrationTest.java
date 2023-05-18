package ru.clevertec.userservice.integration.repository.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.clevertec.userservice.integration.BaseIntegrationTest;
import ru.clevertec.userservice.repository.api.UserRepository;
import ru.clevertec.userservice.repository.entity.User;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

//@RequiredArgsConstructor
class UserRepositoryIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private UserRepository repository;

    @Test
    void findByNickShouldReturnCorrectUser(){
        Optional<User> actual = repository.findByNick(LAST_ENTITY_NICK);

        assertThat(actual).isNotEmpty();
        assertThat(actual.get().getNick()).isEqualTo(LAST_ENTITY_NICK);
    }

    @Test
    void findByNickShouldReturnEmptyOptionalIfNickIncorrect(){
        Optional<User> actual = repository.findByNick("INCORRECT_NICK");

        assertThat(actual).isEmpty();
    }
}