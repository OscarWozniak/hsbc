package com.owozniak.services;

import com.owozniak.entities.Post;
import com.owozniak.entities.User;
import com.owozniak.helpers.PostsComparators;
import com.owozniak.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by oscar on 22.06.17.
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Post> getPostsByUserId(String userId) {
        return getUserPosts(userId);
    }

    private List<Post> getUserTimeline(String id) {
        User user = userRepository.getUser(id);

        Set<String> followers = user.getFollows();
        Comparator<Post> byPostsDate = PostsComparators.getDateChronologicallyReversed();

        return followers.stream()
                .map(followerId -> userRepository.getUser(followerId).getPosts())
                .flatMap(posts -> posts.stream())
                .sorted(byPostsDate)
                .collect(Collectors.toList());
    }

    private List<Post> getUserPosts(String id) {
        Comparator<Post> byDate = PostsComparators.getDateChronologicallyReversed();

        return userRepository.getUser(id)
                .getPosts()
                .stream()
                .sorted(byDate)
                .collect(Collectors.toList());
    }

    public void addPost(Post post, String userId) {
        User user = getOrCreateUser(userId);

        user.addPost(post.getMessage());
    }

    public List<Post> getTimelineByUserId(String userId) {
        return getUserTimeline(userId);
    }

    public boolean addFollower(String userId, String followerId) {
        User user = userRepository.getUser(userId);
        User follower = userRepository.getUser(followerId);

        return user.addFollows(followerId);
    }

    /**
     * @apiNote This solution is due to criteria "don't care about registering users: <b>a user is created as soon as they post their first message</b>" and "tell don't ask" rule
     */
    private User getOrCreateUser(String userId) {
        User user;

        try {
            user = userRepository.getUser(userId);
        } catch (NoSuchElementException e) {
            user = userRepository.createUser(userId);
        }

        return user;
    }

}
