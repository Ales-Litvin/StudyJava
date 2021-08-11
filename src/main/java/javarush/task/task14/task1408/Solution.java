package javarush.task.task14.task1408;

/*
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        System.out.println(hen.getDescription());
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            //напишите тут ваш код
            if ("Russia".equals(country))
                hen = new RussianHen();
            else if ("Ukraine".equals(country))
                hen = new UkrainianHen();
            else if ("Moldova".equals(country))
                hen = new MoldovanHen();
            else
                hen = new BelarusianHen();
            return hen;
        }
    }
}