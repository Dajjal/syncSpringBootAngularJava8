package kz.factor.tofi.sync.service.users;

import kz.factor.tofi.sync.model.kendo.DataSourceRequest;
import kz.factor.tofi.sync.model.kendo.DataSourceResult;
import kz.factor.tofi.sync.model.roles.AppRoles;
import kz.factor.tofi.sync.model.users.UsersConverter;
import kz.factor.tofi.sync.model.users.UsersDto;
import kz.factor.tofi.sync.model.users.AppUsers;
import kz.factor.tofi.sync.exception.ValidationException;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@AllArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {

    @PersistenceContext
    private EntityManager entityManager;

    private final UsersRepository usersRepository;
    private final UsersConverter usersConverter;

    private void validateUserDto(UsersDto usersDto) throws ValidationException {
        if (isNull(usersDto))
            throw new ValidationException("Object user is null");
        if (isNull(usersDto.getLogin()) || usersDto.getLogin().isEmpty())
            throw new ValidationException("Login is empty");
        if (isNull(usersDto.getEmail()) || usersDto.getEmail().isEmpty())
            throw new ValidationException("Email is empty");
        if (isNull(usersDto.getPassword()) || usersDto.getPassword().isEmpty())
            throw new ValidationException("Password is empty");
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
    public List<UsersDto> findAll() {
        return usersRepository.findAll()
                .stream()
                .map(usersConverter::fromUserToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public DataSourceResult get(DataSourceRequest request) {
        Session session = entityManager.unwrap(Session.class);
        DataSourceResult result =  request.toDataSourceResult(session, AppUsers.class);
        Set<AppUsers> users = new HashSet<AppUsers>((Collection<? extends AppUsers>) result.getData());
        result.setData(users.stream().collect(Collectors.toList()));
        return result;
    }
}
