package javarush.task.task39.task3908;

import org.junit.Assert;
import org.junit.Test;
import net.bytebuddy.utility.RandomString;

public class TestPalindrome {
    public static final int TESTS = 10;
    public static final String[] MAY_BE_PALINDROME = new String[]{
            "tenet",
            "12123",
            "22311",
            "PiWpWoi",
            "PpWiWoi",
            "vnssfjvdvnsdfjv"

    };

    public static boolean oneTest(){
        String random = new RandomString((int) (Math.random() * 20)).nextString();
        return Solution.isPalindromePermutationTwo(random);
    }

    public void testRandom(){
        for (int i = 0; i < TESTS; i++){
            Assert.assertFalse(oneTest());
        }
    }

    @Test
    public void test(){
       for (String s : MAY_BE_PALINDROME){
           Assert.assertTrue(Solution.isPalindromePermutationTwo(s));
       }
    }

    @Test
    public void test2(){
        for (String s : MAY_BE_PALINDROME){
            Assert.assertTrue(Solution.isPalindromePermutation(s));
        }
    }
}
