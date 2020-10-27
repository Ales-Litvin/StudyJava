package by_epam.introduction_to_java.tasks_6.task01.config;

import java.util.*;

/**
 * Helps configuring roles and function of users.
 */
public class SecurityConfig {
    public static final String USER = "USER";
    public static final String ADMINISTRATOR = "ADMINISTRATOR";

    // String: Role
    // List<String>: urlPatterns.
    private static final Map<String, List<String>> mapConfig =
            new HashMap<String, List<String>>();

    static {
        init();
    }

    private static void init() {

        // Конфигурация для роли "USER".
        List<String> patterns1 = new ArrayList<String>();

        patterns1.add("/userInfo");
        patterns1.add("/employeeTask");

        mapConfig.put(USER, patterns1);

        // Конфигурация для роли "ADMINISTRATOR".
        List<String> patterns2 = new ArrayList<String>();

        patterns2.add("/userInfo");
        patterns2.add("/managerTask");

        mapConfig.put(ADMINISTRATOR, patterns2);
    }

    public static Set<String> getAllRoles() {
        return mapConfig.keySet();
    }

    public static List<String> getPatternsForRole(String role) {
        return mapConfig.get(role);
    }
}