package com.example.socialMedia.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "posts")
public class Posts {

    @Id
    private String _id;

    @Field("id")
    private String id;

    @Field("post_content")
    private String post_content;

    @Field("post_title")
    private String post_title;

    @Field("post_image_url")
    private String post_image_url;

    @Field("likes")
    private List<String> likes;

    @Field("dislikes")
    private List<String> dislikes;

    @Field("comments")
    private List<Comment> comments;

    public Posts(String id, String post_content, String post_title, String post_image_url,
                 List<String> likes, List<String> dislikes, List<Comment> comments) {
        this.id = id;
        this.post_content = post_content;
        this.post_title = post_title;
        this.post_image_url = post_image_url;
        this.likes = likes;
        this.dislikes = dislikes;
        this.comments = comments;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost_image_url() {
        return post_image_url;
    }

    public void setPost_image_url(String post_image_url) {
        this.post_image_url = post_image_url;
    }

    public List<String> getLikes() {
        return likes;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }

    public List<String> getDislikes() {
        return dislikes;
    }

    public void setDislikes(List<String> dislikes) {
        this.dislikes = dislikes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "_id='" + _id + '\'' +
                ", id='" + id + '\'' +
                ", post_content='" + post_content + '\'' +
                ", post_title='" + post_title + '\'' +
                ", post_image_url='" + post_image_url + '\'' +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                ", comments=" + comments +
                '}';
    }


}


