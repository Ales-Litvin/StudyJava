package by_epam.learn.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
}
