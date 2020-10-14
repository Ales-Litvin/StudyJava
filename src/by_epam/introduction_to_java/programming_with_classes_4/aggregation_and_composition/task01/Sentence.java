package by_epam.introduction_to_java.programming_with_classes_4.aggregation_and_composition.task01;

/*
 * Условие задачи см. class
 * by_epam.introduction_to_java.programming_with_classes_4.aggregation_and_composition.task01.Text;
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sentence {
    public List<Word> words;

    public Sentence(List<Word> words) { this.words = words; }

    public Sentence(Word[] word){
        this.words = new ArrayList<>();
        this.words.addAll(Arrays.asList(word));
    }

    public Sentence(Word word){
        this.words = new ArrayList<>();
        words.add(word);
    }

    public void add(Word word){ words.add(word); }

    public void add(int index, Word word){ words.add(index, word); }

    // getter
    public List<Word> getWords() { return words; }

    // setter
    public void setWords(List<Word> words) { this.words = words; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.size(); i++){
            if (i == 0) {
                sb.append(words.get(i).firstUpperCase());
            } else {
                sb.append(" ").append(words.get(i));
            }
        }
        sb.append(".");

        return sb.toString();
    }
}