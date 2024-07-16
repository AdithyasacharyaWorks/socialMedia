package com.example.socialMedia.models;

import org.springframework.data.mongodb.core.mapping.Field;

public class Comment {

    @Field("user_id")
    private String user_id;

    @Field("comment_content")
    private String comment_content;

    // Constructor
    public Comment(String user_id, String comment_content) {
        this.user_id = user_id;
        this.comment_content = comment_content;
    }

    // Getters and Setters
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    // toString method
    @Override
    public String toString() {
        return "Comment{" +
                "user_id='" + user_id + '\'' +
                ", comment_content='" + comment_content + '\'' +
                '}';
    }
}
