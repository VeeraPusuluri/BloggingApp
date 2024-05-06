package vsg.veera.bloggingapp_springboot.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Entity(name = "users")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @NonNull
    String userName;

    @NonNull
    String email;

    @Nullable
    String bio;

    @Nullable
    String image;


}
