package estu.ceng.menumapper2.services;

import estu.ceng.menumapper2.dtos.UserDTO;
import estu.ceng.menumapper2.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public long delete(String id) {
        return userRepository.delete(id);
    }

    @Override
    public UserDTO update(UserDTO UserDTO) {
        return null;
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(UserDTO::new).toList();
    }

    @Override
    public UserDTO save(UserDTO UserDTO) {
        return new UserDTO(userRepository.save(UserDTO.toUserEntity()));
    }


}
