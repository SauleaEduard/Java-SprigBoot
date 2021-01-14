package com.labjava.question.Controller;

import com.labjava.question.Dto.UserDto;
import com.labjava.question.MAPPER.UserMapper;
import com.labjava.question.Model.User;
import com.labjava.question.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/utilizator")
public class UserController {
    private UserService userService;
    private UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper=userMapper;
    }

    @RequestMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid UserDto userDto){
        User user1=userService.createUser(userMapper.usermapper(userDto));
        return ResponseEntity.created(null).body(user1);
    }
}
