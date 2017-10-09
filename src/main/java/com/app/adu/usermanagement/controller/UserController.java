package com.app.adu.usermanagement.controller;

import com.app.adu.usermanagement.domain.User;
import com.app.adu.usermanagement.domain.error.ErrorCode;
import com.app.adu.usermanagement.domain.response.UserResponse;
import com.app.adu.usermanagement.exception.DataException;
import com.app.adu.usermanagement.exception.NotFoundException;
import com.app.adu.usermanagement.service.impl.UserServiceImpl;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
@Slf4j
public class UserController implements BaseController<User> {

    private final UserServiceImpl userServiceImpl;

    @GetMapping(value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserResponse> getUser(@ApiParam(value = "User Id to get details.", required = true) @PathVariable Integer userId) {
        Optional<User> userOptional = userServiceImpl.findOne(userId);
        return userOptional.map(user -> {
            final UserResponse userResponse = new UserResponse(user);
            userResponse.setUser(user);
            return new ResponseEntity<>(userResponse, HttpStatus.OK);
        }).orElseThrow(() -> new NotFoundException(ErrorCode.EXC404.toString(), null));
    }

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = userServiceImpl.findAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserResponse> createUser(
            @ApiParam(value = "Request Body for User", required = true) @Valid @RequestBody User user,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new DataException(ErrorCode.EXC400.toString(), bindingResult);
        }
        User createdUser = this.userServiceImpl.create(user);
        log.info("User with userId: {} is created.", createdUser.getId());
        final UserResponse userResponse = new UserResponse(createdUser);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @PutMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserResponse> updateUser(@ApiParam(value = "Request Body for User", required = true) @Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new DataException(ErrorCode.EXC400.toString(), bindingResult);
        }
        User updatedUser = this.userServiceImpl.update(user);
        log.info("User with userId: {} is Updated.", updatedUser.getId());
        final UserResponse userResponse = new UserResponse(updatedUser);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @DeleteMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> deleteUser(@ApiParam(value = "User Id as path variable", required = true) @RequestBody User user) {
        this.userServiceImpl.deleteEntity(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
