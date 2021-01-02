package by.epam.learn.io.tasks.maintask.view;

import java.io.*;

public abstract class AbstractView implements View{
    protected final File file;

    protected AbstractView(File file) {
        this.file = file;
    }

    protected String getFileName(){
        return this.file + "\\" + (this.file.getName() + "_structure.txt");
    }
}
