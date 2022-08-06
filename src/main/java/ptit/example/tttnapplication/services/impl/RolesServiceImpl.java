package ptit.example.tttnapplication.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptit.example.tttnapplication.data.entity.Roles;
import ptit.example.tttnapplication.data.repositpty.RolesRepository;
import ptit.example.tttnapplication.services.RolesService;

import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {
    private final RolesRepository rolesRepository;

    @Autowired
    public RolesServiceImpl(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public List<Roles> getAllRoles() {
        return this.rolesRepository.findAll();
    }
}
