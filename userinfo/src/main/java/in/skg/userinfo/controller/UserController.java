package in.skg.userinfo.controller;

import in.skg.userinfo.dto.UserDto;
import in.skg.userinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.createUser(userDto));
    }

    @GetMapping("/fetchUserById/{userId}")
    public ResponseEntity<UserDto> getUserInfoById(@PathVariable int userId) {
        Optional<UserDto> userInfoById = userService.getUserInfoById(userId);
        return userInfoById
                .map(userDto -> ResponseEntity.status(HttpStatus.OK).body(userDto))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

}
