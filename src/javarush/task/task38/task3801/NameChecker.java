package javarush.task.task38.task3801;

public class NameChecker {
    private static final int MAX_NUMBER_OF_CHARACTERS = 100500;

    public static int getNumberOfCharacters(String name) throws Exception {
        if (name == null){
            throw new NameIsEmptyException();
        } else if (name.isEmpty()){
            throw new NameIsNullException();
        }

        int length = name.length();
        if (length > MAX_NUMBER_OF_CHARACTERS) {
            throw new Exception("Слишком длинное имя");
        }
        return length;
    }
}
