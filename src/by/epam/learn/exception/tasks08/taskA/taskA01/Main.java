package by.epam.learn.exception.tasks08.taskA.taskA01;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "src/" + TextParser.class.getPackage().getName().replace('.', '/') + "\\test_file.txt";
        Path pathToFile = Paths.get(path);
        System.out.println("Is file exist?: " + pathToFile.toFile().exists());

        Set<String> wordStartWithVowel = TextParser.getWordStartsWithVowel(path);
        System.out.println(wordStartWithVowel);

        TextParser.changeUpperToLoweLetter(path);
    }
}
