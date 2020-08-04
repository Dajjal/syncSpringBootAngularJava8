package kz.factor.tofi.sync.controller.roles;

import kz.factor.tofi.sync.exception.ValidationException;
import kz.factor.tofi.sync.model.kendo.DataSourceRequest;
import kz.factor.tofi.sync.model.kendo.DataSourceResult;
import kz.factor.tofi.sync.model.roles.AppRoles;
import kz.factor.tofi.sync.service.roles.RolesService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/roles")
@AllArgsConstructor
@Log
@CrossOrigin(value = "http://localhost:4200")
public class RolesController {

    private final RolesService rolesService;

    @PostMapping("/save")
    public AppRoles saveRole(@RequestBody AppRoles model) throws ValidationException {
        log.info("Handling save roles: " + model);
        return rolesService.saveRole(model);
    }

    @PostMapping("/getAll")
    public DataSourceResult getAllRoles(@RequestBody DataSourceRequest request) {
        log.info("Handling find all roles request");
//        request.toDataSourceResult()
        DataSourceResult result = new DataSourceResult();
        result.setData(rolesService.findAll());
        result.setTotal(rolesService.count());
        return result;
//        return rolesService.findAll();
    }

    @PostMapping("/get")
    public @ResponseBody DataSourceResult get(@RequestBody DataSourceRequest request) {
        return rolesService.get(request);
    }



    @GetMapping("/findByName")
    public AppRoles findByName(@RequestParam String name) {
        log.info("Handling find by roles name request: " + name);
        return rolesService.findByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable String id) {
        log.info("Handling delete roles request: " + id);
        rolesService.deleteRole(UUID.fromString(id));
        return ResponseEntity.ok().build();
    }

}
