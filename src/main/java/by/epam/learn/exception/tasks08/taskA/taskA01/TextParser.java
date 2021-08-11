package by.epam.learn.exception.tasks08.taskA.taskA01;

import javax.xml.xpath.XPath;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {
    private static final Pattern PATTERN_LETTER = Pattern.compile("[eyuioaEYUIOAйеыаоэяиюЙУЕЫАОЭЯЮ]\\w+");
    private static final Pattern PATTERN_STRANGE = Pattern.compile("I");

    public static Set<String> getWordStartsWithVowel(String path){
        Set<String> set = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))){
            String data = null;
            while ((data = reader.readLine()) != null){
                Matcher matcher = PATTERN_LETTER.matcher(data);
                while (matcher.find()){
                    set.add(matcher.group(0));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return set;
    }

    public static void changeUpperToLoweLetter(String pathToFile) throws FileNotFoundException {
        File path = new File(pathToFile);
        if (!path.exists() && !path.isFile()){ throw new FileNotFoundException(); }

        try (BufferedReader reader = Files.newBufferedReader(path.toPath())){
            Path temp = getTempFile(new File(path.getParent()));

            try (BufferedWriter writer = Files.newBufferedWriter(temp)){
                String data;
                while ((data = reader.readLine()) != null){
                    writer.write(data.toLowerCase() + "\n");
                    writer.flush();
                }
            }

            path.delete();
            // need replace temp file to real file
            temp.toFile().renameTo(path);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Path getTempFile(File path) throws IOException {
        Path temp = Files.createTempFile(path.toPath(), null, null);
        return temp;
    }
}
