package by.bsu.xmlstudents;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class UnMarshalMain {
    public static void main(String[] args) {
        String file = "src\\" +
                MarshalMain.class.getPackage().getName().replace('.', '\\') +
                "\\studs_marsh.xml";
        try {
            JAXBContext jc = JAXBContext.newInstance(Students.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader(file);
            Students students = (Students) u.unmarshal(reader);
            System.out.println(students);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}