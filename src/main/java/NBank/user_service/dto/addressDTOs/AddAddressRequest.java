package NBank.user_service.dto.addressDTOs;

public record AddAddressRequest(
    String region,
    String city,
    String street
) {
}
