package NBank.user_service.dto.addressDTOs;

import java.util.UUID;

public record UserAddressResponse(
    UUID addressId,
    UUID userId,
    String region,
    String city,
    String street
) {
}
