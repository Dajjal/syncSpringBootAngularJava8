package kz.factor.tofi.sync.service.roles;

import kz.factor.tofi.sync.model.roles.AppRoles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RolesRepository extends JpaRepository<AppRoles, UUID> {
    AppRoles findByName(String roleName);
}
