package javarush.task.task17.task1710.v2;

import javarush.task.task17.task1710.Person;
import javarush.task.task17.task1710.Sex;

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
        //   System.out.println(allPeople); // debug
    }

    public static void main(String[] args) {
        if(args[0].equals("-c")){
            if(args.length == 4){

                String name = args[1];
                String sex = args[2];
                String bd = args[3];

                if (sex.equals("м")){
                    Date birthDate = parseDate(bd);
                    Person p = Person.createMale(name, birthDate);
                    allPeople.add(p);
                    System.out.println(allPeople.indexOf(p));
                }
                else if (sex.equals("ж")){
                    Date birthDate = parseDate(bd);
                    Person p = Person.createFemale(name, birthDate);
                    allPeople.add(p);
                    System.out.println(allPeople.indexOf(p));
                }
                else
                    System.out.println("Некорректный ввод");
            }
            else
                System.out.println("Некорректный ввод");
        }
        else if(args[0].equals("-u")){
            if(args.length == 5){

                try {
                    Integer id = Integer.parseInt(args[1]);
                    String name = args[2];
                    String  sex = args[3];
                    String  bd = args[4];
                    Date birthDate = parseDate(bd);
                    if (id >= 0 && id < allPeople.size()){
                        if (sex.equals("м")){
                            allPeople.get(id).setSex(Sex.MALE);
                            allPeople.get(id).setName(name);
                            allPeople.get(id).setBirthDate(birthDate);
                        }

                        else if (sex.equals("ж")){
                            allPeople.get(id).setSex(Sex.FEMALE);
                            allPeople.get(id).setName(name);
                            allPeople.get(id).setBirthDate(birthDate);
                        }
                        else
                            System.out.println("Некорректный ввод");

                    }
                    else
                        System.out.println("Некорректный ввод id");


                } catch (NumberFormatException e) {
                    System.out.println("Некорректный ввод id");
                }

            }

            else if(args.length == 6){

                String lastName = null;
                String name = null;
                String sex = null;
                String bd = null;
                try {
                    Integer id = Integer.parseInt(args[1]);
                    name = args[2];
                    lastName = args[3];
                    name += " ";
                    name += lastName;
                    sex = args[4];
                    bd = args[5];
                    Date birthDate = parseDate(bd);
                    if (id > 0 && id < allPeople.size()){
                        if (sex.equals("м")){
                            allPeople.get(id).setSex(Sex.MALE);
                            allPeople.get(id).setName(name);
                            allPeople.get(id).setBirthDate(birthDate);
                        }

                        else if (sex.equals("ж")){
                            allPeople.get(id).setSex(Sex.FEMALE);
                            allPeople.get(id).setName(name);
                            allPeople.get(id).setBirthDate(birthDate);
                        }
                        else
                            System.out.println("Некорректный ввод");

                    }
                    else
                        System.out.println("Некорректный ввод id");


                } catch (NumberFormatException e) {
                    System.out.println("Некорректный ввод id");
                }

            }
            else
                System.out.println("Некорректный ввод");

        }
        else if(args[0].equals("-d")){
            if(args.length == 2){
                try {
                    Integer id = Integer.parseInt(args[1]);
                    if (id > 0 && id < allPeople.size()){
                        Person nullPerson = allPeople.get(id);
                        nullPerson.setBirthDate(null);
                        nullPerson.setName(null);
                        nullPerson.setSex(null);
                        allPeople.set(id,nullPerson);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Некорректный ввод id");
                }
            }
            else
                System.out.println("Некорректный ввод");

        }
        else if(args[0].equals("-i")){
            if(args.length == 2){
                try {
                    Integer id = Integer.parseInt(args[1]);
                    if (id > 0 && id < allPeople.size()){
                        Person person = allPeople.get(id);
                        SimpleDateFormat outDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                        String date = outDateFormat.format(person.getBirthDate());
                        String sex;
                        if (person.getSex() == Sex.MALE)
                            sex = "м";
                        else
                            sex = "ж";
                        System.out.println(person.getName() + " " + sex + " " + date);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Некорректный ввод id");
                }
            }
            else
                System.out.println("Некорректный ввод");

        }
        else
            System.out.println("Некорректный ввод");

        //    System.out.println(allPeople); // debug
    }

    private static Date parseDate(String date){
        if(date.isEmpty())
            return null;
        SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
        String str = date;

        Date parsingDate = null;
        //  System.out.println(parsingDate); // debug
        try {
            parsingDate = ft.parse(str);
        }catch (ParseException e) {
            System.out.println("Ошибка " + ft);
        }

        return parsingDate;
    }
}