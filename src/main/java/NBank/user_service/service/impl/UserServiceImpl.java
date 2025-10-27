package NBank.user_service.service.impl;

import NBank.user_service.dto.GetUserRequest;
import NBank.user_service.dto.GetUserResponse;
import NBank.user_service.dto.MeResponse;
import NBank.user_service.model.User;
import NBank.user_service.repository.UserRepository;
import NBank.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepo;

    @Override
    public MeResponse me(UUID id) {
        User user = userRepo.getUserById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        MeResponse response = new MeResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getDateOfBirth()
        );
        return response;
    }

    @Override
    public String updateMyData(UUID id, Map<String, Object> edits) {
        User user = userRepo.getUserById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        edits.forEach((key, value) -> {
            switch (key) {
                case "firstName" -> user.setFirstName(String.valueOf(value));
                case "lastName" -> user.setLastName(String.valueOf(value));
                case "email" -> user.setEmail(String.valueOf(value));
                case "phoneNumber" -> user.setPhoneNumber(Long.valueOf(String.valueOf(value)));
                case "dateOfBirth" -> user.setDateOfBirth(
                        Date.from(LocalDate.parse(String.valueOf(value))
                                .atStartOfDay(ZoneId.systemDefault())
                                .toInstant())
                );
                default -> throw new RuntimeException("Field " + key + " cannot be updated");
            }
        });
        user.setUpdatedAt(Instant.now());
        userRepo.save(user);
        return "Your data updated successfully";
    }


    @Override
    public GetUserResponse getUSer(GetUserRequest request) {
        User user = userRepo.getUserByFirstNameAndLastName(request.firstName(), request.lastName())
                .orElseThrow(() -> new RuntimeException("User not found"));
        return new GetUserResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getDateOfBirth(),
                user.getRole(),
                user.getCreatedAt(),
                user.getUpdatedAt());
    }

    // хз зачем этот метод нужен
    @Override
    public void profile() {

    }
}
