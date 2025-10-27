package NBank.user_service.service;

import NBank.user_service.dto.GetUserRequest;
import NBank.user_service.dto.MeResponse;
import NBank.user_service.dto.GetUserResponse;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.UUID;

public interface UserService {
    // Метод для получения профиля
    public MeResponse me(UUID id);
    // Обновления данных о себе
    public String updateMyData(UUID id, Map<String, Object> edits);
    // получить юзера
    public GetUserResponse getUSer(GetUserRequest request);
    // получить профиль, хз зачем она нужна (забыл)
    public void profile();
}
