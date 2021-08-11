package javarush.task.task20.lesson20.lessons2006;

/*
Java core 10 уровень лекция 6
 */

import java.io.*;

class Cat implements Externalizable {
    public String name;
    public int age;
    public int weight;

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
        out.writeInt(weight);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = in.readInt();
        weight = in.readInt();
    }
}