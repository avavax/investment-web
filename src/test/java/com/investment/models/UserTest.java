package com.investment.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName(value = "Model User is working when")
class UserTest {

    private User testUser;
    private User testAdmin;
    private User emptyUser;

    @BeforeEach
    void setUp() {
        testAdmin = User.builder()
                .id(1)
                .email("admin@admin.com")
                .name("Илья Петров")
                .password("qwerty")
                .role(User.Role.ADMIN)
                .visible(1)
                .build();

        testUser = User.builder()
                .id(2)
                .email("user@user.com")
                .name("Марсель Сидиков")
                .password("qwerty007")
                .role(User.Role.USER)
                .visible(0)
                .build();

        emptyUser = new User();
    }

    @Test
    @DisplayName("getRole() is working")
    void getRole() {
        assertEquals(testAdmin.getRole(), User.Role.ADMIN);
        assertEquals(testUser.getRole(), User.Role.USER);
    }

    @Test
    @DisplayName("getId() is working")
    void getId() {
        assertEquals(testAdmin.getId(), 1);
        assertEquals(testUser.getId(), 2);
    }

    @Test
    @DisplayName("getName() is working")
    void getName() {
        assertEquals(testAdmin.getName(), "Илья Петров");
        assertEquals(testUser.getName(), "Марсель Сидиков");
    }

    @Test
    @DisplayName("getEmail() is working")
    void getEmail() {
        assertEquals(testAdmin.getEmail(), "admin@admin.com");
        assertEquals(testUser.getEmail(), "user@user.com");
    }

    @Test
    @DisplayName("getPassword() is working")
    void getPassword() {
        assertEquals(testAdmin.getPassword(), "qwerty");
        assertEquals(testUser.getPassword(), "qwerty007");
    }

    @Test
    @DisplayName("getPassword() is working")
    void getVisible() {
        assertEquals(testAdmin.getPassword(), "qwerty");
        assertEquals(testUser.getPassword(), "qwerty007");
    }

    @Test
    @DisplayName("setRole() is working")
    void setRole() {
        emptyUser.setRole(User.Role.ADMIN);
        assertEquals(emptyUser.getRole(), User.Role.ADMIN);
    }

    @Test
    @DisplayName("setName() is working")
    void setName() {
        emptyUser.setName("Билл Гейтс");
        assertEquals(emptyUser.getName(), "Билл Гейтс");
    }

    @Test
    @DisplayName("setEmail() is working")
    void setEmail() {
        emptyUser.setEmail("email@email.com");
        assertEquals(emptyUser.getEmail(), "email@email.com");
    }

    @Test
    @DisplayName("setPassword() is working")
    void setPassword() {
        emptyUser.setPassword("qwerty");
        assertEquals(emptyUser.getPassword(), "qwerty");
    }

    @Test
    @DisplayName("setVisible() is working")
    void setVisible() {
        emptyUser.setVisible(0);
        assertEquals(emptyUser.getVisible(), 0);
    }
}