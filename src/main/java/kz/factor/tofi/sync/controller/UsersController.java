package kz.factor.tofi.sync.controller;

import kz.factor.tofi.sync.model.roles.AppRoles;
import kz.factor.tofi.sync.model.users.UsersDto;
import kz.factor.tofi.sync.exception.ValidationException;
import kz.factor.tofi.sync.service.roles.RolesService;
import kz.factor.tofi.sync.service.users.UsersService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Log
public class UsersController {

    private final UsersService usersService;
    private final RolesService rolesService;

    @PostMapping("/save")
    public UsersDto saveUsers(@RequestBody UsersDto usersDto) throws ValidationException {
        log.info("Handling save users: " + usersDto);
        return usersService.saveUser(usersDto);
    }

    @GetMapping("/findAll")
    public List<UsersDto> findAllUsers() {
        log.info("Handling find all users request");
        return usersService.findAll();
    }

    @GetMapping("/findByLogin")
    public UsersDto findByLogin(@RequestParam String login) {
        log.info("Handling find by login request: " + login);
        return usersService.findByLogin(login);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable String id) {
        log.info("Handling delete user request: " + id);
        usersService.deleteUser(UUID.fromString(id));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getRoles")
    public List<AppRoles> getRoles() {
        log.info("Handling find all roles request");
        return rolesService.findAll();
    }

}
