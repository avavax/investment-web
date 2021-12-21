package com.investment.repositories;

import com.investment.models.Bond;
import com.investment.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@RunWith(SpringRunner.class)
@DisplayName(value = "User Repository is working when")
class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    private User visibleUser1;
    private User visibleUser2;
    private User unvisibleUser;

    @BeforeEach
    void setUp() {
        visibleUser1 = User.builder().visible(1).email("user1@user.com").build();
        visibleUser2 = User.builder().visible(1).email("user2@user.com").build();
        unvisibleUser = User.builder().visible(0).email("user3@user.com").build();
        entityManager.persist(visibleUser1);
        entityManager.persist(visibleUser2);
        entityManager.persist(unvisibleUser);
    }

    @Test
    @DisplayName("findOneByLogin() is working")
    void findOneByLogin() {
        User user = userRepository.findOneByLogin("user1@user.com").get();
        assertEquals(visibleUser1, user);
    }

    @Test
    @DisplayName("findAllVisible() is working")
    void findAllVisible() {
        List<User> users = userRepository.findAllVisible();
        assertTrue(users.contains(visibleUser1));
        assertTrue(users.contains(visibleUser2));
        assertFalse(users.contains(unvisibleUser));
        assertEquals(2, users.size());
    }

    @Test
    @DisplayName("save() is working")
    void save() {
        User user = User.builder().visible(1).email("user4@user.com").build();
        userRepository.save(user);
        User resultUser = userRepository.getById(user.getId());
        assertEquals(user, resultUser);
    }

    @Test
    @DisplayName("findById() is working")
    void findById() {
        Integer id = visibleUser1.getId();
        User resultUser = userRepository.findById(id).get();
        assertEquals(resultUser, visibleUser1);
    }

    @Test
    @DisplayName("findByIdException() is working")
    void findByIdException() throws NoSuchElementException {
        Throwable thrown = assertThrows(NoSuchElementException.class, () -> {
            User resultUser = userRepository.findById(1000).get();;
        });
        assertNotNull(thrown.getMessage());
    }
}


