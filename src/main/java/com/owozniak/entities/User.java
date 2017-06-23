package com.owozniak.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by oscar on 21.06.17.
 */
public class User {

    private String id;
    private Set<String> follows;
    private List<Post> posts;

    public User(String id) {
        this.id = id;

        follows = new HashSet<>();
        posts = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public Set<String> getFollows() {
        return new HashSet<>(follows);
    }

    public List<Post> getPosts() {
        return new ArrayList<>(posts);
    }

    public boolean addFollows(String followerId) {
        return follows.add(followerId);
    }

    public void addPost(String message) {
        posts.add(new Post(message));
    }

}
