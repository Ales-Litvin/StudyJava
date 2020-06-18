package javarush.task.task19.task1904;

/*
И еще один адаптер
*/

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() {

                String[] args = fileScanner.nextLine().split(" ");
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
                try {
                    Date birthDate = dateFormat.parse(String.format("%s %s %s",
                            args[3], args[4], args[5]));

                    Person person = new Person(args[1], args[2], args[0], birthDate);
                    return person;
                }
                catch (ParseException e){
                    e.printStackTrace();
                    return null;
                }
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}