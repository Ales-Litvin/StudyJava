package by.epam.introduction_to_java.programming_with_classes_4.aggregation_and_composition.task05;

/*
 * 5. Туристические путевки.
 *    Сформировать набор предложений клиенту по выбору туристической путевки
 *    различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для
 *    оптимального выбора. Учитывать возможность выбора транспорта, питания и
 *    числа дней. Реализовать выбор и сортировку путевок.
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println("Создаем базу данные туристических путевок!");
        Travels travels = new Travels();

        System.out.println("Добваляем пару шутк:");
        Travel one = new Travel("One",
                "description",
                TypeOfTour.CRUISE,
                Transport.SHIP,
                5,
                Food.ALL_INCLUSIVE);

        Travel two = new Travel("Two",
                "description",
                TypeOfTour.THERAPY,
                Transport.BUS,
                14,
                Food.ALL_INCLUSIVE);

        Travel three = new Travel("Three",
                "description",
                TypeOfTour.SHOPPING,
                Transport.BUS,
                1,
                Food.BREAKFAST);

        Travel four = new Travel("Four",
                "description",
                TypeOfTour.REST,
                Transport.PLAIN,
                7,
                Food.LUNCH);

        Travel five = new Travel("Five",
                "description",
                TypeOfTour.THERAPY,
                Transport.PLAIN,
                8,
                Food.ALL_INCLUSIVE);

        Travel six = new Travel("Five",
                "description",
                TypeOfTour.THERAPY,
                Transport.SHIP,
                11,
                Food.ALL_INCLUSIVE);

        travels.add(one);
        travels.add(two);
        travels.add(three);
        travels.add(four);
        travels.add(three);
        travels.add(six);

        System.out.println(travels.toString());

        System.out.print("Создаем путевку для поиска (желание клиента): ");
        Travel clientsDream = new Travel(null,
                null,
                TypeOfTour.THERAPY,
                Transport.BUS,
                10,
                Food.ALL_INCLUSIVE);
        System.out.println(clientsDream);

        System.out.print("Сортируем путевки в соответсвии с пожеланием клената: ");
        travels.sort(clientsDream);
        System.out.println(travels);

        System.out.println("Поиск лучшего совпадения: ");
        System.out.println(travels.getBetter(clientsDream));
    }
}