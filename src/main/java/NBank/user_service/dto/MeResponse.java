package NBank.user_service.dto;

import java.util.Date;
import java.util.UUID;

public record MeResponse(
   UUID id,
   String firstName,
   String lastName,
   String email,
   Long phoneNumber,
   Date dateOfBirth
) {}
