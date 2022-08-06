package ptit.example.tttnapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ptit.example.tttnapplication.data.entity.Roles;
import ptit.example.tttnapplication.services.RolesService;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolesController {
    private final RolesService rolesService;

    @Autowired
    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @GetMapping
    List<Roles> getAllRoles(){
        return this.rolesService.getAllRoles();
    }
}
