package javarush.task.task31.task3111;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();
    private boolean isPartOfName = true;
    private boolean isPartOfContent = true;
    private boolean isMinSize = true;
    private boolean isMaxSize = true;

    public void setPartOfName(String partOfName){ this.partOfName = partOfName; }

    public void setPartOfContent(String partOfContent){ this.partOfContent = partOfContent; }

    public void setMinSize(int minSize){ this.minSize = minSize; }

    public void setMaxSize(int maxSize){ this.maxSize = maxSize; }

    public List<Path> getFoundFiles(){ return foundFiles; }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        String data = new String(content);
        if (partOfName != null)
            isPartOfName = file.getFileName().toString().contains(partOfName);
        if (partOfContent != null)
            isPartOfContent = data.contains(partOfContent);
        if (maxSize != 0)
            isMinSize = content.length < maxSize;
        if (minSize != 0)
            isMaxSize = content.length > minSize;
        if (isPartOfName & isPartOfContent & isMinSize & isMaxSize)  foundFiles.add(file);
        return super.visitFile(file, attrs);
    }
}