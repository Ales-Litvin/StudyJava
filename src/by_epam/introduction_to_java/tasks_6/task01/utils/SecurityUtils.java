package by_epam.introduction_to_java.tasks_6.task01.utils;

import by_epam.introduction_to_java.tasks_6.task01.config.SecurityConfig;
import by_epam.introduction_to_java.tasks_6.task01.entity.User;

import java.util.List;
import java.util.Set;

/**
 * The SecurityUtils class is a utility class,
 * it has methods to help check whether a request obliges a login or not,
 * and whether that request is suitable with the role of a logged in user or not.
 */
public class SecurityUtils {

    // Проверить имеет ли данный 'user' подходящую роль?
    public static boolean hasPermission(User user) {

        Set<String> allRoles = SecurityConfig.getAllRoles();

        for (String role : allRoles) {
            /*
            if (!request.isUserInRole(role)) {
                continue;
            }
            */

            List<String> patterns = SecurityConfig.getPatternsForRole(role);
            /*
            if (patterns != null && patterns.contains(urlPattern)) {
                return true;
            }
            */
        }
        return false;
    }
}
