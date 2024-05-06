package vsg.veera.bloggingapp_springboot.dtos;

import lombok.Data;

@Data
public class CreateNewUserResponse {

    private Long id;
    private String username;
    private String email;
    private String bio;
    private String image;
}
