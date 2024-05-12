package estu.ceng.menumapper2.services;

import estu.ceng.menumapper2.dtos.UserDTO;
import estu.ceng.menumapper2.models.UserEntity;
import estu.ceng.menumapper2.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public long delete(String phoneNumber) {
        return userRepository.delete(phoneNumber);
    }

    @Override
    public UserDTO update(UserDTO UserDTO) {

        return new UserDTO(userRepository.update(UserDTO.toUserEntity()));
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(UserDTO::new).toList();
    }

    @Override
    public UserDTO save(UserDTO UserDTO) {
        return new UserDTO(userRepository.save(UserDTO.toUserEntity()));
    }

    @Override
    public UserDTO findOne(String id) {
        return new UserDTO(userRepository.findOne(id));
    }

    @Override
    public UserDTO findOneWithPhoneNumber(String phoneNumber) {
        return new UserDTO(userRepository.findOneWithPhoneNumber(phoneNumber));
    }


}
