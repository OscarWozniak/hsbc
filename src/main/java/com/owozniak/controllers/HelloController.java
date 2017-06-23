package com.owozniak.controllers;

import com.owozniak.entities.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by oscar on 21.06.17.
 */

@RestController
public class HelloController {

    @GetMapping("/")
    public Post getHelloMessage() {
        return new Post("Hello HSBC!");
    }

}
