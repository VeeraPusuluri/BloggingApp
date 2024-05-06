package vsg.veera.bloggingapp_springboot.dtos;


import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String bio;
    private String image;

}
