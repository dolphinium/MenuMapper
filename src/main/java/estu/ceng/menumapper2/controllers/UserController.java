package estu.ceng.menumapper2.controllers;

import estu.ceng.menumapper2.dtos.UserDTO;
import estu.ceng.menumapper2.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("get/users")
    public List<UserDTO> getUsers() {
        return userService.findAll();
    }

    @GetMapping("get/userWithId/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String id) {
        UserDTO UserDTO = userService.findOne(id);
        if (UserDTO == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(UserDTO);
    }

    @PostMapping("add/user")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO postUser(@RequestBody UserDTO UserDTO) {
        return userService.save(UserDTO);
    }

    @DeleteMapping("delete/user/{phoneNumber}")
    public Long deleteUser(@PathVariable String phoneNumber) {
        return userService.delete(phoneNumber);
    }

    @GetMapping("get/userWithPhoneNumber/{phoneNumber}")
    public ResponseEntity<UserDTO> getUserWithPhoneNumber(@PathVariable String phoneNumber) {
        UserDTO UserDTO = userService.findOneWithPhoneNumber(phoneNumber);
        if (UserDTO == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(UserDTO);
    }

    @PutMapping("/update/user")
    public UserDTO updateUser(@RequestBody UserDTO UserDTO) {
        return userService.update(UserDTO);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final Exception handleAllExceptions(RuntimeException e) {
        LOGGER.error("Internal server error.", e);
        return e;
    }
}
