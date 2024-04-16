package vsg.veera.bloggingapp_springboot.services;

import org.springframework.stereotype.Service;
import vsg.veera.bloggingapp_springboot.dtos.CreateUserRequestDto;
import vsg.veera.bloggingapp_springboot.entities.UserEntity;
import vsg.veera.bloggingapp_springboot.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity createUser(CreateUserRequestDto usr) {
        var user = UserEntity
                .builder()
                .userName(usr.getUsername())
                //.password()
                .email(usr.getEmail())
                .build();
        return userRepository.save(user);
    }

    public UserEntity getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public UserEntity getLoginUser(String userName, String password) {
        var user = getUserByUserName(userName);
        if (user == null) {
            throw new UserNotFoundException(userName);
        }
        //TODO: verify password
        return user;
    }

    static class UserNotFoundException extends java.lang.IllegalArgumentException {
        public UserNotFoundException(String userName) {
            super("User " + "username" + "not found");
        }
    }
}
