package by_epam.strings_3.working_with_regular_expressions.task02.parser;

/*
 * Условие задачи:
 * 2. Дана строка, содержающая следующий текст (xml-документ):

<notes>
    <note id = "1">
        <to>Вася</to>
        <from>Света</from>
        <heading>Напоминание</heading>
        <body>Позвони мне завтра</body>
    </note>
    <note id = "2">
        <to>Петя</to>
        <from>Маша</from>
        <heading>Важное напоминание</heading>
        <body/>
    </note>
</notes>

 * Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа и его тип
 * (открывающий тег, закрывающий тег, содержимое тега, тег без тела).
 * Пользоваться готовыми парсерами XML для решения данной задачи нельзя.
 */

import by_epam.strings_3.working_with_regular_expressions.task02.XmlElement;
import by_epam.strings_3.working_with_regular_expressions.task02.XmlLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        XmlLoader xmlLoader = new XmlLoader("E:\\Library\\Books\\Study\\src\\by_epam\\strings_3\\working_with_regular_expressions\\task02\\text.xml");

        String string = xmlLoader.getXml();

    /*
        System.out.println(getAttribute(string));
        System.out.println(getTagName(string));
        System.out.println(getInnerTag(string));
    */

        //getElement(string);

        String test = "<note id = \"1\">" +
                "        <to>Вася</to>" +
                "        <from>Света</from>" +
                "        <heading>Напоминание</heading>" +
                "        <body>Позвони мне завтра</body>" +
                "    </note>" +
                "    <note id = \"2\">" +
                "        <to>Петя</to>" +
                "        <from>Маша</from>" +
                "        <heading>Важное напоминание</heading>" +
                "        <body/>" +
                "    </note>";


        getElements(test);


    }

    private static final Pattern XML_PATTERN = Pattern.compile(
            "(<(\\w+)(\\s*(?<attributeName>\\w+)\\s*=\\s*[\"'](?<value>\\d+)[\"'])*>)(?<text>.+)(</\\2>)"
    );

    private static final Pattern XML_PATTERN2 = Pattern.compile(
            "<((\\w+)(\\s*(?<attributeName>\\w+)\\s*=\\s*[\"'](?<value>\\d+)[\"'])*)>(?<text>.+)(</\\2>)"
    );

    public static XmlElement getRootElement(String data){
        Matcher matcher = XML_PATTERN.matcher(data);

        List<XmlElement> elements = new ArrayList<>();

        if (matcher.find()) {
            XmlElement current = new XmlElement(
                    matcher.group(2),
                    matcher.group("attributeName"), matcher.group("value"),
                    matcher.group("text"));
            return current;
        }
        return null;
    }

    public static List<XmlElement> getElements(String data){
        // if (data.matches("\\w+")) return null;

        Matcher matcher = XML_PATTERN2.matcher(data);

        List<XmlElement> elements = new ArrayList<>();

        while (matcher.find()){
            XmlElement current = new XmlElement(
                    matcher.group(2),
                    matcher.group("attributeName"), matcher.group("value"),
                    matcher.group("text"));

            elements.add(current);
        }

        System.out.println(elements);

        if (elements.isEmpty()) {
            return null;
        } else {
            return elements;
        }
    }

    public static String getTagName(String data){
        Matcher matcher = XML_PATTERN.matcher(data);
        matcher.find();
        return matcher.group(0);
    }

    public static String getAttributeName(String data){
        Matcher matcher = XML_PATTERN.matcher(data);
        matcher.find();
        return matcher.group(5);
    }

    public static String getAttribute(String data){
        Matcher matcher = XML_PATTERN.matcher(data);
        matcher.find();
        return matcher.group(6);
    }

    public static List<String> getInnerTag(String data){
        Matcher matcher = XML_PATTERN.matcher(data);

        List<String> list = new ArrayList<>();

        while (matcher.find()){
            list.add(matcher.group(7));
        }
        return list;
    }
}
