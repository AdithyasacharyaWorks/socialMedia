package com.example.socialMedia.controller;

import com.example.socialMedia.models.Posts;
import com.example.socialMedia.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostsController {

    private final PostsService postsService;

    @Autowired
    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }

    @PostMapping
    public ResponseEntity<String> addPost(@RequestBody Posts posts) {
        return postsService.addPosts(posts);
    }

    @GetMapping
    public List<Posts> getAllPosts() {
        return postsService.getAllPosts();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable String id){
        Optional<Posts> postToDelete = postsService.getPostById(id);
        if (postToDelete.isPresent()) {
            return postsService.deletePosts(postToDelete.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Posts> getPostById(@PathVariable String id) {
        Optional<Posts> post = postsService.getPostById(id);
        return post.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePost(@PathVariable String id, @RequestBody Posts updatedPost) {
        boolean updated = postsService.updatePost(id, updatedPost);
        if (updated) {
            return ResponseEntity.ok("Post updated successfully");
        } else {
            return ResponseEntity.status(404).body("Post not found or failed to update");
        }
    }
}
