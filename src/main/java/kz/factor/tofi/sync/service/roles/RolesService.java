package kz.factor.tofi.sync.service.roles;

import kz.factor.tofi.sync.exception.ValidationException;
import kz.factor.tofi.sync.model.roles.AppRoles;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RolesService {

    AppRoles saveRole(AppRoles appRoles) throws ValidationException;

    void deleteRole(UUID roleId);

    AppRoles findByName(String role);

    List<AppRoles> findAll();

}
