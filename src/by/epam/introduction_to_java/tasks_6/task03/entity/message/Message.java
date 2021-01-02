package by.epam.introduction_to_java.tasks_6.task03.entity.message;

import by.epam.introduction_to_java.tasks_6.task03.entity.user.User;

import java.io.Serializable;

public class Message implements Serializable {
    private final User user;
    private final MessageType type;
    private final Object data;

    public Message(User user, MessageType type) {
        this.user = user;
        this.type = type;
        this.data = null;
    }

    public Message(User user, MessageType type, Object data) {
        this.user = user;
        this.type = type;
        this.data = data;
    }

    //getters

    public User getUser() { return user; }

    public MessageType getType() {
        return type;
    }

    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Message{");
        sb.append(user).append(": ");
        sb.append(type).append(", ");
        sb.append(data).append('}');
        return sb.toString();
    }
}
