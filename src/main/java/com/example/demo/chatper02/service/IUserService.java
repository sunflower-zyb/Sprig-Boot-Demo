package com.example.demo.chatper02.service;

import com.example.demo.chatper02.domain.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();

    User findByUserName(String userName);

    User findById(Long id);

    void edit(User user);

    void delete(Long id);

    void save(User user);

}
