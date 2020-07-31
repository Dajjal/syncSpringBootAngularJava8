package kz.factor.tofi.sync.service.users;

import kz.factor.tofi.sync.model.users.UsersConverter;
import kz.factor.tofi.sync.model.users.UsersDto;
import kz.factor.tofi.sync.model.users.AppUsers;
import kz.factor.tofi.sync.exception.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@AllArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {
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
        AppUsers savedUser = usersRepository.save(usersConverter.fromUserDtoToUser(usersDto));
        return usersConverter.fromUserToUserDto(savedUser);
    }

    @Override
    public void deleteUser(UUID userId) {
        usersRepository.deleteById(userId);
    }

    @Override
    public UsersDto findByLogin(String login) {
        AppUsers users = usersRepository.findByLogin(login);
        if (users != null)
            return usersConverter.fromUserToUserDto(users);
        return null;
    }

    @Override
    public UsersDto findByName(String name) {
        AppUsers users = usersRepository.findByName(name);
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
