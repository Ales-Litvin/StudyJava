package by.epam.learn.multithread;

import java.util.concurrent.TimeUnit;

public class SynchroFirstMain {
    public static void main(String[] args) {
        String file = "src\\" +
                SynchroFirstMain.class.getPackage().getName().replace('.', '\\') +
                "\\thread.txt";

        try (CommonResource resource = new CommonResource(file)){
            UseFileThread first = new UseFileThread("First", resource);
            UseFileThread second = new UseFileThread("Second", resource);

            first.start();
            second.start();

            TimeUnit.SECONDS.sleep(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("end of main");
    }
}
