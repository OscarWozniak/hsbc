package com.owozniak.repositories;

import com.owozniak.entities.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oscar on 21.06.17.
 */
public class UserRepository {

    private final List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
    }

    public User getUser(String id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .get();
    }

    public User createUser(String id) {
        User user = new User(id);
        users.add(user);

        return user;
    }
}
