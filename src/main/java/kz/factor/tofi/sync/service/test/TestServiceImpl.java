package kz.factor.tofi.sync.service.test;

import kz.factor.tofi.sync.model.kendo.DataSourceRequest;
import kz.factor.tofi.sync.model.kendo.DataSourceResult;
import kz.factor.tofi.sync.model.roles.AppRoles;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class TestServiceImpl implements TestService {

    @Override
    public DataSourceResult getList(DataSourceRequest request) {
        return null;
    }
}
