package by_epam.introduction_to_java.tasks_6.task03.server.utils;


import by_epam.introduction_to_java.tasks_6.task03.entity.user.User;
import by_epam.introduction_to_java.tasks_6.task03.entity.user.UserRole;

/**
 * Util class for checking permission.
 */
public class SecurityUtils {

    /**
     * Checks user's permission.
     */
    public static boolean hasPermission(User user, UserRole requiredRole){
        return user.getRole() == requiredRole;
    }
}
