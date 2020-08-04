package kz.factor.tofi.sync.service.roles;

import kz.factor.tofi.sync.exception.ValidationException;
import kz.factor.tofi.sync.model.kendo.DataSourceRequest;
import kz.factor.tofi.sync.model.kendo.DataSourceResult;
import kz.factor.tofi.sync.model.roles.AppRoles;
import lombok.AllArgsConstructor;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.Objects.isNull;

@AllArgsConstructor
@Service
public class RolesServiceImpl implements RolesService {

    @PersistenceContext
    private EntityManager entityManager;

    private final RolesRepository rolesRepository;

    private void validateAppRoles(AppRoles appRoles) throws ValidationException {
        if (isNull(appRoles))
            throw new ValidationException("Object role is null");
        if (isNull(appRoles.getName()) || appRoles.getName().isEmpty())
            throw new ValidationException("Role name is empty");
        /*if (isNull(appRoles.getName_kz()) || appRoles.getName_kz().isEmpty())
            throw new ValidationException("Role name_kz is empty");
        if (isNull(appRoles.getName_en()) || appRoles.getName_en().isEmpty())
            throw new ValidationException("Role name_en is empty");*/
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
        return rolesRepository.findAll();
    }

    @Override
    public long count() {
        return rolesRepository.count();
    }

    @Override
    public DataSourceResult get(DataSourceRequest request) {
        Session session = entityManager.unwrap(Session.class);
        return request.toDataSourceResult(session, AppRoles.class);
    }
}
