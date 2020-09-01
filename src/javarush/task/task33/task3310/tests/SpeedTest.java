package javarush.task.task33.task3310.tests;

import javarush.task.task33.task3310.Helper;
import javarush.task.task33.task3310.Shortener;
import javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {

    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids){
        Date date1 = new Date();
        for (String string : strings){
            ids.add(shortener.getId(string));
        }
        return new Date().getTime() - date1.getTime();
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        Date date1 = new Date();
        for (Long l : ids){
            strings.add(shortener.getString(l));
        }
        return new Date().getTime() - date1.getTime();
    }

    @Test
    public void testHashMapStorage(){
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        Set<String> origStrings = new HashSet<>();

        for (int i = 0; i < 10000; i++){
            origStrings.add(Helper.generateRandomString());
        }

        Set<Long> origIds = new HashSet<>();

        long time1 = getTimeToGetIds(shortener1, origStrings, origIds);
        long time2 = getTimeToGetIds(shortener2, origStrings, origIds);

        Assert.assertTrue(time1 > time2);

        time1 = getTimeToGetStrings(shortener1, origIds, origStrings);
        time2 = getTimeToGetStrings(shortener2, origIds, origStrings);

        Assert.assertEquals(time1, time2, 30);

    }
}
