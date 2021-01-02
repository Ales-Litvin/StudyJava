package by.epam.learn.io.tasks.maintask;

import java.io.File;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String path = "src\\" +
                Main.class.getName().replace(".", "\\");

        File pathToFolder = Paths.get(path).getParent().toFile();

        FolderViewer viewer = new FolderViewer(pathToFolder);
        viewer.mainProcess();

        pathToFolder = new File(pathToFolder.toString() + "\\maintask_structure.txt");

        viewer.setFileName(pathToFolder);
        viewer.mainProcess();
    }
}
