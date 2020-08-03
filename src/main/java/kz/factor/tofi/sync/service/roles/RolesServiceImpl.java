package kz.factor.tofi.sync.service.roles;

import kz.factor.tofi.sync.exception.ValidationException;
import kz.factor.tofi.sync.model.roles.AppRoles;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.Objects.isNull;

@AllArgsConstructor
@Service
public class RolesServiceImpl implements RolesService {

    private final RolesRepository rolesRepository;

    private void validateAppRoles(AppRoles appRoles) throws ValidationException {
        if (isNull(appRoles))
            throw new ValidationException("Object role is null");
        if (isNull(appRoles.getName()) || appRoles.getName().isEmpty())
            throw new ValidationException("Role name is empty");
    }

    @Override
    public AppRoles saveRole(AppRoles appRoles) throws ValidationException {
        validateAppRoles(appRoles);
        return rolesRepository.save(appRoles);
    }

    @Override
    public void deleteRole(UUID roleId) {
        rolesRepository.deleteById(roleId);
    }

    @Override
    public AppRoles findByName(String role) {
        return rolesRepository.findByName(role);
    }

    @Override
    public List<AppRoles> findAll() {
        return new ArrayList<>(rolesRepository.findAll());
    }
}
