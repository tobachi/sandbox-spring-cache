package dev.tobachi.sandbox.cache.service;

import dev.tobachi.sandbox.cache.model.UserDataSource;
import dev.tobachi.sandbox.cache.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    private UserDataSource userDataSource;

    public List<User> getAll() {
        return userDataSource.getAll();
    }

}
