package by_epam.introduction_to_java.tasks_6.task03.server.utils;

import by_epam.introduction_to_java.tasks_6.task03.server.entity.user.User;

import javax.xml.bind.annotation.*;
import java.util.*;

/**
 * Data base Users.
 * @author Aliaksandr Rachko
 * @version 1.0
 */
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users{

    @XmlElementWrapper(name = "userList")
    @XmlElement(name = "user")
    private final List<User> users;

    public Users() {
        this.users = new ArrayList<>();
    }

    public Users(List<User> users) {
        this.users = users;
    }

    /**
     * Returns the user by {@code name} and {@code password} if it exists.
     * @param name user's name
     * @param password user's password
     * @return the user by {@code name} and {@code password} if it exists,
     *         or {@code null} if user with giving {@code name} and {@code password}
     *         doesn't exist.
     */
    public User get(String name, String password){
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
    public boolean add(User user){
        if (!users.contains(user)){
            return users.add(user);
        }
        return false;
    }

    /**
     * Returns all users.
     */
    public List<User> getAll() {
        return users;
    }
}