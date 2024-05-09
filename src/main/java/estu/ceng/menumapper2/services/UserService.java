package estu.ceng.menumapper2.services;

import estu.ceng.menumapper2.dtos.UserDTO;

import java.util.List;

public interface UserService {
    long delete(String id);
    UserDTO update(UserDTO UserDTO);
    List<UserDTO> findAll();
    UserDTO save(UserDTO UserDTO);


}
