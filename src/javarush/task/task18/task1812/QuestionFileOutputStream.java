package javarush.task.task18.task1812;

/*
Расширяем AmigoOutputStream
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream component;

    public QuestionFileOutputStream (AmigoOutputStream amigoOutputStream){
        this.component = amigoOutputStream;
    }



    @Override
    public void flush() throws IOException {
        component.flush();
    }

    @Override
    public void write(int b) throws IOException {
        component.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        component.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        component.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Вы действительно хотите закрыть поток? Д/Н");
        String string = reader.readLine();
        if (string.equals("Д"))
            component.close();
    }
}
