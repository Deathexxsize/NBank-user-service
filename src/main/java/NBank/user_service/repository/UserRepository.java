package NBank.user_service.repository;

import NBank.user_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> getUserById(UUID id);
    Optional<User> getUserByFirstNameAndLastName(String firstName, String lastName);
}
