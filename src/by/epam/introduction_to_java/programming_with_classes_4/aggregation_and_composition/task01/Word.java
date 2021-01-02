package by.epam.introduction_to_java.programming_with_classes_4.aggregation_and_composition.task01;

public class Word {
    private String word;

    public Word(String word) { this.word = word; }

    // getter
    public String getWord() { return word; }

    // setter
    public void setWord(String word) { this.word = word; }

    /**
     * Does first letter to upper case
     */
    public String firstUpperCase(){
        if(word == null || word.isEmpty()) return "";
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    @Override
    public String toString() {
        return word;
    }
}
