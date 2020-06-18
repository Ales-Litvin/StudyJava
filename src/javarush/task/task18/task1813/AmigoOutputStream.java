package javarush.task.task18.task1813;

import java.io.*;

/*
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream outputStream;

    public AmigoOutputStream(FileOutputStream outputStream) throws IOException {
        super(fileName);
        this.outputStream = outputStream;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    @Override
    public void close() throws IOException {
        flush();

        byte[] bytes = "JavaRush © All rights reserved.".getBytes();

        outputStream.write(bytes);
        outputStream.close();
    }

    @Override
    public void flush() throws IOException {
        outputStream.flush();
    }

    @Override
    public void write(int b) throws IOException {
        outputStream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        outputStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        outputStream.write(b, off, len);
    }
}