package org.example.dependencyinjectionlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DependencyInjectionLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(DependencyInjectionLabApplication.class, args);
        System.out.println("App Started...");
    }

}
