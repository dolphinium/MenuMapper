package estu.ceng.menumapper2.dtos;

import estu.ceng.menumapper2.models.Role;
import estu.ceng.menumapper2.models.UserEntity;
import org.bson.types.ObjectId;

import java.util.Set;

public record UserDTO(
        String id,
        String role,
        String name,
        String surname,
        String phoneNumber,
        String password,
        String username,
        String email,
        Set<Role> roles
        ) {

    public UserDTO(UserEntity p){
        this(p.getId() == null ? new ObjectId().toHexString() : p.getId().toHexString(),
                p.getRole(),
                p.getName(),
                p.getSurname(),
                p.getPhoneNumber(),
                p.getPassword(),
                p.getUsername(),
                p.getEmail(),
                p.getRoles());
    }

    public UserEntity toUserEntity(){
        ObjectId _id = id == null ? new ObjectId() : new ObjectId(id);
        return new UserEntity(_id, role, name, surname, phoneNumber, password,username,
                email,roles);
    }

}
