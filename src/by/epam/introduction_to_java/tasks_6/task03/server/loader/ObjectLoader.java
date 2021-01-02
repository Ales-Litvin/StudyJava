package by.epam.introduction_to_java.tasks_6.task03.server.loader;

import by.epam.introduction_to_java.tasks_6.task03.ConsoleHelper;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Class for loading objects from XML.
 */
public class ObjectLoader<T> {
    private String pathToFile;
    private final Class<T>[] types;

    /**
     *
     * @param name
     * @param types
     */
    public ObjectLoader(String name, Class<T>... types) {
        this.pathToFile =
                name + '/' + types[0].getSimpleName().toLowerCase() + ".xml";
        this.types = types;
    }

    public String getPathToFile() {
        return this.pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public T load() {
        T t = null;

        try (FileReader reader = new FileReader(this.pathToFile)){

                JAXBContext context = JAXBContext.newInstance(this.types);
                Unmarshaller unmarshaller = context.createUnmarshaller();

                t = (T) unmarshaller.unmarshal(reader);

        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

        return t;
    }

    public void store(T t) {
        try (FileWriter writer = new FileWriter(this.pathToFile)){

            JAXBContext context = JAXBContext.newInstance(this.types);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(
                    Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            marshaller.marshal(t, writer);

            ConsoleHelper.writeMessage("File has been written.");

        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

    }
}
