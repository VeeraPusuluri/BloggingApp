package vsg.veera.bloggingapp_springboot.dtos;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;


@Data
@Setter(AccessLevel.NONE)
@AllArgsConstructor
public class CreateUserRequestDto {
    private String username;
    private String password;
    private String email;

}
