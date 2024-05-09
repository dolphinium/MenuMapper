package estu.ceng.menumapper2.controllers;

import estu.ceng.menumapper2.dtos.UserDTO;
import estu.ceng.menumapper2.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    public List<UserDTO> getUsers() {
        return userService.findAll();
    }

    @PostMapping("user")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO postUser(@RequestBody UserDTO UserDTO) {
        return userService.save(UserDTO);
    }

}
