package ru.clevertec.userservice.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.clevertec.userservice.repository.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByNick(String nick);
}
