package kz.factor.tofi.sync.model.users;

import org.springframework.stereotype.Component;

@Component
public class UsersConverter {
    public AppUsers fromUserDtoToUser(UsersDto usersDto) {
        AppUsers users = new AppUsers();
        users.setId(usersDto.getId());
        users.setEmail(usersDto.getEmail());
        users.setLogin(usersDto.getLogin());
        users.setPassword(usersDto.getPassword());
        return users;
    }

    public UsersDto fromUserToUserDto(AppUsers users) {
        return UsersDto.builder()
                .id(users.getId())
                .email(users.getEmail())
                .login(users.getLogin())
                .build();
    }
}
