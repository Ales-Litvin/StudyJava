package javarush.task.task20.lesson20.lesson2008;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Username\\Desktop\\save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);


        UserInfo userInfo = new UserInfo("Ivan", "Ivanov", "Ivan Ivanov's passport data");

        objectOutputStream.writeObject(userInfo);

        objectOutputStream.close();

    }
}