package kz.factor.tofi.sync.service.roles;

import kz.factor.tofi.sync.model.roles.AppRoles;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolesService {

    List<AppRoles> findAll();

}
