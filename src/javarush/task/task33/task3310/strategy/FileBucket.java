package javarush.task.task33.task3310.strategy;

import java.nio.file.Files;
import java.io.*;
import java.nio.file.Path;

public class FileBucket {
    Path path;

    public FileBucket(){
        try {
            this.path = Files.createTempFile(null, null);
            Files.deleteIfExists(path);
            Files.createFile(path);
            path.toFile().deleteOnExit();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public long getFileSize(){
        try {
            return Files.size(path);
        } catch (IOException e){
            e.printStackTrace();
        }
        return 0L;
    }

    public void putEntry(Entry entry){
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path))) {
            out.writeObject(entry);
            out.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public Entry getEntry(){
        Entry entry = null;
        if (getFileSize() > 0)
            try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path))) {
                entry = (Entry) in.readObject();
            } catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        return entry;
    }

    public void remove (){
        try {
            Files.delete(path);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}