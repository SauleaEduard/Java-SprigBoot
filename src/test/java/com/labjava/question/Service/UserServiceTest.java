package com.labjava.question.Service;

import com.labjava.question.Ex.DuplicateUserEx;
import com.labjava.question.Model.User;
import com.labjava.question.Repo.UserRepo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepo userRepo;
    @InjectMocks
    private UserService userService;

    @Test //true
    void createUser() {
        User user = new User("edi123","gigi@gmail.com");
        User suser = new User("edi123","gigi@gmail.com",1);
        when(userRepo.getByEmail(any())).thenReturn(Optional.empty());
        when(userRepo.createUser(any())).thenReturn(suser);

        User r=userService.createUser(user);
        assertEquals(user.getNick(),r.getNick());
        assertEquals(user.getEmail(),r.getEmail());
        assertEquals(1,r.getId());
        assertNotNull(r.getId());

        //verificare pentru apelarea functiilor
        verify(userRepo,times(1)).getByEmail(any());
        verify(userRepo,times(1)).createUser(any());
    }
    @Test //false
    void createEx() {
        User user = new User("edi123","gigi@gmail.com");
        User suser = new User("edi123","gigi@gmail.com",1);
        when(userRepo.getByEmail(any())).thenReturn(Optional.of(suser));
        //when(userRepo.createUser(any())).thenReturn(suser);

        DuplicateUserEx ex=assertThrows(DuplicateUserEx.class,
                () -> userService.createUser(user)
        ) ;

        assertEquals("Exista deja un cont cu aceasta adresa de email!",
                ex.getMessage());

        //verificare pentru apelarea functiilor
        verify(userRepo,times(1)).getByEmail(any());
        verify(userRepo,times(0)).createUser(any());
    }
}