package com.investment.services;

import com.investment.forms.UserForm;
import com.investment.models.User;
import com.investment.repositories.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName(value = "User Service is working when")
class UserServiceImplTest {

    @Mock
    private UserRepository userRepositoryMock;

    @Mock
    private PasswordEncoder passwordEncoderMock;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    @DisplayName("getAllUsers() is working")
    void getAllUsers() {
        List<User> users = new ArrayList<>();
        User user1 = User.builder().name("User 1").build();
        User user2 = User.builder().name("User 1").build();
        users.add(user1);
        users.add(user2);

        Mockito.when(userRepositoryMock.findAllVisible()).thenReturn(users);
        List<User> resultUsers = userService.getAllUsers();
        assertEquals(2, resultUsers.size());
        Mockito.verify(userRepositoryMock).findAllVisible();
    }

    @Test
    @DisplayName("getUserById() is working")
    void getUserById() {
        User user = User.builder().name("User 1").build();
        Integer userId = user.getId();

        Mockito.when(userRepositoryMock.findById(userId)).thenReturn(java.util.Optional.of(user));
        User resultUser = userService.getUserById(userId);
        assertEquals(user, resultUser);
        Mockito.verify(userRepositoryMock).findById(userId);
    }

    @Test
    @DisplayName("save() is working")
    void save() {
        UserForm userForm = new UserForm();
        User user = User.builder().role(User.Role.USER).visible(1).build();
        userService.save(userForm);
        Mockito.verify(userRepositoryMock).save(user);
    }

    @Test
    @DisplayName("getUserByLogin() is working")
    void getUserByLogin() {
        User user = User.builder().email("user@user.com").build();
        String userLogin = user.getEmail();

        Mockito.when(userRepositoryMock.findOneByLogin(userLogin)).thenReturn(java.util.Optional.of(user));
        User resultUser = userService.getUserByLogin(userLogin).get();
        assertEquals(user, resultUser);
        Mockito.verify(userRepositoryMock).findOneByLogin(userLogin);
    }

    @Test
    @DisplayName("softDelete() is working")
    void softDelete() {
        Integer id = 1;
        userService.softDelete(id);
        Mockito.verify(userRepositoryMock).softDelete(id);
    }
}