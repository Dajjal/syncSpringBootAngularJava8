package kz.factor.tofi.sync.controller.users;

import kz.factor.tofi.sync.model.kendo.DataSourceRequest;
import kz.factor.tofi.sync.model.kendo.DataSourceResult;
import kz.factor.tofi.sync.model.users.UsersDto;
import kz.factor.tofi.sync.exception.ValidationException;
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
@CrossOrigin
public class UsersController {

    private final UsersService usersService;

    @PostMapping("/save")
    public UsersDto saveUsers(@RequestBody UsersDto model) throws ValidationException {
        log.info("Handling save users: " + model);
        return usersService.saveUser(model);
    }

    @PostMapping("/get")
    public @ResponseBody DataSourceResult get(@RequestBody DataSourceRequest request) {
        return usersService.get(request);
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

}
