package vsg.veera.bloggingapp_springboot.dtos;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Data
@Setter
@Getter
public class UpdateArticleEntityDto {

    @Nullable
    private String title;
    @Nullable
    private String body;
    @Nullable
    private String subtitle;
}
