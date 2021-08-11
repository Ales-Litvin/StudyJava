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

package by.epam.introduction_to_java.tasks_6.task01.utils;


import by.epam.introduction_to_java.tasks_6.task01.entity.user.User;
import by.epam.introduction_to_java.tasks_6.task01.entity.user.UserRole;
import by.epam.introduction_to_java.tasks_6.task01.loader.DataLoader;

import java.util.*;

/**
 * Implements interface DAO.
 * @author Aliaksandr Rachko
 * @version 1.0
 */
public class UserDao implements Dao<User>{
    private DataLoader<User> loader;

    private final Map<String, User> users;

    public UserDao(DataLoader<User> loader) {
        this.loader = loader;
        this.users = new HashMap<>(getMap());
    }

    /**
     * Convert List to Map.
     */
    private Map<String, User> getMap(){
        Map<String, User> result = new HashMap<>();
        for (User user : loader.getList()){
            result.put(user.getUserName(), user);
        }
        return result;
    }

    public void setLoader(DataLoader<User> loader) { this.loader = loader; }

    public User findUser(String userName, String password){
        User user = users.get(userName);
        if (user != null && user.getPassword().equals(password)){
            return user;
        }
        return null;
    }


    /**
     * Returns list of emails address all admin
     */
    public List<String> getAdminsEmails(){
        List<String> result = new ArrayList<>();
        for (User user : new ArrayList<>(users.values())){
            if (user.getRole() == UserRole.ADMIN) {
                result.add(user.getEmail());
            }
        }
        return result;
    }

    /**
     * Returns list of emails address all users.
     */
    public List<String> getUsersEmails(){
        List<String> result = new ArrayList<>();
        for (User user : new ArrayList<>(users.values())){
            result.add(user.getEmail());
        }
        return result;
    }


    @Override
    public List<User> getAll() {
        return new ArrayList<User>(users.values());
    }

    @Override
    public void save(User user) {
        users.put(user.getUserName(), user);
        loader.store(new ArrayList<>(users.values()));
    }

    @Override
    public void delete(User user) {
        if (users.remove(user) != null) {
            loader.store(new ArrayList<>(users.values()));
        }
    }
}