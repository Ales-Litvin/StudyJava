package javarush.task.task24.task2407;

/*
 * В классе Cat реализуй логику метода toSayable, которая описана в джавадоке.
 */

import java.util.List;

/*
Реализация интерфейса используя локальный класс
*/

public class Solution {
    public static void main(String[] args) {
        List<Pet> pet = Util.getPets();
        List<Sayable> pets = Util.convertPetToSayable(pet);
        Util.printDialog(pets);
    }
}