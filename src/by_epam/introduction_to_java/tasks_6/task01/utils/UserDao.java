/*
 * Copyright (c) 2020, Rachko and/or its affiliates. All rights reserved.
 * RACHKO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package by_epam.introduction_to_java.tasks_6.task01.utils;

import by_epam.introduction_to_java.tasks_6.task01.entity.User;

import java.util.*;

/**
 * Implements interface DAO.
 */
public class UserDao implements Dao<User>{

    private Map<String, User> users = new HashMap<>();

    public UserDao() {

    }

    public User findUser(String userName, String password){
        User user = users.get(userName);
        if (user != null && user.getPassword().equals(password)){
            return user;
        }
        return null;
    }

    @Override
    public Optional<User> get(String userName) {

        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void save(User user) {
        users.put(user.getUserName(), user);
    }

    @Override
    public void delete(User user) {
        users.remove(user);
    }

}
