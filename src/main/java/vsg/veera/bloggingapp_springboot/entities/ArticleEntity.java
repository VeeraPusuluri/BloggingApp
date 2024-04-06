package vsg.veera.bloggingapp_springboot.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Date;

@Getter
@Entity(name = "articles")
@Data
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class ArticleEntity {


    @Id
    @GeneratedValue
    @NonNull
    private Long id;

    @NonNull
    private String title;

    @Nullable
    private String subTitle;

    @NonNull
    @Column(unique = true)
    private String slug;

    @NonNull
    private String body;

    @NonNull
    @CreatedDate
    private Date created;


    @ManyToOne
    @JoinColumn(name = "authorId", nullable = false)
    private UserEntity author;
}
