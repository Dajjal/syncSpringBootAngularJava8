package kz.factor.tofi.sync.repository;

import kz.factor.tofi.sync.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findByLogin(String login);
    Users findByName(String name);
}
