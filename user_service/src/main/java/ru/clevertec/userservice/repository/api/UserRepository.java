package ru.clevertec.userservice.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.clevertec.userservice.repository.entity.User;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for performing CRUD operations on the User entity.
 */
public interface UserRepository extends JpaRepository<User, UUID> {

    /**
     * Retrieves a user by their nick.
     *
     * @param nick the nick of the user
     * @return an optional containing the user, or an empty optional if not found
     */
    Optional<User> findByNick(String nick);
}
