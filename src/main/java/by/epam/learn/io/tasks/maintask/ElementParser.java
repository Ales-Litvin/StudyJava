package by.epam.learn.io.tasks.maintask;

import by.epam.learn.io.tasks.maintask.entity.Element;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ElementParser {
    private ElementParser() { }

    private static final Pattern ONE_LINE_PATTERN =
            Pattern.compile("(\\|\\s{3})*([\\/\\+]---(?<name>.+))");

    /**
     * Example a tree of elements:
     * <pre>+---tasks</pre>
     * <pre>|   +---maintask</pre>
     * <pre>|   |   /---ConsoleHelper.java</pre>
     * <pre>|   |   +---entity</pre>
     * <pre>|   |   |   /---Element.java</pre>
     * <pre>|   |   /---FolderViewer.java</pre>
     * <pre>|   |   /---Main.java</pre>
     * <pre>|   |   /---maintask_structure.txt</pre>
     * <pre>|   |   /---README.txt</pre>
     * <pre>|   |   +---view</pre>
     * <pre>|   |   |   /---AbstractView.java</pre>
     * <pre>|   |   |   /---View.java</pre>
     * <pre>|   |   |   /---ViewToFile.java</pre>
     * <pre>|   +---optionaltask</pre>
     * <pre>|   /---tasks_structure.txt</pre>
     * @return the root element
     */
    @Deprecated
    public Element getRootElement(String string){
        //doesn't implement
        return null;
    }

    public static String getInfo(String data){
        StringBuilder sb = new StringBuilder();
        sb.append("Info:\n");
        int folders = countOfChars(data, '+', 0);
        sb.append("Count of folder: ").append(folders).append(";\n");
        int files = countOfChars(data, '/', 0);
        sb.append("Count of files: ").append(files).append(";\n");
        int averageCount = folders != 0 ? files / folders : 0;
        sb.append("Average count of files in folder: ").append(averageCount).append(";\n");
        return sb.toString();
    }

    private boolean isFile(String s){
        return s.contains("/");
    }

    private boolean isDirectory(String s){
        return s.contains("+");
    }

    private String getName(String s){
        Matcher matcher = ONE_LINE_PATTERN.matcher(s);
        return matcher.group("name");
    }

    private int getLevel(String s){
        int level = 0;
        int index = 0;
        while ((index = s.indexOf('|', index)) >= 0){
            level++;
        }
        return level;
    }

    private static int countOfChars(
            String someString, char searchedChar, int index) {
        if (index >= someString.length()) {
            return 0;
        }

        int count = someString.charAt(index) == searchedChar ? 1 : 0;
        return count + countOfChars(
                someString, searchedChar, index + 1);
    }
}
