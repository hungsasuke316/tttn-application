package ptit.example.tttnapplication.data.repositpty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptit.example.tttnapplication.data.entity.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {
    Roles findByName(String name);
}
