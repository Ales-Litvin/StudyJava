package javarush.task.task33.task3310;

import javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 10000);
        System.out.println("==========================");
        testStrategy(new OurHashMapStorageStrategy(), 10000);
        System.out.println("==========================");
        testStrategy(new FileStorageStrategy(), 100);
        System.out.println("==========================");
        testStrategy(new OurHashBiMapStorageStrategy(), 10000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> ids = new HashSet<>();
        for (String string : strings){
            ids.add(shortener.getId(string));
        }
        return ids;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> strings = new HashSet<>();
        for (Long l : keys){
            strings.add(shortener.getString(l));
        }
        return strings;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        System.out.println(strategy.getClass().getSimpleName());
        Set<String> testStrings = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++){
            testStrings.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);

        Date date1 = new Date();
        Set<Long> returnIds = getIds(shortener, testStrings);
        Helper.printMessage(String.valueOf(new Date().getTime() - date1.getTime()));

        date1 = new Date();
        Set<String> returnStrings = getStrings(shortener, returnIds);
        Helper.printMessage(String.valueOf(new Date().getTime() - date1.getTime()));

        if (testStrings.equals(returnStrings)){
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }

    }
}
