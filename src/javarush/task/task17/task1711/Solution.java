package javarush.task.task17.task1711;

import java.util.*;
import java.text.*;

/*
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        SimpleDateFormat dateFormatTwo = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        switch (args[0]) {
            case "-c":
                synchronized (allPeople){
                    for (int i = 1; i < args.length; i += 3){

                        if (args[i+1].equals("м"))
                            allPeople.add(Person.createMale(args[i], dateFormatTwo.parse(args[i+2])));

                        if (args[i+1].equals("ж"))
                            allPeople.add(Person.createFemale(args[i], dateFormatTwo.parse(args[i+2])));

                        System.out.println(allPeople.size() - 1);
                    }
                }
                break;
            case "-u":
                synchronized (allPeople){
                    for (int i = 1; i < args.length; i += 4){
                        if (Integer.parseInt(args[i]) >= 0 && Integer.parseInt(args[i]) < allPeople.size()) {

                            if (!args[i+1].isEmpty())
                                allPeople.get(Integer.parseInt(args[i])).setName(args[i+1]);

                            if (args[i+2].equals("м"))
                                allPeople.get(Integer.parseInt(args[i])).setSex(Sex.MALE);
                            else
                                allPeople.get(Integer.parseInt(args[i])).setSex(Sex.FEMALE);

                            allPeople.get(Integer.parseInt(args[i])).setBirthDate(dateFormatTwo.parse(args[i+3]));
                        }
                    }
                }
                break;

            case "-d":
                synchronized (allPeople){
                    for (int i = 1; i < args.length; i++){
                        allPeople.get(Integer.parseInt(args[i])).setName(null);
                        allPeople.get(Integer.parseInt(args[i])).setSex(null);
                        allPeople.get(Integer.parseInt(args[i])).setBirthDate(null);
                    }
                }
                break;

            case "-i":
                synchronized (allPeople){
                    for (int i = 1; i < args.length; i++){
                        int id = Integer.parseInt(args[i]);

                        String sex;

                        if (allPeople.get(id).getSex().equals(Sex.MALE))
                            sex = "м";
                        else sex = "ж";

                        System.out.println(allPeople.get(id).getName() + " " + sex + " " +
                                dateFormat.format(allPeople.get(id).getBirthDate()));
                    }
                }
                break;

            default:
                System.out.println("Ты чёто делаешь не правильно");
        }
    }
}