package by_epam.introduction_to_java.programming_with_classes_4.simplest_classes_and_objects.task08;

/*
 * Условие задачи см. class
 * by_epam.introduction_to_java.programming_with_classes_4.simplest_classes_and_objects.task08.Customer
 */
public class Solution {
    public static void main(String[] args) {
        DataBank dataBank = new DataBank();

        dataBank.add(
                new Customer(
                        123456789,
                        "Ivanov",
                        "Ivan",
                        "Jovanovich",
                        4814671945459848L,
                        123456789
                        ));

        for (int i = 0; i < 10; i++){
            dataBank.add(new Customer((int) Helper.generateRandomNumber(9),
                    Helper.getRandomName(),
                    Helper.getRandomName(),
                    Helper.getRandomName(),
                    Helper.generateRandomNumber(16),
                    Helper.generateRandomNumber(9)));
        }

        // сортируем покупателей в алфавитном порядке
        dataBank.sortBySurname();
        // выводим список
        System.out.println(dataBank.getCustomers());

        System.out.println("=====================");

        // находим и выводим список покупетлей, у которых
        // номер кредитной карточки в заданном интервале

        System.out.println(
                dataBank.getCustomersByNumberCreditCard(
                        3814671945459848L,
                        9814671945459848L
                ));
    }
}
