package kz.factor.tofi.sync.converters;

import kz.factor.tofi.sync.dto.UsersDto;
import kz.factor.tofi.sync.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class UsersConverter {
    public Users fromUserDtoToUser(UsersDto usersDto) {
        Users users = new Users();
        users.setId(usersDto.getId());
        users.setEmail(usersDto.getEmail());
        users.setLogin(usersDto.getLogin());
        users.setName(usersDto.getName());
        return users;
    }

    public UsersDto fromUserToUserDto(Users users) {
        return UsersDto.builder()
                .id(users.getId())
                .email(users.getEmail())
                .login(users.getLogin())
                .name(users.getName())
                .build();
    }
}
