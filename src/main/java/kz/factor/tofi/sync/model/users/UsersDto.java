package kz.factor.tofi.sync.model.users;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UsersDto {
    private UUID id;
    private String login;
    private String email;
    private String password;
}
