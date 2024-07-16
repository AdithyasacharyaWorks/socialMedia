package com.example.socialMedia.service;

import com.example.socialMedia.models.Posts;
import com.example.socialMedia.repository.PostsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PostsService {
    private final PostsRepo postsRepo;

    @Autowired
    public PostsService(PostsRepo postsRepo) {
        this.postsRepo = postsRepo;
    }

    public ResponseEntity<String> addPosts(Posts posts) {
        try {
            postsRepo.insert(posts);
            return ResponseEntity.ok("Post added successfully");
        } catch (Exception e) {
            e.printStackTrace(); // Example: logging the exception
            return ResponseEntity.status(500).body("Failed to add post"); // Internal server error
        }
    }

    public List<Posts> getAllPosts() {
        try {
            return postsRepo.findAllWithoutComments();
        } catch (Exception e) {
            e.printStackTrace(); // Example: logging the exception
            return null; // Example: returning null in case of error
        }
    }

    public Optional<Posts> getPostById(String id) {
        try {
            return postsRepo.findByIdWithComments(id);
        } catch (Exception e) {
            e.printStackTrace(); // Example: logging the exception
            return Optional.empty(); // Example: returning empty optional in case of error
        }
    }

    public ResponseEntity<String> deletePosts(Posts post) {
        try {
            postsRepo.delete(post);
            return ResponseEntity.ok("Post deleted successfully");
        } catch (Exception e) {
            e.printStackTrace(); // Example: logging the exception
            return ResponseEntity.status(500).body("Failed to delete post"); // Internal server error
        }
    }

    public boolean updatePost(String id, Posts updatedPost) {
        try {
            Optional<Posts> existingPostOptional = postsRepo.findById(id);
            if (existingPostOptional.isPresent()) {
                Posts existingPost = existingPostOptional.get();
                // Update fields that should be updated
                existingPost.setPost_content(updatedPost.getPost_content());
                existingPost.setPost_title(updatedPost.getPost_title());
                existingPost.setPost_image_url(updatedPost.getPost_image_url());
                existingPost.setLikes(updatedPost.getLikes());
                existingPost.setDislikes(updatedPost.getDislikes());

                // Save updated post
                postsRepo.save(existingPost);
                return true;
            } else {
                return false; // Post not found
            }
        } catch (Exception e) {
            e.printStackTrace(); // Example: logging the exception
            return false; // Failed to update post
        }
    }
}
