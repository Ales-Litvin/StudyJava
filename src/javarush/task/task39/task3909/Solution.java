package javarush.task.task39.task3909;

/*
Одно измерение
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println(isOneEditAway(
                "vna  ;dljd  lksjdf",
                "vna;dljd  lksjdf"
        ) + " : false");

        System.out.println(isOneEditAway("dddddd", "dd  dddd") + " : false");
        System.out.println(isOneEditAway("123", "1023")  + " : true");
        System.out.println(isOneEditAway("01", "12")  + " : true");
        System.out.println(isOneEditAway("123", "1453")  + " : true");
        System.out.println(isOneEditAway("01", "102")  + " : false");
        System.out.println(isOneEditAway("dddddd", " dddddd")  + " : true");
        System.out.println(isOneEditAway("123", "1453") + " : true");
        System.out.println(isOneEditAway("2", "33") + " : false");

    }

    // Это все не работает
    // разделить на 2 случая строки одинаковой длинны и строки разной длинны
    //
    public static boolean isOneEditAway(String first, String second){
        char[] charsOne = first.toCharArray();
        char[] charsTwo = second.toCharArray();

        int countChanges = 0;

        int i = 0, j = 0;

        while (i < charsOne.length && j < charsTwo.length) {
            if (charsOne[i] == charsTwo[j]){
                i++; j++;
            } else if (charsOne[i] != charsTwo[j]){

                if (charsOne.length > i + 1 && charsOne[i + 1] == charsTwo[j]) {
                    i++;
                } else if (charsTwo.length > j + 1 && charsOne[i] == charsTwo[j + 1]){
                    j++;
                } else if (i != 0 && charsOne[i - 1] == charsTwo[j]){
                    i++;
                } else if (j != 0 && charsOne[i] == charsTwo[j - 1]){
                    j++;
                }

                countChanges++;
                i++; j++;
            }
        }


        if (i != j) return false;

        return countChanges == 1 || countChanges == 0;
    }
}
