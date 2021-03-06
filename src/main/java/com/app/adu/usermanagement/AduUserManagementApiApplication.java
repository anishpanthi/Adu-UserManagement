package com.app.adu.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.app.adu.usermanagement"})
public class AduUserManagementApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AduUserManagementApiApplication.class, args);
    }
}
