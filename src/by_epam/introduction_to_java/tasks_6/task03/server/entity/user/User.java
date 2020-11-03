package by_epam.introduction_to_java.tasks_6.task03.server.entity.user;

import javax.xml.bind.annotation.*;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Base64;
import java.util.Objects;

/**
 * The UserAccount class is the user of the application.
 */
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"password", "role"})
public class User implements Externalizable {

    @XmlAttribute(name = "name")
    private String name;

    private String password;

    /**
     * User's role.
     */
    private UserRole role;

    public User(String name, String password, UserRole role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public User() { }

    // getter and setters
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public UserRole getRole() { return role; }

    public void setRole(UserRole role) { this.role = role; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getName(), user.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getName());
        out.writeObject(this.encryptString(this.getPassword()));
        out.writeObject(this.getRole());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = (String) in.readObject();
        this.password = this.decryptString((String) in.readObject());
        this.role = (UserRole) in.readObject();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("name='").append(name).append('\'');
        sb.append(", role=").append(role);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Returns encodes string.
     */
    private String encryptString(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    /**
     * Returns decodes string.
     */
    private String decryptString(String data) {
        return new String(Base64.getDecoder().decode(data));
    }
}