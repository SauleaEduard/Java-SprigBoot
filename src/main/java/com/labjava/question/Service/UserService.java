package com.labjava.question.Service;

import com.labjava.question.Ex.DuplicateUserEx;
import com.labjava.question.Model.*;
import com.labjava.question.Repo.*;
import org.springframework.stereotype.*;

import java.util.Optional;

@Service
public class UserService {
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {

        this.userRepo = userRepo;
    }

    public User createUser(User user){
        Optional<User> userwsameemail = userRepo
                .getByEmail(user.getEmail());
        if(userwsameemail.isPresent()){
            throw new DuplicateUserEx();
        }
        return userRepo.createUser(user);
    }
}
