package by_epam.introduction_to_java.programming_with_classes_4.aggregation_and_composition.task01;

/*
 * Условие задачи:
 * 1. Создать объект класса Текст, используя классы Предложение, Слово.
 * Методы: дополнить текст, вывести на консоль текст, заголовок текста.
 */

public class Solution {
    public static void main(String[] args) {
        Sentence title = new Sentence(new Word("Numbers"));
        Sentence firstSentence = new Sentence(
                new Word[]{new Word("Most"), new Word("individuals"), new Word("don't"), new Word("think"),
                new Word("about"),new Word("numbers"),new Word("but"),new Word("they"),new Word("play"),
                new Word("a"), new Word("major"), new Word("part"),new Word("in"),new Word("everyday"),
                new Word("life")}
        );

        Sentence secondSentence = new Sentence(
                new Word[]{new Word("To"), new Word("be"), new Word("sure,"), new Word("numbers"),
                        new Word("determine"),new Word("the"),new Word("time"),new Word("individuals"),new Word("will"),
                        new Word("wake"), new Word("up"), new Word("in"),new Word("the"),new Word("morning"),
                        new Word("life")}
        );

        Sentence thirdSentence = new Sentence(
                new Word[]{new Word("How"), new Word("much"), new Word("employees"), new Word("numbers"),
                new Word("per"),new Word("hour,"),new Word("what"),new Word("day"),new Word("of"),
                new Word("the"), new Word("year"), new Word("it"),new Word("is,"),new Word("and"),
                new Word("much,"), new Word("much"), new Word("more")});

        // Создаем объект текст
        Text text = new Text(title, new Sentence[]{firstSentence, secondSentence});

        // Дополняем текст
        text.add(thirdSentence);

        // Выводим на консоль текст
        text.printText();

        // Выводим на консоль заголовок текста
        text.printTitle();
    }
}
