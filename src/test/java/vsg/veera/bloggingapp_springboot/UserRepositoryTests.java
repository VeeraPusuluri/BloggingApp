package vsg.veera.bloggingapp_springboot;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import vsg.veera.bloggingapp_springboot.entities.UserEntity;
import vsg.veera.bloggingapp_springboot.repositories.UserRepository;

import java.util.Objects;

@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTests {


    @Autowired
    private UserRepository userRepository;

    @Test
    @Order(1)
    void create_NewUsers_Test(){
         UserEntity user = UserEntity.builder()
                .userName("test user")
                .email("test@gmail.com")
                .build();
         userRepository.save(user);
    }

    @Test
    @Order(2)
    void find_user_by_username(){
        UserEntity user = UserEntity.builder()
                .userName("test user")
                .email("test@gmail.com")
                .build();
        userRepository.save(user);

        var userEntity = userRepository.findByUserName("test user");
        Assertions.assertEquals(user.getUserName(), "test user");
    }

}
