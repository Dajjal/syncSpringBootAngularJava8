package kz.factor.tofi.sync.model.users;

import kz.factor.tofi.sync.model.users.UsersDto;
import kz.factor.tofi.sync.model.users.AppUsers;
import org.springframework.stereotype.Component;

@Component
public class UsersConverter {
    public AppUsers fromUserDtoToUser(UsersDto usersDto) {
        AppUsers users = new AppUsers();
        users.setId(usersDto.getId());
        users.setEmail(usersDto.getEmail());
        users.setLogin(usersDto.getLogin());
        users.setName(usersDto.getName());
        users.setPassword(usersDto.getPassword());
        return users;
    }

    public UsersDto fromUserToUserDto(AppUsers users) {
        return UsersDto.builder()
                .id(users.getId())
                .email(users.getEmail())
                .login(users.getLogin())
                .name(users.getName())
                .build();
    }
}
