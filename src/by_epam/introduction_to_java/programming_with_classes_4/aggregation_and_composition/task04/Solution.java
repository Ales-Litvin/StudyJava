package by_epam.introduction_to_java.programming_with_classes_4.aggregation_and_composition.task04;

/*
 * Условие задачи:
 * 4. Счета. Клиент может иметь несколько счетов в банке.
 *      Учитывать возможность блокировки/разблокировки счета.
 *      Реализовать поиск и сортировку счетов.
 *      Вычисление общей суммы по счетам.
 *      Вычисление суммы по всем счетам, имеющим положительный и отрицательный балансы отдельно.
 */

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println("Создем список счетов: ");
        // для генерации имен клиенов и номеров счета используем class Helper
        List<Account> accounts = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            Account account = new Account(
                    new Client(Helper.getRandomName()),
                    Helper.genRandomBigDecimal(6), Helper.generateRandomNumber(9));

            accounts.add(account);
            System.out.println(account);
        }

        System.out.println("Создадим банк: ");
        Bank bank = new Bank(accounts);
        System.out.println(bank);

        System.out.println("Добавим несколько известных счетов: ");
        Account petrov = new Account(new Client("Petrov"), new BigDecimal("100.55"), 123456789L);
        bank.add(petrov);
        Account ivanov = new Account(new Client("Ivanov"), new BigDecimal("150148.55"), 123456799L);
        bank.add(ivanov);
        System.out.println(petrov);
        System.out.println(ivanov);

        System.out.println("Заблокирум счет Иванова: ");
        bank.lockedAccount(123456799);

        System.out.println("Найдем счет по номеру и проверим статус блокировки: ");
        System.out.println(bank.get(123456799));

        System.out.println("Попытка снять сумму со счета: ");
        bank.get(123456799).subtract(new BigDecimal(100000));

        System.out.println("Проверим сумму на счете: ");
        System.out.println(bank.get(123456799));

        System.out.println("Выполним сортировку счетов по фамилии клиента: ");
        bank.sortAccountsByClientName();
        System.out.println(bank);

        System.out.println("Общая сумма по счетам: ");
        System.out.println(bank.getAllSum());

        System.out.println("Общая сумма по счетам имеющий положительный баланс: ");
        System.out.println(bank.getPositiveSum());

        System.out.println("Общая сумма по счетам имеющий отрицательный баланс: ");
        System.out.println(bank.getNegativeSum());
    }
}