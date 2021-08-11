package by.epam.introduction_to_java.tasks_6.task01.exceptions;

import by.epam.introduction_to_java.tasks_6.task01.entity.user.User;

/**
 * The class {@code Exception} describe situation when user
 * doesn't permission.
 */
public class UserHasNotPermission extends Exception{

    /**
     * Current user.
     */
    private final User user;

    public User getUser() { return user; }

    public UserHasNotPermission(User user) {
        super("You don't have permission for this actions. " +
                "Your level permission '" + user.getRole() + "'." );
        this.user = user;
    }
}
