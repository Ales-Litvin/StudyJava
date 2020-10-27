/*
 * Copyright (c) 2020, Rachko and/or its affiliates. All rights reserved.
 * RACHKO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package by_epam.introduction_to_java.tasks_6.task01.entity;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Base64;
import java.util.Objects;

/**
 * The UserAccount class is the user of the application.
 */
public class User implements Externalizable {
    private String userName;
    private String password;
    private String email;

    /**
     * User's role.
     */
    private String role;

    public User(String userName, String password, String eMail, String role) {
        this.userName = userName;
        this.password = password;
        this.email = eMail;
        this.role = role;
    }

    public User() { }

    // getter and setters
    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getUserName(), user.getUserName()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getRole(), user.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getEmail(), getRole());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserAccount{");
        sb.append("userName='").append(userName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", role='").append(role).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getUserName());
        out.writeObject(this.encryptString(this.getPassword()));
        out.writeObject(this.getEmail());
        out.writeObject(this.getRole());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        userName = (String) in.readObject();
        password = this.decryptString((String) in.readObject());
        email = (String) in.readObject();
        role = (String) in.readObject();
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
