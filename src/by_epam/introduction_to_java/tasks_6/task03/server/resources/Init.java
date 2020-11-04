package by_epam.introduction_to_java.tasks_6.task03.server.resources;


import by_epam.introduction_to_java.tasks_6.task03.server.entity.Dossier;
import by_epam.introduction_to_java.tasks_6.task03.server.loader.ObjectLoader;
import by_epam.introduction_to_java.tasks_6.task03.server.entity.user.User;
import by_epam.introduction_to_java.tasks_6.task03.server.entity.user.UserRole;
import by_epam.introduction_to_java.tasks_6.task03.server.utils.Dossiers;
import by_epam.introduction_to_java.tasks_6.task03.server.utils.Users;

import java.util.ArrayList;
import java.util.List;

/*
 * Just class for init data base
 */
// Needs delete this class, before finish.
public class Init {

    public static List<User> list = new ArrayList<>();

    public static List<Dossier> list1 = new ArrayList<>();

    static {
        list.add(new User("admin", "1234", UserRole.ADMIN));
        list.add(new User("user1", "567", UserRole.USER));
        list.add(new User("user2", "894123", UserRole.USER));
        list.add(new User("user3", "3513241", UserRole.USER));
        list.add(new User("user4", "15341", UserRole.USER));

        list1.add(new Dossier("Jon", "Billi", "Jon's life history", 1));
    }

    public static void main(String[] args) {

        Users users = Users.getInstance();

        System.out.println(users.getAll());

        Dossiers dossiers = new Dossiers();
        dossiers.add(new Dossier("Jon", "Billi", "Jon's life history", 1));



    }
}
