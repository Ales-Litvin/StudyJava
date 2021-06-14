package by.bsu.xmlstudents;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class JacksonReaderMain {
    public static void main(String[] args) {
        String file = "src\\" +
                MarshalMain.class.getPackage().getName().replace('.', '\\') +
                "\\studs_jackson.json";

        try {
            ObjectMapper mapper = new ObjectMapper();

            Students students = mapper.readValue(new FileInputStream(file), Students.class);
            System.out.println(students);
        } catch (JsonParseException | JsonMappingException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // Do not sample work
            e.printStackTrace();
        }
    }
}
