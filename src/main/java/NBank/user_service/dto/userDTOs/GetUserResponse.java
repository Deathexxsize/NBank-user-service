package NBank.user_service.dto.userDTOs;

import NBank.user_service.enums.Role;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public record GetUserResponse(
        UUID id,
        String firstName,
        String lastName,
        String email,
        Long phoneNumber,
        Date dateOfBirth,
        Role role,
        Instant createdAt,
        Instant updatedAt
) {
}
