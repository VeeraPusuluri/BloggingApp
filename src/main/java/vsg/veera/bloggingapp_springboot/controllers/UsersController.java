package vsg.veera.bloggingapp_springboot.controllers;


import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vsg.veera.bloggingapp_springboot.dtos.*;
import vsg.veera.bloggingapp_springboot.entities.UserEntity;
import vsg.veera.bloggingapp_springboot.services.UserService;

import java.net.URI;
import java.util.logging.Logger;

@RestController
@RequestMapping("/users")
public class UsersController {

    UserService userService;
    private final ModelMapper modelMapper;

    public UsersController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("")
    public ResponseEntity<UserResponseDto> singUpUser(@RequestBody CreateUserRequestDto createUser) {
        var createdUser = userService.createUser(createUser);

        URI userUri = URI.create("users/" + createdUser.getId());
        return ResponseEntity.created(userUri).body(modelMapper.map(createdUser, UserResponseDto.class));
    }

    @GetMapping("/{userName}")
    public ResponseEntity<CreateNewUserResponse> getUserWithUserName(@PathVariable String userName) {
        var user = userService.getUserByUserName(userName);
        return ResponseEntity.ok(modelMapper.map(user, CreateNewUserResponse.class));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> loginUser(@RequestBody UserLoginRequest loginRequest) {
        UserEntity user = userService.loginUser(loginRequest.getUsername(), loginRequest.getPassword());
        return ResponseEntity.ok(modelMapper.map(user, UserResponseDto.class));
    }

    @ExceptionHandler({UserService.UserNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(Exception e) {
        HttpStatus status;
        String message;
        if (e instanceof UserService.UserNotFoundException) {
            status = HttpStatus.NOT_FOUND;
        } else {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        message = e.getMessage();
        ErrorResponse response = ErrorResponse.builder()
                .message(message).build();
        return ResponseEntity.status(status).body(response);
    }

}
