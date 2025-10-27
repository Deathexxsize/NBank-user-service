package NBank.user_service.service;

import NBank.user_service.dto.addressDTOs.AddAddressRequest;
import NBank.user_service.dto.addressDTOs.UserAddressResponse;

import java.util.Map;
import java.util.UUID;

public interface AddressService {
    public UserAddressResponse addAddress(UUID id ,AddAddressRequest request);
    public UserAddressResponse getAddress(UUID id);
    public UserAddressResponse updateAddress(UUID userId, UUID addressId, Map<String, Object> newAddress);
    public String deleteAddress(UUID id);
}
