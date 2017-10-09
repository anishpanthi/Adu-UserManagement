package com.app.adu.usermanagement.service.impl;

import com.app.adu.usermanagement.domain.User;
import com.app.adu.usermanagement.repository.UserRepository;
import com.app.adu.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Anish Panthi
 * <p>
 * 10/8/2017
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findOne(Integer id) {
        return Optional.ofNullable(this.userRepository.findOne(id));
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        userRepository.delete(id);
    }

    @Override
    public void deleteEntity(User user) {
        userRepository.delete(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }
}
