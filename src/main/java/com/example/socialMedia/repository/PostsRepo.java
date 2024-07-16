package com.example.socialMedia.repository;

import com.example.socialMedia.models.Posts;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostsRepo extends MongoRepository<Posts, String> {

    // Query to find all posts without comments
    @Query(value = "{}", fields = "{ 'comments' : 0 }")
    List<Posts> findAllWithoutComments();

    // Query to find a specific post by ID with comments
    @Query(value = "{ '_id' : ?0 }")
    Optional<Posts> findByIdWithComments(String id);
}
