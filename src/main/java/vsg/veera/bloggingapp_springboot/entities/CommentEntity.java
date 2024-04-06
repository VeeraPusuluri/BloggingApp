package vsg.veera.bloggingapp_springboot.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Getter
@Entity(name = "comments")
@Data
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class CommentEntity {

    @Id
    @GeneratedValue
    @NonNull
    private Long id;


    @Nullable
    private String title;

    @NonNull
    private String body;

    @CreatedDate
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "articleId", nullable = false)
    private ArticleEntity article;


    @ManyToOne
    @JoinColumn(name = "authorId", nullable = false)
    private  UserEntity user;

}
