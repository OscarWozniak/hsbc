package com.owozniak.configuration;

import com.owozniak.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by oscar on 21.06.17.
 */

@Configuration
public class CommonSpringBeanConfiguration {

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }
}
