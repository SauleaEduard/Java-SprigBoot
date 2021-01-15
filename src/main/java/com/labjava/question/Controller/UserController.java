package com.labjava.question.Controller;

import com.labjava.question.Dto.UserDto;
import com.labjava.question.MAPPER.UserMapper;
import com.labjava.question.Model.User;
import com.labjava.question.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/utilizator")
public class UserController {
    private UserService userService;
    private UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper=userMapper;
    }

    //@RequestMapping
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid UserDto userDto){
        System.out.println("Create user: "+userDto.getNick()+" "+userDto.getEmail());
        User user1=userService.createUser(userMapper.usermapper(userDto));
        return ResponseEntity.created(null).body(user1);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id){
        System.out.println("get user pe "+id);
        return userService.getUser(id);
    }

}
