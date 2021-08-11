package javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

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
                if (args[2].equals("м"))
                    allPeople.add(Person.createMale(args[1], dateFormatTwo.parse(args[3])));

                if (args[2].equals("ж"))
                    allPeople.add(Person.createFemale(args[1], dateFormatTwo.parse(args[3])));

                System.out.println(allPeople.size() - 1);

                break;
            case "-u":
                if (Integer.parseInt(args[1]) >= 0 && Integer.parseInt(args[1]) < allPeople.size()) {

                    allPeople.get(Integer.parseInt(args[1])).setName(args[2]);

                    if (args[3].equals("м"))
                        allPeople.get(Integer.parseInt(args[1])).setSex(Sex.MALE);
                    else
                        allPeople.get(Integer.parseInt(args[3])).setSex(Sex.FEMALE);

                    if (args[4].isEmpty())
                        allPeople.get(Integer.parseInt(args[1])).setBirthDate(dateFormatTwo.parse(null));
                    else
                    allPeople.get(Integer.parseInt(args[1])).setBirthDate(dateFormatTwo.parse(args[4]));

                }

                break;

            case "-d":
                allPeople.get(Integer.parseInt(args[1])).setName(null);
                allPeople.get(Integer.parseInt(args[1])).setSex(null);
                allPeople.get(Integer.parseInt(args[1])).setBirthDate(null);
                break;

            case "-i":
                int id = Integer.parseInt(args[1]);

                String sex;

                if (allPeople.get(id).getSex().equals(Sex.MALE))
                    sex = "м";
                else sex = "ж";

                System.out.println(allPeople.get(id).getName() + " " + sex + " " +
                        dateFormat.format(allPeople.get(id).getBirthDate()));

                break;

            default:
                System.out.println("Ты чёто делаешь не правильно");
        }
    }
}