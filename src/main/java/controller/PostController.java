package controller;

import dto.PostUpdateRequest;
import model.Post;
import service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    // 게시글 상세 조회
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Post post = postService.getPostById(id);
        return ResponseEntity.ok(post);
    }

    // 게시글 수정
    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody PostUpdateRequest postUpdateRequest) {
        if (postUpdateRequest == null) {
            return ResponseEntity.badRequest().build();
        }

        Post updatedPost = postService.updatePost(id, postUpdateRequest);
        return ResponseEntity.ok(updatedPost);
    }
}
