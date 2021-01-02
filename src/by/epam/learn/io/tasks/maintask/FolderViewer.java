package by.epam.learn.io.tasks.maintask;

import by.epam.learn.io.tasks.maintask.entity.Element;
import by.epam.learn.io.tasks.maintask.view.View;
import by.epam.learn.io.tasks.maintask.view.ViewToFile;

import java.io.File;
import java.util.Objects;

public class FolderViewer {
    private File fileName;

    private final View view;

    public FolderViewer(File fileName){
        this.fileName = fileName;
        this.view = new ViewToFile(fileName);
    }

    public File getFileName() { return fileName; }

    public void setFileName(File fileName) { this.fileName = fileName; }

    public void mainProcess(){
        if (fileName.isFile()){
            ConsoleHelper.writeMessage(ElementParser.getInfo(view.read(fileName.toString())));
        } else {
            Element rootElement = getRootElement(fileName);
            view.show(rootElement.toString());
        }
    }

    public Element getRootElement(File file){
        if (file.isFile()){
            return new Element(file, null);
        }

        Element result = new Element(file);

        for (File f : Objects.requireNonNull(file.listFiles())){
            result.addElement(getRootElement(f));
        }

        return result;
    }
}
