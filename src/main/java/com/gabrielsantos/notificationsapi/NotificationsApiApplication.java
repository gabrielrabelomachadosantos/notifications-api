package com.gabrielsantos.notificationsapi;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class NotificationsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationsApiApplication.class, args);
    }

}
