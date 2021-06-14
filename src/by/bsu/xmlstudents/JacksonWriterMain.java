package by.bsu.xmlstudents;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class JacksonWriterMain {
    public static void main(String[] args) {
        String file = "src\\" +
                MarshalMain.class.getPackage().getName().replace('.', '\\') +
                "\\studs_jackson.json";

        try {
            ObjectMapper mapper = new ObjectMapper();

            Students st = new Students() { // анонимный класс
                {
                    // добавление первого студента
                    Student.Address addr = new Student.Address("BLR", "Minsk", "Skoriny 4");
                    Student s = new Student("gochette", "Klimenko", "mmf", 2095306, addr);
                    this.add(s);
                    // добавление второго студента
                    addr = new Student.Address("BLR", "Polotesk", "Simeona P. 23");
                    s = new Student("ivette", "Teran", "mmf", 2345386, addr);
                    this.add(s);
                }
            };

            mapper.writeValue(new FileOutputStream(file), st);
        } catch (JsonGenerationException |
                JsonMappingException |
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // Do not sample work
            System.err.println(e);
        }
    }
}
