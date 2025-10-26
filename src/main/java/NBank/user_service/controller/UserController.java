package NBank.user_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    @GetMapping("/me")
    public ResponseEntity<?> me() {
        return null;
    }

    @PatchMapping("/me")
    public ResponseEntity<?> updateMyData() {
        return null;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser() {
        return null;
    }

    @PostMapping("/prfile") // забыл зачем этот эндпоинт
    public ResponseEntity<?> profile() {
        return null;
    }
}
