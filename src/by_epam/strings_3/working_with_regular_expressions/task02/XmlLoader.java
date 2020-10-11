package by_epam.strings_3.working_with_regular_expressions.task02;

import java.io.*;

public class XmlLoader {

    private File file;

    public XmlLoader(String string) {
        this.file = new File(string);
    }

    /**
     * Returns a string with the content of the file
     * @return a string with the content of the file
     */
    public  String getStringXml(){

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

    public File getFile() { return file; }

    public void setFile(File file) { this.file = file; }
}
