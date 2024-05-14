package estu.ceng.menumapper2.repositories;

import estu.ceng.menumapper2.models.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface UserRepository {
    long delete(String phoneNumber);
    UserEntity update(UserEntity userEntity);
    List<UserEntity> findAll();
    UserEntity save(UserEntity userEntity);
    UserEntity findOne(String id);

    UserEntity findOneWithPhoneNumber(String phoneNumber);
    Optional<UserEntity> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
