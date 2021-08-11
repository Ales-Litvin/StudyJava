package learn.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Except {

    public void main() throws Throwable {
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                reader.readLine();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } finally {
            throw new Throwable();
        }
    }

    public void cloneArray(){
        int[] array = new int[]{1, 22, 4, 5,34,43};
        int[] array2 = array.clone();

        Arrays.copyOf(array, array.length);
    }
}
