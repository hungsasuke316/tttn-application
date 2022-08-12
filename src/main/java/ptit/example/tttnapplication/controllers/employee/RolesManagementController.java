package ptit.example.tttnapplication.controllers.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ptit.example.tttnapplication.data.entity.Roles;
import ptit.example.tttnapplication.services.RolesService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class RolesManagementController {
    private final RolesService rolesService;

    @Autowired
    public RolesManagementController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @GetMapping("/roles")
    List<Roles> getAllRoles(){
        return this.rolesService.getAllRoles();
    }
}
