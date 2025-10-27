package NBank.user_service.controller;

import NBank.user_service.dto.addressDTOs.AddAddressRequest;
import NBank.user_service.dto.addressDTOs.UserAddressResponse;
import NBank.user_service.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/me/addresses")
public class AddressController {
    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<UserAddressResponse> addAddress(
            @RequestHeader("X-User-id") UUID id, // Gateway после проверки токена в заголовок добавит id юзера
            @RequestBody AddAddressRequest request
            ) {
        return ResponseEntity.ok(addressService.addAddress(id, request));
    }

    @GetMapping
    public ResponseEntity<UserAddressResponse> getAddress(
            @RequestHeader("X-User-id") UUID id
    ) {
        return ResponseEntity.ok(addressService.getAddress(id));
    }

    @PatchMapping("/{addressId}")
    public ResponseEntity<UserAddressResponse> updateAddress(
            @RequestHeader("X-User-id") UUID userId,
            @PathVariable UUID addressId,
            @RequestBody Map<String, Object> newAddress
    ) {
        return ResponseEntity.ok(addressService.updateAddress(userId, addressId, newAddress));
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<?> deleteAddress(
            @PathVariable UUID addressId
    ) {
        return ResponseEntity.ok(addressService.deleteAddress(addressId));
    }
}
