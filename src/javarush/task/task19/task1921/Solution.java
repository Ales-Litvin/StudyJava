package javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
Хуан Хуанович
*/

/*
G:\Test6.txt
 */

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd M yyyy", Locale.ENGLISH);


        String data;
        while ((data = bufferedReader.readLine()) != null){
            String[] stringName = data.split(" \\d+ \\d+ \\d+$");
            String[] stringDate = data.split("^(\\D+ )+");
            Date birthDate = dateFormat.parse(stringDate[1]);
            PEOPLE.add(new Person(stringName[0], birthDate));
        }
        bufferedReader.close();
    }
}