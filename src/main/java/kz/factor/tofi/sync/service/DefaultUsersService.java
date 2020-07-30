package kz.factor.tofi.sync.service;

import kz.factor.tofi.sync.converters.UsersConverter;
import kz.factor.tofi.sync.dto.UsersDto;
import kz.factor.tofi.sync.entity.Users;
import kz.factor.tofi.sync.exception.ValidationException;
import kz.factor.tofi.sync.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@AllArgsConstructor
@Service
public class DefaultUsersService implements UsersService {
    private final UsersRepository usersRepository;
    private final UsersConverter usersConverter;

    private void validateUserDto(UsersDto usersDto) throws ValidationException {
        if (isNull(usersDto))
            throw new ValidationException("Object user is null");
        if (isNull(usersDto.getLogin()) || usersDto.getLogin().isEmpty())
            throw new ValidationException("Login is empty");
    }

    @Override
    public UsersDto saveUser(UsersDto usersDto) throws ValidationException {
        validateUserDto(usersDto);
        Users savedUser = usersRepository.save(usersConverter.fromUserDtoToUser(usersDto));
        return usersConverter.fromUserToUserDto(savedUser);
    }

    @Override
    public void deleteUser(Integer userId) {
        usersRepository.deleteById(userId);
    }

    @Override
    public UsersDto findByLogin(String login) {
        Users users = usersRepository.findByLogin(login);
        if (users != null)
            return usersConverter.fromUserToUserDto(users);
        return null;
    }

    @Override
    public UsersDto findByName(String name) {
        Users users = usersRepository.findByName(name);
        if (users != null)
            return usersConverter.fromUserToUserDto(users);
        return null;
    }

    @Override
    public List<UsersDto> findAll() {
        return usersRepository.findAll()
                .stream()
                .map(usersConverter::fromUserToUserDto)
                .collect(Collectors.toList());
    }
}
