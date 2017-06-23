package com.owozniak.controllers;

import com.owozniak.entities.Post;
import com.owozniak.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * Created by oscar on 21.06.17.
 */
@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "{userId}/posts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Post> getPosts(@PathVariable String userId) {

        return userService.getPostsByUserId(userId);
    }

    @PostMapping(path = "{userId}/posts", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void postPost(
            HttpServletRequest request,
            HttpServletResponse response,
            @Valid @RequestBody Post post,
            @PathVariable String userId) {

        userService.addPost(post, userId);

        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    @GetMapping(path = "{userId}/timeline", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Post> getTimeline(@PathVariable String userId) {
        return userService.getTimelineByUserId(userId);
    }

    @PutMapping("{userId}/followers/{followerId}")
    public void followUser(
            HttpServletResponse response,
            @PathVariable String userId,
            @PathVariable String followerId) throws IOException {

        boolean wasAbleToAddFollower = userService.addFollower(userId, followerId);

        if (wasAbleToAddFollower) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Provided followerId is allready existing in Users follower list.");
        }

    }

}
