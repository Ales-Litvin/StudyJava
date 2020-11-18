package javarush.task.task39.task3908;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @Test
    public void test(){
        for (String s : MAY_BE_PALINDROME){
            Assert.assertTrue(Solution.isPalindromePermutation(s));
        }
    }

    @Test
    public void testRandom(){
        for (int i = 0; i < TESTS; i++){
            String palindrome = getPalindrome();
            System.out.printf("Palindrome<%s> ",palindrome);
            palindrome = shelfString(palindrome);
            System.out.printf("-> <%s>", palindrome);
            boolean result = Solution.isPalindromePermutation(palindrome);
            System.out.printf(" '%s'\n", result);
            Assert.assertTrue(result);
        }
    }

    @Test
    public void testRandomThree(){
        for (int i = 0; i < TESTS; i++){
            String palindrome = getPalindrome();
            System.out.printf("Palindrome<%s> ",palindrome);
            palindrome = shelfString(palindrome);
            System.out.printf("-> <%s>", palindrome);
            boolean result = Solution.isPalindromePermutationThree(palindrome);
            System.out.printf(" '%s'\n", result);
            Assert.assertTrue(result);
        }
    }

    public static String getRandomPalindrome(){
        return null;
    }

    public static String generateRandomString(){
        return new BigInteger(130, new SecureRandom()).toString(36);
    }

    public static String getPalindrome(){
        String s1 = generateRandomString();
        String s2 = new StringBuilder(s1).reverse().toString();

        StringBuilder palindrome = new StringBuilder(s1);

        if (Math.random() * 1 == 1){
            palindrome.append(new Character((char) (Math.random() * 256)));
        }
        palindrome.append(s2);
        return palindrome.toString();
    }

    public static String shelfString(String string){
        List<Character> chars = new ArrayList<>(string.length());

        for (char c : string.toCharArray()){
            chars.add(c);
        }

        Collections.shuffle(chars);

        char[] copy = new char[chars.size()];

        for (int i = 0; i < copy.length; i++) {
            copy[i] = chars.get(i);
        }

        return String.valueOf(copy);
    }

}
