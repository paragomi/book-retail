package com.example.bookretail.configuration;

import org.modelmapper.*;
import org.springframework.context.annotation.*;

@Configuration
public class BeanConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
