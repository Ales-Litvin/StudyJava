package by.epam.introduction_to_java.programming_with_classes_4.aggregation_and_composition.task01;

/*
 * Условие задачи:
 * 1. Создать объект класса Текст, используя классы Предложение, Слово.
 * Методы: дополнить текст, вывести на консоль текст, заголовок текста.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Text {
    private Sentence title;
    private List<Sentence> sentences;

    public Text(Sentence title, List<Sentence> sentences) {
        this.title = title;
        this.sentences = sentences;
    }

    public Text(Sentence title, Sentence[] sentences) {
        this.title = title;
        this.sentences = new ArrayList<>();
        this.sentences.addAll(Arrays.asList(sentences));
    }

    public void add(Sentence sentence){ sentences.add(sentence); }

    public void add(int index, Sentence sentence){ sentences.add(sentence); }

    // getters and setters
    public List<Sentence> getSentences() { return sentences; }

    public void setSentences(List<Sentence> sentences) { this.sentences = sentences; }

    public Sentence getTitle() { return title; }

    public void setTitle(Sentence title) { this.title = title; }

    public String titleToString(){ return title.toString(); }

    public String sentencesToString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentences.size(); i++){
            if (i == 0) {
                sb.append(sentences.get(i));
            } else {
                sb.append(" ").append(sentences.get(i));
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return titleToString() + '\n' + "\t" + sentencesToString();
    }

    public void printText(){
        System.out.println('\t' + sentencesToString());
    }

    public void printTitle(){
        System.out.println('\t' + titleToString());
    }
}
