package by.epam.introduction_to_java.tasks_6.task03.server.utils;

import by.epam.introduction_to_java.tasks_6.task03.entity.user.User;
import by.epam.introduction_to_java.tasks_6.task03.server.loader.ObjectLoader;

import javax.xml.bind.annotation.*;
import java.util.*;

/**
 * Data base users.
 * Class is 'Singleton'. It uses data from xml file,
 * and writes data to xml file if element {@code User} added.
 *
 * @see User
 * @see ObjectLoader
 *
 * @author Aliaksandr Rachko
 * @version 1.0
 */
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users{

    @XmlElementWrapper(name = "userList")
    @XmlElement(name = "user")
    private final List<User> users;

    @XmlTransient
    private static volatile Users instance;

    public static Users getInstance(){
        Users localInstance = instance;
        if (localInstance == null) {
            synchronized (Users.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = loader.load();
                }
            }
        }
        return localInstance;
    }

    @XmlTransient
    private static final ObjectLoader<Users> loader = new ObjectLoader<>(
            "./src/by_epam/introduction_to_java/tasks_6/task03/server/resources/",
            Users.class);

    private Users() { this.users = new ArrayList<>(); }

    /**
     * Returns the user by {@code name} and {@code password} if it exists.
     * @param name user's name
     * @param password user's password
     * @return the user by {@code name} and {@code password} if it exists,
     *         or {@code null} if user with giving {@code name} and {@code password}
     *         doesn't exist.
     */
    public synchronized User get(String name, String password){
        for (User user : users) {
            if (user.getName().equals(name) &&
                    user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }

    /**
     * Adds new the User in the list of users if it doesn't contain its.
     * @param user the user for adding.
     * @return <tt>true</tt> if this collection changed as a result of the
      *        call
     */
    public synchronized boolean add(User user){
        if (!users.contains(user)){
            users.add(user);
            loader.store(instance);
            return true;
        }
        return false;
    }

    /**
     * Returns all users.
     */
    public synchronized List<User> getAll() {
        return users;
    }
}