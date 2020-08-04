package kz.factor.tofi.sync.controller.roles;

import kz.factor.tofi.sync.model.kendo.DataSourceRequest;
import kz.factor.tofi.sync.model.kendo.DataSourceResult;
import kz.factor.tofi.sync.service.test.TestService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@AllArgsConstructor
@Log
@CrossOrigin()
public class TestController {

    TestService order;

    @RequestMapping(value = "/getAll", method = RequestMethod.POST)
    public @ResponseBody
    DataSourceResult read(@RequestBody DataSourceRequest request) {
        return order.getList(request);
    }

}
