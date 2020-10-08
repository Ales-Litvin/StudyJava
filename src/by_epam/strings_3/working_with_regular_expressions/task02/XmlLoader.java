package by_epam.strings_3.working_with_regular_expressions.task02;

import java.io.*;

public class XmlLoader {

    private File file;

    public XmlLoader(String string) {
        this.file = new File(string);
    }

    public  String getXml(){

        StringBuilder builder = new StringBuilder();

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){

            String data = null;
            while ((data = reader.readLine()) != null){
                builder.append(data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
