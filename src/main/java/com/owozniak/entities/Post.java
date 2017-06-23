package com.owozniak.entities;

import javax.validation.constraints.Size;

import static com.owozniak.helpers.DateParser.parseNowDateToString;

/**
 * Created by oscar on 21.06.17.
 */
public class Post {
    private long id;
    private String date;

    @Size(max = 140)
    private String message;

    public Post(String message) {
        this.message = message;

        id = PostIdGenerator.getIncrementedPostId();
        date = parseNowDateToString();
    }

    public Post() {
    }

    public long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    private static class PostIdGenerator {
        private static long id;

        public static long getIncrementedPostId() {
            return id++;
        }
    }
}

