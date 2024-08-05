package backend.backend.Service;

import backend.backend.post.Post;
import backend.backend.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Post createPost(Post post){
        return postRepository.save(post);
    }


    public ResponseEntity<Void> deletePost(Long id){
        Optional<Post> post = postRepository.findById(id);
        try{
            if(post.isPresent()){
                postRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            }else{
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
