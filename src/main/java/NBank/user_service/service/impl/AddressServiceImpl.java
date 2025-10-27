package NBank.user_service.service.impl;

import NBank.user_service.dto.addressDTOs.AddAddressRequest;
import NBank.user_service.dto.addressDTOs.UserAddressResponse;
import NBank.user_service.model.User;
import NBank.user_service.model.UserAddress;
import NBank.user_service.repository.AddressRepository;
import NBank.user_service.repository.UserRepository;
import NBank.user_service.service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepo;
    private final UserRepository userRepo;
    @Override
    public UserAddressResponse addAddress(UUID id, AddAddressRequest request) {
        User user = userRepo.getUserById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        UserAddress address = new UserAddress();
        address.setUser(user);
        address.setRegion(request.region());
        address.setCity(request.city());
        address.setStreet(request.street());
        addressRepo.save(address);
        return new UserAddressResponse(
                address.getId(),
                user.getId(),
                address.getRegion(),
                address.getCity(),
                address.getStreet()
        );
    }

    @Override
    public UserAddressResponse getAddress(UUID id) {
        UserAddress address = addressRepo.getUserAddressByUserid(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));
        return new UserAddressResponse(
                address.getId(),
                address.getUser().getId(),
                address.getRegion(),
                address.getCity(),
                address.getStreet()
        );
    }

    @Override
    public UserAddressResponse updateAddress(UUID userId, UUID addressId, Map<String, Object> newAddress) {
        UserAddress address = addressRepo.getUserAddressById(addressId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        newAddress.forEach((key, value) -> {
                    switch (key) {
                        case "region" -> address.setRegion(String.valueOf(value));
                        case "city" -> address.setCity(String.valueOf(value));
                        case "street" -> address.setCity(String.valueOf(value));
                        default -> throw new RuntimeException("Field " + key + " cannot be updated");
                    }
                });
        addressRepo.save(address);
        return new UserAddressResponse(
                address.getId(),
                address.getUser().getId(),
                address.getRegion(),
                address.getCity(),
                address.getStreet()
        );
    }

    @Override
    public String deleteAddress(UUID id) {
        userRepo.deleteById(id);
        return "Address with id " + id + " is deleted successfully";
    }
}
