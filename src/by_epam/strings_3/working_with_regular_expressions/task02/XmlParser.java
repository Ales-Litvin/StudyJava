package by_epam.strings_3.working_with_regular_expressions.task02;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlParser {

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

    private static final Pattern XML_ROOT_PATTERN = Pattern.compile(
            "<(\\w+)>(.+)</\\1>"
    );

    private static final Pattern XML_PATTERN = Pattern.compile(
            "<(\\w+)(\\s*(?<attributeName>\\w+)\\s*=\\s*[\"'](?<value>\\d+)[\"'])>(?<text>.+)</\\1"
    );

    /*
    private static final Pattern STRANGE_PATTERN = Pattern.compile(
            "^(" +
                    "(?:<(\\w++) [^>]*+ (?<!/)>(?1)</\\2>" + // соответствует парным тегам
                    "|[^<>]++" + // текст вне тегов
                    "| <\\w+[^>]*+/>" + // самозакрывающиеся теги
                    "| <!\u0002\u0002.*?\u0002\u0002>" + // комментарии
                    "| <!\\[CDATA\\[.*?]]>" + // блоки cdata
                    "| <\\?.*?\\?>" + // инструкции обработки
                    "| <![A\u0002Z].*?>" + // объявления сущностей и пр.
                    ")*" +
                    ")$"
    );
     */

    private static final Pattern STRANGE_PATTERN_TWO = Pattern.compile(
            "<(\\w+)(\\s*(?<attributeName>\\w+)\\s*=\\s*[\"'](?<value>\\d+)[\"'])*>(?<text>.+)<\\/\\1>|<\\w+\\/>"
    );





    public static XmlRoot getRootElement(String data){
        Matcher matcher = XML_PATTERN.matcher(data);

        if (matcher.find()) {

            return new XmlRoot(matcher.group(1), matcher.group("text"));
        }
        return null;
    }

    public static List<XmlElement> getElements(String data){

        Matcher matcher = STRANGE_PATTERN_TWO.matcher(data);

        List<XmlElement> elements = new ArrayList<>();

        while (matcher.find()){
            XmlElement current = new XmlElement(
                    matcher.group(1),
                    matcher.group("attributeName"), matcher.group("value"),
                    matcher.group("text"));

            elements.add(current);
        }

        if (elements.isEmpty()) {
            return null;
        } else {
            return elements;
        }
    }

    public static String getTagName(String data){
        Matcher matcher = XML_ROOT_PATTERN.matcher(data);
        matcher.find();
        return matcher.group(0);
    }

    public static String getAttributeName(String data){
        Matcher matcher = XML_ROOT_PATTERN.matcher(data);
        matcher.find();
        return matcher.group(5);
    }

    public static String getAttribute(String data){
        Matcher matcher = XML_ROOT_PATTERN.matcher(data);
        matcher.find();
        return matcher.group(6);
    }

    public static List<String> getInnerTag(String data){
        Matcher matcher = XML_ROOT_PATTERN.matcher(data);

        List<String> list = new ArrayList<>();

        while (matcher.find()){
            list.add(matcher.group(7));
        }
        return list;
    }
}
