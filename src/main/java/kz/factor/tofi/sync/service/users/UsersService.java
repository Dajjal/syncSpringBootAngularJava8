package kz.factor.tofi.sync.service.users;

import kz.factor.tofi.sync.model.kendo.DataSourceRequest;
import kz.factor.tofi.sync.model.kendo.DataSourceResult;
import kz.factor.tofi.sync.model.users.UsersDto;
import kz.factor.tofi.sync.exception.ValidationException;

import java.util.List;
import java.util.UUID;

public interface UsersService {

    UsersDto saveUser(UsersDto usersDto) throws ValidationException;

    void deleteUser(UUID userId);

    UsersDto findByLogin(String login);

    List<UsersDto> findAll();

    DataSourceResult get(DataSourceRequest request);
}
