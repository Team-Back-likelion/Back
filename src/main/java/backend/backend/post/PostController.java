package backend.backend.post;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;
    //test



    @PostMapping("api/post")
    public ResponseEntity<Post> createPost(@RequestBody Post post){
        Post createdPost = postService.createPost(post);
        return ResponseEntity.ok(post);
    }


    @DeleteMapping("api/post/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id){
        return postService.deletePost(id);
    }

}
