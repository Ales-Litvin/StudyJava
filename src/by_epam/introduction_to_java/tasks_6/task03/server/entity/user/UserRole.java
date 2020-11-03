package by_epam.introduction_to_java.tasks_6.task03.server.entity.user;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlEnum
public enum UserRole {
    USER,
    ADMIN;
}
