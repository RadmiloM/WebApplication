package com.example.WebApplication.repository;

import com.example.WebApplication.entity.Role;
import com.example.WebApplication.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static com.example.WebApplication.entity.Role.USER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository testRepository;

    @AfterEach
    void tearDown(){
        testRepository.deleteAll();;
    }

    @Test
    void testIfEmailExists() {

        // given the input
        String email = "markovicradmilo@yahoo.com";
        User user = new User(
                1l,
                email,
                "$2a$12$WvW0VZP3c.klx5p9nkbz1uCzjKxmiQ9EuVu8JNIh9lofGuDSGPkfO",
                USER
        );
        testRepository.save(user);

        //when this happend
        var expected = testRepository.findByEmail(email);

        // then this is expected
        assertThat(expected).isNotEmpty();
    }

    @Test
    void testIfEmailDoesNotExists() {
        // given the input
        String email = "marko@zlatimirovic.com";

        //when this happend
        var expected = testRepository.findByEmail(email);

        // then this is expected
        assertThat(expected).isEmpty();

    }
}