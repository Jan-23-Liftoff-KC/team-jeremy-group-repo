package com.digitalfilingcabinet.demo.models;

import com.digitalfilingcabinet.demo.models.data.RoleListRepository;
import com.digitalfilingcabinet.demo.models.data.UserListRepository;

import java.util.List;

public class UserService {
    public List<User> listAll(){
        return UserListRepository.findAll();
    }

    public User get(Long id) {
        return UserListRepository.findById(id).get();
    }

    public List<Role> roleList() {
        return RoleListRepository.findAll();
    }

    public void save(User user) {
        UserListRepository.save(user);
    }
}
