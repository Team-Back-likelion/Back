package service;

import dto.PostUpdateRequest;
import model.Post;
import repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
    }

    public Post updatePost(Long id, PostUpdateRequest postUpdateRequest) {
        if (postUpdateRequest == null) {
            throw new IllegalArgumentException("PostUpdateRequest cannot be null");
        }

        Optional<Post> optionalPost = postRepository.findById(id);
        if (!optionalPost.isPresent()) {
            throw new RuntimeException("Post not found");
        }

        Post post = optionalPost.get();
        post.setTitle(postUpdateRequest.getTitle());
        post.setContent(postUpdateRequest.getContent());
        return postRepository.save(post);
    }
}



