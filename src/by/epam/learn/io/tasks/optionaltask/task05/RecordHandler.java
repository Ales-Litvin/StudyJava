package by.epam.learn.io.tasks.optionaltask.task05;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RecordHandler {
    private RecordHandler() {
    }

    private static final int LIMIT_GRADE = 7;

    private static final Pattern RECORD_PATTERN =
            Pattern.compile("((?<name>[a-zA-Zа-яА-я]+):)*\\s*((?<grade>\\d+)[,;])+");

    /**
     * Returns a string, modifier it's if this need.
     *
     * @param str a string in format: [name]: n<sub>1</sub>, n<sub>2</sub>, ..., n<sub>n</sub>;
     * @return a modified string
     */
    public static String getModifyString(String str) {
        Matcher matcher = RECORD_PATTERN.matcher(str);

        List<Integer> numbers = new ArrayList<>();
        while (matcher.find()) {
            numbers.add(Integer.parseInt(matcher.group("grade")));
        }

        if (getAverageNumber(numbers) > LIMIT_GRADE){
            return str.toUpperCase();
        }
        return str;
    }

    private static int getAverageNumber(List<Integer> grades) {
        if (grades == null || grades.isEmpty()) return 0;
        int sum = 0;
        for (int i : grades){
            sum += i;
        }
        return sum / grades.size();
    }
}