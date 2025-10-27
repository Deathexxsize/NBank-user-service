package NBank.user_service.controller;

import NBank.user_service.dto.userDTOs.GetUserRequest;
import NBank.user_service.dto.userDTOs.GetUserResponse;
import NBank.user_service.dto.userDTOs.MeResponse;
import NBank.user_service.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserServiceImpl userService;
    // User
    @GetMapping("/me")
    public ResponseEntity<MeResponse> me(
            @RequestHeader("X-User-id")UUID id // Gateway после проверки токена в заголовок добавит id юзера
            ) {
        return ResponseEntity.ok(userService.me(id));
    }

    // User, admin
    @PatchMapping("/me")
    public ResponseEntity<String> updateMyData(
            @RequestHeader("X-User-id")UUID id, // Gateway после проверки токена в заголовок добавит id юзера
            @RequestBody Map<String, Object> edits
    ) {
        return ResponseEntity.ok(userService.updateMyData(id, edits));
    }

    // Admin
    @GetMapping("/getUser")
    public ResponseEntity<GetUserResponse> getUser(
            @RequestBody GetUserRequest request
            ) {
        return ResponseEntity.ok(userService.getUSer(request));
    }

    @PostMapping("/prfile") // забыл зачем этот эндпоинт
    public ResponseEntity<?> profile() {
        return null;
    }
}
