package by.epam.learn.io.tasks.maintask.view;

import java.io.*;

public class ViewToFile extends AbstractView {

    public ViewToFile(File file) {
        super(file);
    }

    /**
     * Print the string to file
     * @param string the string to be showing
     */
    @Override
    public void show(String string){
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(getFileName()))){
            writer.write(string);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String read(String fileName){
        StringBuilder sb = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            sb = new StringBuilder();
            String data = null;
            while ((data = reader.readLine()) != null){
                sb.append(data).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb != null ? sb.toString() : "null";
    }
}