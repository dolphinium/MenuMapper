package estu.ceng.menumapper2.repositories;

import estu.ceng.menumapper2.models.ERole;
import estu.ceng.menumapper2.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
