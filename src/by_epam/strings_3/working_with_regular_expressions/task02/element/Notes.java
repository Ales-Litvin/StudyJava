package by_epam.strings_3.working_with_regular_expressions.task02.element;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Notes {

    private static Notes instance;

    public static synchronized Notes getInstance(){
        if (instance == null) {
            instance = new Notes();
        }
        return instance;
    }

    private List<Note> notes;

    //private static final Pattern NOTES_PATTERN = Pattern.compile("<notes>(<note id = \"(?<id>\\d)\">(?<body>.+)</note>)+</notes>");

    private static final Pattern NOTES_PATTERN = Pattern.compile("(<note id = \"[0-9]+\">.+</note>)");

    private static void findNotes(String string){
        Matcher matcher = NOTES_PATTERN.matcher(string);

        matcher.find();
        String note = matcher.group(1);
        System.out.println(note);
    }
}
