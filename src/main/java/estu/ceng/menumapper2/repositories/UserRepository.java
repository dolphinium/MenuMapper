package estu.ceng.menumapper2.repositories;

import estu.ceng.menumapper2.dtos.UserDTO;
import estu.ceng.menumapper2.models.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository {
    long delete(String id);
    UserDTO update(UserDTO UserDTO);
    List<UserEntity> findAll();
    UserEntity save(UserEntity userEntity);

}
