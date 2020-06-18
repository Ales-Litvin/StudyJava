package javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException {
        System.out.println(new Solution(4));
        String fileName = "G:\\Programming\\Work\\Hlam\\src\\javarush\\task\\task20\\task2014\\test.txt";

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));

        Solution savedObject = new Solution(25);
        objectOutputStream.writeObject(savedObject);
        objectOutputStream.flush();


        Solution loadedObject = new Solution(-30);

        try {
            loadedObject = (Solution) objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(savedObject.toString());
        System.out.println(loadedObject.toString());


    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}