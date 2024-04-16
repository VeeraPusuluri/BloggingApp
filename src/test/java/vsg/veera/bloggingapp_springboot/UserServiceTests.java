package vsg.veera.bloggingapp_springboot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import vsg.veera.bloggingapp_springboot.dtos.CreateUserRequestDto;
import vsg.veera.bloggingapp_springboot.repositories.UserRepository;
import vsg.veera.bloggingapp_springboot.services.UserService;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTests {

    @Autowired
    UserService userService;

    @Test
    public void createUserTest() {
        var user = userService.createUser(
                new CreateUserRequestDto("John", "JOhn123", "john@gmail.com")
        );
        Assertions.assertNotNull(user);
        Assertions.assertEquals("John", user.getUserName());
    }
}
