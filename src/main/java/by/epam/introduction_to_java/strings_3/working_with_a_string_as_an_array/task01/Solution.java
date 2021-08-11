package by.epam.introduction_to_java.strings_3.working_with_a_string_as_an_array.task01;

/*
 * Условие задачи:
 * 1. Дан массив названий переменных в camelCase.
 *    Преобразовать названия в snake_case.
 */

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String[] strings = {"camelCase",
                            "writtenLikeThis",
                            "camelBack"};

        renameCamelToSnakeCase(strings);

        System.out.println(Arrays.toString(strings));
    }

    /**
     * This method rename array of strings from cameCase style to snake_case style
     * @param strings array of strings for rename
     */
    public static void renameCamelToSnakeCase(String[] strings){
        for (int i = 0; i < strings.length; i++){
            strings[i] = renameCamelToSnakeCase(strings[i]);
        }
    }

    /**
     * This method rename passed string from cameCase style to snake_case style
     * @param strings string for rename
     * @return a renamed string
     */
    public static String renameCamelToSnakeCase(String strings){
        char[] chars = strings.toCharArray();

        StringBuilder builder = new StringBuilder();

        for (char c : chars) {
            if (Character.isUpperCase(c)) {
                builder.append("_");
            }
            builder.append(Character.toLowerCase(c));
        }
        return builder.toString();
    }
}
