package javarush.task.task20.task2022;

/*
Переопределение сериализации в потоке
*/

/*
G:\Programming\Work\Hlam\src\javarush\task\task20\task2022\test.txt
 */

import java.io.*;

public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.initializationStream();
        //in.close();
    }

    private void initializationStream() {
        try {
            this.stream = new FileOutputStream(this.fileName, true);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        String fileName = "G:\\Programming\\Work\\Hlam\\src\\javarush\\task\\task20\\task2022\\test.txt";
        Solution solution = new Solution(fileName);
        solution.writeObject("Записываю данные в созданый объект");
        solution.close();

        //save
        FileOutputStream fileOutput = new FileOutputStream(fileName, true);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
        outputStream.writeObject(solution);

        fileOutput.close();
        outputStream.close();

        //load
        FileInputStream fiStream = new FileInputStream(fileName);
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);
        Solution loadedObject = (Solution) objectStream.readObject();
        fiStream.close();
        objectStream.close();

        loadedObject.writeObject("Записываю в десериализованный объект данные");
        loadedObject.close();
    }
}