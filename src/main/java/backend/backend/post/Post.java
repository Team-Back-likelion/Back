package backend.backend.post;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter @Setter
@Entity
public class Post {
    //변경사항
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_id;
    private Long member_id;
    private String title;       //title이 erd에 표현되어있지 않아서 만듦.
    private String content;
    private String post_image;


    @CreatedDate
    private LocalDateTime created_at;

    @LastModifiedDate
    private LocalDateTime updated_at;
}
