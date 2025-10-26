package NBank.user_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/me/addresses")
public class AddressController {

    @GetMapping
    public ResponseEntity<?> getAddress() {
        return null;
    }

    @PostMapping
    public ResponseEntity<?> addAddress() {
        return null;
    }

    @PatchMapping("/{addressId}")
    public ResponseEntity<?> updateAddress() {
        return null;
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<?> deleteAddress() {
        return null;
    }
}
