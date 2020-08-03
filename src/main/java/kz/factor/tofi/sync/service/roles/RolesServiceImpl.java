package kz.factor.tofi.sync.service.roles;

import kz.factor.tofi.sync.model.roles.AppRoles;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class RolesServiceImpl implements RolesService {

    private final RolesRepository rolesRepository;

    @Override
    public List<AppRoles> findAll() {
        return rolesRepository.findAll();
    }
}
