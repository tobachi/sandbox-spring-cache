package dev.tobachi.sandbox.cache.controller;

import dev.tobachi.sandbox.cache.model.User;
import dev.tobachi.sandbox.cache.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Slf4j
public class UserRestController {

    private UserService userService;

    @GetMapping(value = "/get/all")
    List<User> getAll() {
        List<User> userList = userService.getAll();
        return userList;
    }

}
