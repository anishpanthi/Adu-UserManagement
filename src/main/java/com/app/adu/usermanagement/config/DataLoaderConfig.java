package com.app.adu.usermanagement.config;

import com.app.adu.usermanagement.domain.User;
import com.app.adu.usermanagement.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.util.List;

/**
 * @author Anish Panthi
 * <p>
 * 10/8/2017
 */

@Slf4j
@Configuration
@Profile("default")
public class DataLoaderConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        String userURL = "/data/users.json";
        //setup user data
        if (((List<User>) this.userRepository.findAll()).isEmpty()) {
            setUpData(userURL, "User");
        }
    }

    public void setUpData(String url, String className) throws Exception {
        Resource rsrc = new ClassPathResource(url);
        String path = rsrc.getFile().getAbsolutePath();
        ObjectMapper mapper = new ObjectMapper();

        switch (className) {
            case "User":
                List<User> users = mapper.readValue(new File(path), mapper.getTypeFactory().constructCollectionType(List.class, User.class));
                this.userRepository.save(users);
                log.debug("{} Users saved.", users.size());
                break;
        }
    }
}
