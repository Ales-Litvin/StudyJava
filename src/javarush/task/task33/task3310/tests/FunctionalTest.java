package javarush.task.task33.task3310.tests;

import javarush.task.task33.task3310.Shortener;
import javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {

    public static void testStorage(Shortener shortener){
        String s1 = "klsajdfasj2032dsg34sdfg2";
        String s2 = "aslfsdf2sldakjf4s32sfdj3";
        String s3 = "klsajdfasj2032dsg34sdfg2";
        long id1 = shortener.getId(s1);
        long id2 = shortener.getId(s2);
        long id3 = shortener.getId(s3);

        Assert.assertNotEquals(id2, id1);
        Assert.assertNotEquals(id2, id3);

        Assert.assertEquals(id1, id3);

        String string1 = shortener.getString(id1);
        String string2 = shortener.getString(id2);
        String string3 = shortener.getString(id3);

        Assert.assertEquals(s1, string1);
        Assert.assertEquals(s2, string2);
        Assert.assertEquals(s3, string3);
    }

    @Test
    public void testHashMapStorageStrategy(){
        Shortener shortener = new Shortener(new HashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy(){
        Shortener shortener = new Shortener(new OurHashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy(){
        Shortener shortener = new Shortener(new FileStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy(){
        Shortener shortener = new Shortener(new HashBiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy(){
        Shortener shortener = new Shortener(new DualHashBidiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy(){
        Shortener shortener = new Shortener(new OurHashBiMapStorageStrategy());
        testStorage(shortener);
    }
}


