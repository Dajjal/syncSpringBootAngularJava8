package kz.factor.tofi.sync.service;

import kz.factor.tofi.sync.dto.UsersDto;
import kz.factor.tofi.sync.exception.ValidationException;

import java.util.List;

public interface UsersService {

    UsersDto saveUser(UsersDto usersDto) throws ValidationException;

    void deleteUser(Integer userId);

    UsersDto findByLogin(String login);
    UsersDto findByName(String login);

    List<UsersDto> findAll();

}
