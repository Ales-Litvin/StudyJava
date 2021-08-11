package javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
Транзакционность   G:\Test.txt  G:\Test2.txt
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFileOne = reader.readLine();
        String nameFileTwo = reader.readLine();
        reader.close();

        BufferedReader bufferedReaderOne = new BufferedReader(new InputStreamReader(new FileInputStream(nameFileOne)));
        BufferedReader bufferedReaderTwo = new BufferedReader(new InputStreamReader(new FileInputStream(nameFileTwo)));

        String read;

        while ((read = bufferedReaderOne.readLine()) != null){
            allLines.add(read);
        }
        bufferedReaderOne.close();

        while ((read = bufferedReaderTwo.readLine()) != null){
            forRemoveLines.add(read);
        }
        bufferedReaderTwo.close();

        Solution solution = new Solution();
        try {
            solution.joinData();
        }
        catch (CorruptedDataException e){
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {

        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        }
        else{
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}