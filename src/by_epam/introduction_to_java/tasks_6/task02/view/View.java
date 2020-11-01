package by_epam.introduction_to_java.tasks_6.task02.view;

import by_epam.introduction_to_java.tasks_6.task02.entity.Note;
import by_epam.introduction_to_java.tasks_6.task02.exception.IncorrectDataException;
import by_epam.introduction_to_java.tasks_6.task02.utils.NoteDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class View {
    private final NoteDao noteDao;

    public View(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    /**
     * Prints all actions this program.
     */
    public void printAllCommand(){
        writeMessage(
                "======================================\n" +
                "Choose an action: \n" +
                "-------------------------------------\n" +
                "1 - print all command\n" +
                "2 - add note\n" +
                "3 - get all notes\n" +
                "4 - get notes by 'Subject'\n" +
                "5 - get notes by 'Date'\n" +
                "6 - get notes by 'Subject' and 'Date'\n" +
                "7 - get notes by 'E-mail'\n" +
                "8 - get notes by 'Content'\n" +
                "0 - exit\n" +
                "======================================\n\n\n");
    }

    public void action() {
        writeMessage("Enters number of action and press 'enter'... ");

        printAllCommand();

        String string;
        while (!(string = readString()).equals("0")){
            switch (string){
                case "1": printAllCommand();
                    break;
                case "2": add();
                    break;
                case "3": print(noteDao.getAllNotes());
                    break;
                case "4":
                    try {
                        print(noteDao.getNotes(inputData("Subject")));
                    } catch (IncorrectDataException e) {
                        e.printStackTrace();
                    }
                    break;
                case "5":
                    try {
                        print(noteDao.getNotesByDate(inputData("Date (yyyy-mm-dd)")));
                    } catch (IncorrectDataException e) {
                        e.printStackTrace();
                    }
                    break;
                case "6":
                    try {
                        print(noteDao.getNotesBySubjectAndDate(
                                inputData("Subject"),
                                inputData("Date (yyyy-mm-dd")));
                    } catch (IncorrectDataException e) {
                        e.printStackTrace();
                    }
                    break;
                case "7":
                    try {
                        print(noteDao.getNotesByEmail(inputData("E-mail")));
                    } catch (IncorrectDataException e) {
                        e.printStackTrace();
                    }
                    break;
                case "8":
                    try {
                        print(noteDao.getNotesByContent(inputData("Content")));
                    } catch (IncorrectDataException e) {
                        e.printStackTrace();
                    }
                    break;
                default :writeMessage("'" + string + "'" + " is not a command!");
                    break;
            }
        }

        noteDao.save();

        writeMessage("Bye!");
    }

    /**
     * Adds note.
     */
    public void add(){
        writeMessage("Inputs note's 'Subject' and press 'enter'...");
        String subject = readString();

        writeMessage("Inputs 'E-mail' and press 'enter'...");
        String email = readString();

        writeMessage("Inputs note's 'Content' and press 'enter'...");
        String content = readString();

        try {
            noteDao.add(subject, email, content);
            writeMessage("Note adds!");
        } catch (IncorrectDataException e) {
            e.printStackTrace();
            writeMessage("Note doesn't add!");
        }
    }

    /**
     * Prints tree set.
     */
    private void print(List<Note> notes) {
        if (notes == null || notes.isEmpty()) throw new NullPointerException();

        writeMessage(
                "============================================================\n" +
                "Notes:\n" +
                "------------------------------------------------------------");
        for (Note note : notes){
            writeMessage(
                    String.format(
                            "%1$td %1$tB %1$tY %1$tR <%2$s>\n" +
                            "%3$-40s\n" +
                             "%4$-60s\n",
                            note.getDate(),
                            note.getEmail(),
                            note.getSubject(),
                            note.getContent()) +
                            ". . . . . . . . . . . . . . . . . . . ");
        }
        writeMessage(
                "============================================================");
    }


    /**
     * Returns inputs data.
     */
    public String inputData(String type){
        writeMessage("Inputs note's '" + type + "' and press 'enter'...");
        return readString();
    }

    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Writes message to console.
     */
    public static void writeMessage(String message) {
        System.out.println(message);
    }

    /**
     * Reads message with console.
     */
    public static String readString() {
        String text = null;
        try {
            text = READER.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    /**
     * Reads number with console.
     */
    public static int readInt() {
        String text = readString();
        try {
            return Integer.parseInt(text.trim());
        } catch (NumberFormatException e){
            writeMessage("The '" + text + "' is not number. Try again late.");
            return 0;
        }
    }
}