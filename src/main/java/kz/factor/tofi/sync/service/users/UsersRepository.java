package kz.factor.tofi.sync.service.users;

import kz.factor.tofi.sync.model.users.AppUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsersRepository extends JpaRepository<AppUsers, UUID> {
    AppUsers findByLogin(String login);
}
