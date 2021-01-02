package by.epam.introduction_to_java.strings_3.working_with_regular_expressions.task01;

/*
 * Условие задачи:
 * 1.  Создать приложение, разбирающее текст (текст  хранится  в  строке)
 *     и позволяющее выполнять с текстом три различных операции:
 *     отсортировать абзацы по количеству предложений;
 *     в каждом предложении отсортировать  слова по длине;
 *     отсортировать лексемы в предложении по убыванию количества
 *     вхождений заданного  символа, а в случае равенства – по алфавиту.
 */

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static final String STRING_ONE =
            "Hi, Friend! It's been a while since we have been in touch. How has your day?";

    public static final String STRING_TWO =
            "Monday is viewed by many to be the worst day of the week, as it marks the return to work " +
                    "following the weekend, when most full-time employees are given two days off. " +
                    "Most students attend school in the morning and return home in the afternoon " +
                    " and most workers go to work in the morning and return home in the evening.\n" +
                    "Tuesday is the second day of the week, and is in many ways similar to Monday. " +
                    "Not a whole lot changes, schedule-wise, between Tuesday and Monday. " +
                    "Most individuals go to school or work and return home to watch television, " +
                    "play video games, make plans with friends, spend time with family, read, " +
                    "or engage in a similar leisure-related activity.\n"+
                    "Wednesday is the third day of the week, and serves as the middle of the work week. " +
                    "Some individuals refer to Wednesday as hump day, as once its workday is complete," +
                    " employees will have passed the work-week hump, and will be on the downturn, " +
                    "as only two days on the job will remain in the week.\n" +
                    "Thursday is the fourth day of the week, and is viewed favorably by many, " +
                    "as it's rather close to the end of the work week.\n" +
                    "Friday is the fifth day of the week, " +
                    "and marks the end of the workweek for the vast majority of employees and students. " +
                    "By Friday evening, most workers cannot wait to leave and go home, " +
                    "as they won't have to report back to work until Monday.";


    public static void main(String[] args) {

        System.out.println(sortStringBySizeParagraphs(STRING_TWO));
        System.out.println("======================================");
        System.out.println(sortWordsOfTextByLength(STRING_TWO));
        System.out.println("======================================");
        System.out.println(sortWordsOfTextByCountSymbolsInWord(STRING_TWO, 'i'));

    }

    /**
     * Sorts the string by count of sentences in a paragraphs
     * (сортирует текст представленный объектом String, по количеству предложений в абзаце)
     * @param string a string with text
     * @return the string sorted by count of sentences in a paragraphs
     */
    public static String sortStringBySizeParagraphs(String string){
        List<String> paragraphs = getParagraphs(string);

        paragraphs.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return getSentencesInParagraphs(o1).size() - getSentencesInParagraphs(o2).size();
            }
        });

        StringBuilder builder = new StringBuilder();
        for (String s : paragraphs){ builder.append(s); }

        return builder.toString();
    }

    /**
     * Sorts words in sentences by length
     * (сортируе в каждом предложении слова по длине).
     * @param string string a string with text
     * @return the string with sorted sentences by length words
     */
    public static String sortWordsOfTextByLength(String string){
        List<String> paragraphs = getParagraphs(string);

        StringBuilder builder = new StringBuilder();

        for (String s : paragraphs){
            List<String> sentences = getSentencesInParagraphs(s);

            for (String s1 : sentences){
                builder.append(sortWordInSentenceByLength(s1));
            }
        }

        return builder.toString();
    }

    /**
     * Sorts words in sentences by count of char
     * (сортирует слова в предложении по количеству вхождения заданного символа,
     * а в случае равенства - по алфовиту).
     * @param string string a string with text
     * @param c a symbol
     * @return the string with sorted sentences by count of symbol
     */
    public static String sortWordsOfTextByCountSymbolsInWord(String string, char c){
        List<String> paragraphs = getParagraphs(string);

        StringBuilder builder = new StringBuilder();

        for (String s : paragraphs){
            List<String> sentences = getSentencesInParagraphs(s);

            for (String s1 : sentences){
                builder.append(sortWordInSentenceByCountSymbols(s1, c));
            }
        }

        return builder.toString();
    }

    private static final Pattern PARAGRAPHS_PATTERN = Pattern.compile("(\\t*.+\\n+)");

    /**
     * Splits this string on the paragraphs.
     * @param string a string with a paragraphs.
     * @return the array of strings computed by splitting this string on the paragraphs.
     */
    public static List<String> getParagraphs(String string){
        List<String> result = new ArrayList<>();

        Matcher matcher = PARAGRAPHS_PATTERN.matcher(string);
        while (matcher.find()){
            result.add(matcher.group(1));
        }
        return result;
    }

    private static final Pattern SENTENCES_PATTERN = Pattern.compile("([^\\.!?]+[\\.!?])");

    /**
     * Splits this string on the sentences.
     * @param string a string with a sentences.
     * @return the array of strings computed by splitting this string on the sentences.
     */
    public static List<String> getSentencesInParagraphs(String string){
        List<String> result = new ArrayList<>();

        Matcher matcher = SENTENCES_PATTERN.matcher(string);
        while (matcher.find()){
            result.add(matcher.group(1));
        }
        return result;
    }

    private static final Pattern WORD_PATTERN = Pattern.compile("(\\w+'*\\w+)");

    /**
     * Sorts words in the sentence by length of words
     * @param string the string (sentence)
     * @return the string (sentence) sorted by length of word
     */
    public static String sortWordInSentenceByLength(String string){
        List<String> listWords = new ArrayList<>();

        Matcher matcher = WORD_PATTERN.matcher(string);
        while (matcher.find()){
            listWords.add(matcher.group(1));
        }

        listWords.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < listWords.size(); i++){
            builder.append(" ");
            if (i == 0){
                builder.append(firstUpperCase(listWords.get(i)));
            } else {
                builder.append(listWords.get(i).toLowerCase());
            }
        }

        return builder.toString() + getFinishSymbol(string);
    }

    public static String sortWordInSentenceByCountSymbols(String string, char c){
        List<String> listWords = new ArrayList<>();

        Matcher matcher = WORD_PATTERN.matcher(string);
        while (matcher.find()){
            listWords.add(matcher.group(1));
        }

        listWords.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (getChars(o1, c) > getChars(o2, c)) return 1;
                if (getChars(o1, c) == getChars(o2, c)) return o1.compareToIgnoreCase(o2);
                return -1;
            }
        });

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < listWords.size(); i++){
            builder.append(" ");
            if (i == 0){
                builder.append(firstUpperCase(listWords.get(i)));
            } else {
                builder.append(listWords.get(i).toLowerCase());
            }
        }

        return builder.toString() + getFinishSymbol(string);
    }

    /**
     * Returns count of a given symbol in the word
     * @param string a string (word)
     * @param c a given character
     * @return count of a given symbol in the word
     */
    public static int getChars(String string, char c){
        int count = 0;
        int fromIndex = 0;
        while ((fromIndex = string.indexOf(c, fromIndex) + 1) > 0){
            count++;
        }
        return count;
    }

    private static final Pattern FINISH_WORD_PATTER = Pattern.compile("(\\.\\n*)");

    /**
     * Returns finish symbol (example : '.', '!', '?', '\n')
     * @param string a string
     * @return the string with finish symbol
     */
    private static String getFinishSymbol(String string){
        Matcher endMatcher = FINISH_WORD_PATTER.matcher(string);
        endMatcher.find();
        return endMatcher.group(1);
    }

    /**
     * Makes first letter in the word upper case
     * @param word a string (word)
     * @return a word with first upper case
     */
    public static String firstUpperCase(String word){
        if(word == null || word.isEmpty()) return ""; //или return word;
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}
