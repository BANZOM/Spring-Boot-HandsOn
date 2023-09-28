package com.firstspringboot.firstspringboot.resourcehandson;

import java.io.File;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResourcesDummy {
    // Put the bean dummy into the spring container
    @Bean(name = "dummy")
    public File dummy() {
        File file = new File("dummy.txt");
        return file;
    }

    // Put the bean dummy2 into the spring container
    @Bean(name = "dummy2")
    public File dummy2() {
        File file = new File("dummy2.txt");
        return file;
    }
}
