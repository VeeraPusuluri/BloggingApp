package vsg.veera.bloggingapp_springboot.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import vsg.veera.bloggingapp_springboot.dtos.CreateUserRequestDto;
import vsg.veera.bloggingapp_springboot.entities.UserEntity;
import vsg.veera.bloggingapp_springboot.repositories.UserRepository;

import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper =  modelMapper;
    }


    public UserEntity createUser(CreateUserRequestDto usr) {
        var user = modelMapper.map(usr,UserEntity.class);
        //TODO: need to encrypt password and save it.
        return userRepository.save(user);
    }

    public Optional<UserEntity> getUserByUserName(String userName) throws UserNotFoundException {
        var usr =  userRepository.findByUserName(userName);
        return usr;
    }

    public Optional<UserEntity> getLoginUser(String userName, String password) {
        var user = getUserByUserName(userName);
        if (user == null) {
            throw new UserNotFoundException(userName);
        }
        //TODO: verify password
        return user;
    }

    public UserEntity getUser(@PathVariable Long userId){
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
    }

    public UserEntity loginUser(String username, String password) {
        UserEntity user =  userRepository.findByUserName(username).orElseThrow(() -> new UserNotFoundException(username));
        //TODO: check user password
        return user;
    }

    public static class UserNotFoundException extends java.lang.IllegalArgumentException {
        public UserNotFoundException(String userName) {
            super("User " + userName + "not found");
        }

        public UserNotFoundException(Long userId) {
            super("User with" + userId + "not found");
        }
    }
}
