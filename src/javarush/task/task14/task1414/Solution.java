package javarush.task.task14.task1414;

/*
MovieFactory
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws Exception {
        //ввести с консоли несколько ключей (строк), пункт 7
        Set<String> set = new HashSet();
        set.add("cartoon");
        set.add("thriller");
        set.add("soapOpera");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key;
        while (true){
            key = reader.readLine();
            try {
                System.out.println(MovieFactory.getMovie(key).getClass().getSimpleName());
            }
            catch (Exception e) {
                break;
            }
        }


        /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран movie.getClass().getSimpleName()
        */

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }

            //напишите тут ваш код, пункты 5,6

            if ("cartoon".equals(key)) {
                movie = new Cartoon();
            }

            if ("thriller".equals(key)) {
                movie = new Thriller();
            }

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    //Напишите тут ваши классы, пункт 3

    public static class Cartoon extends Movie{

    }

    public static class Thriller extends Movie{

    }
}