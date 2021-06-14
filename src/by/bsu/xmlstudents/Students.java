package by.bsu.xmlstudents;

import com.fasterxml.jackson.annotation.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Students {

    @JsonProperty("students")
    @XmlElement(name = "student")
    private List<Student> list = new ArrayList<>();

    public Students() { super(); }

    public void setList(List<Student> list) { this.list = list; }

    public boolean add(Student st) { return list.add(st); }

    @Override
    public String toString() {
        return "Students[list=" + list + "]";
    }
}