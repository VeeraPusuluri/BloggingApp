package vsg.veera.bloggingapp_springboot.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class CreateArticleRequestDto {
    private String title;
    private String body;
    private String subtitle;


}
