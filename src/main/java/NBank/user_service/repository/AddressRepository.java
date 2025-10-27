package NBank.user_service.repository;

import NBank.user_service.model.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<UserAddress, UUID> {
    @Query(
            "select ua from UserAddress ua where ua.user.id = :id"
    )
    Optional<UserAddress> getUserAddressByUserid(@Param("id") UUID id);

    Optional<UserAddress> getUserAddressById(UUID id);
}
