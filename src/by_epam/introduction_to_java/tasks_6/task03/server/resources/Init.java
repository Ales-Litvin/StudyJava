package by_epam.introduction_to_java.tasks_6.task03.server.resources;


import by_epam.introduction_to_java.tasks_6.task03.server.loader.ObjectLoader;
import by_epam.introduction_to_java.tasks_6.task03.server.entity.user.User;
import by_epam.introduction_to_java.tasks_6.task03.server.entity.user.UserRole;
import by_epam.introduction_to_java.tasks_6.task03.server.utils.Users;

import java.util.ArrayList;
import java.util.List;

public class Init {

    public static List<User> list = new ArrayList<>();

    static {
        list.add(new User("admin", "1234", UserRole.ADMIN));
        list.add(new User("user1", "567", UserRole.ADMIN));
        list.add(new User("user2", "894123", UserRole.ADMIN));
        list.add(new User("user3", "3513241", UserRole.ADMIN));
        list.add(new User("user4", "15341", UserRole.ADMIN));
    }

    public static void main(String[] args) {
        ObjectLoader<Users> loader = new ObjectLoader(
                "./src/by_epam/introduction_to_java/tasks_6/task03/server/resources/",
                Users.class);

        Users users = new Users(list);

        loader.store(users);

        users = loader.load();

        System.out.println(users.getAll());



        /*

        try (FileWriter writer = new FileWriter(
                "./src/by_epam/introduction_to_java/tasks_6/task03/server/resources/role.xml")){

            JAXBContext context = JAXBContext.newInstance(users.getClass());

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(users, writer);

            ConsoleHelper.writeMessage("File has been written.");
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

        */



    }
}
