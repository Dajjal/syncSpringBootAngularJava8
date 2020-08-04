package kz.factor.tofi.sync.service.test;

import kz.factor.tofi.sync.model.kendo.DataSourceRequest;
import kz.factor.tofi.sync.model.kendo.DataSourceResult;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManagerFactory;

public interface TestService {

    DataSourceResult getList(DataSourceRequest request);

}
