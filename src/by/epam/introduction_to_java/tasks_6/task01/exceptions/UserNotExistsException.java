package by.epam.introduction_to_java.tasks_6.task01.exceptions;

import by.epam.introduction_to_java.tasks_6.task01.entity.user.User;

/**
 * The class {@code Exception} describe situation when user
 * don't exists in the data base.
 */
public class UserNotExistsException extends Exception{

    /**
     * Doesn't exist user.
     */
    private User user;

    public User getUser() { return user; }

    public UserNotExistsException(User user) {
        super(String.format(
                "User with name '%s' and this password does not exist.",
                user.getUserName()));

        this.user = user;
    }
}