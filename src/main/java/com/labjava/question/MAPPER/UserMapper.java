package com.labjava.question.MAPPER;

import com.labjava.question.Dto.UserDto;
import com.labjava.question.Model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User usermapper(UserDto userDto){
        return new User(userDto.getNick(),userDto.getEmail());
    }
}
