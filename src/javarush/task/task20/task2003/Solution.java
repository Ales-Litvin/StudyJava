package javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/*
Знакомство с properties
*/

/*
G:\Programming\Work\Hlam\src\javarush\task\task20\task2003\config.properties
 */

public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = bufferedReader.readLine();
            bufferedReader.close();
            FileInputStream fileInputStream = new FileInputStream(fileName);
            load(fileInputStream);
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public void save(OutputStream outputStream) throws IOException {
        //implement this method - реализуйте этот метод
        Properties newProperties = new Properties();

        for (Map.Entry<String, String> pair : properties.entrySet()){
            newProperties.put(pair.getKey(), pair.getValue());
        }
            newProperties.store(outputStream, "new");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties thisProperties = new Properties();
        thisProperties.load(inputStream);
        Set<String> set = thisProperties.stringPropertyNames();

        for (String string : set){
            properties.put(string, thisProperties.getProperty(string));
        }
    }

    public static void main(String[] args) {

    }
}