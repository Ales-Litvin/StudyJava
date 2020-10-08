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

    private static final Pattern XML_ROOT_PATTERN = Pattern.compile(
            "^<(\\w+)>(.+)</\\1>$"
    );

    public static XmlRoot getRootElement(String data){
        Matcher matcher = XML_ROOT_PATTERN.matcher(data);

        if (matcher.find()) {
            return new XmlRoot(matcher.group(1), matcher.group(2));
        }
        return null;
    }

    private static final Pattern STRANGE_PATTERN_TWO = Pattern.compile(
            //"<(\\w+)(\\s*(?<attributeName>\\w+)\\s*=\\s*[\"'](?<value>\\d+)[\"'])*>(?<text>.+)<\\/\\1>|<\\w+\\/>"
            //"^((?:<(\\w+)(\\s*(?<attributeName>\\w+)\\s*=\\s*[\"'](?<value>\\d+)[\"'])*>(?<text>.+)<\\/\\3>|<\\w+\\/>)*)$"
            //"(?:<(\\w+)(\\s*(?<attributeName>\\w+)\\s*=\\s*[\"'](?<value>\\d+)[\"'])*>(?<text>.+)<\\/\\1>|<\\w+\\/>)"
            //"^((?:<(\\w+)(\\s*(?<attributeName>\\w+)\\s*=\\s*[\"'](?<value>\\d+)[\"'])*>(.+)<\\/\\2>|<\\w+\\/>)*)$"
            "^((?:<(\\w+)(\\s*(?<attributeName>\\w+)\\s*=\\s*[\"'](?<value>\\d+)[\"'])*>(.+)<\\/\\2>|<\\w+\\/>)*)$"
    );

    private static final Pattern STRANGE_PATTERN_Three = Pattern.compile(

    "<(\\w+)(\\s*(?<attributeName>\\w+)\\s*=\\s*[\"'](?<value>\\d+)[\"'])*>(.+)<\\/\\1>|<\\w+\\/>"

            );

    private static final Pattern STRANGE_PATTERN_Four = Pattern.compile(
            "<(\\w+)>(.+)<\\/\\1>|<\\w+\\/>"
    );

    private static final Pattern STRANGE_PATTERN_FIVE = Pattern.compile(
            "<(\\w+)(\\s*(?<attributeName>\\w+)\\s*=\\s*[\"'](?<value>\\d+)[\"'])*>([а-яА-Я0-9_\\s]+)<\\/\\1>|<\\w+\\/>"
    );

    private static final Pattern STRANGE_PATTERN_SIX = Pattern.compile(
            "<(\\w+)(\\s*(?<attributeName>\\w+)\\s*=\\s*[\"'](?<value>\\d+)[\"'])*>([а-яА-Я0-9_\\s]+)<\\/\\1>|<\\w+\\/>"
    );

    private static final Pattern STRANGE_PATTERN_SEVEN = Pattern.compile(
            "(?:<(\\w+)(\\s*(?<attributeName>\\w+)\\s*=\\s*[\"'](?<value>\\d+)[\"'])*>([а-яА-Я0-9_\\s<\\/>]+)<\\/\\1>|<\\w+\\/>)+"
    );

    public static List<String> getStrings(String data){
        Matcher matcher = STRANGE_PATTERN_SEVEN.matcher(data);

        List<String> elements = new ArrayList<>();

        while (matcher.find()){
            System.out.println("=====================");
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            /*System.out.println(matcher.group("attributeName"));
            System.out.println(matcher.group("value"));*/
            System.out.println(matcher.group(2));

            matcher.end();


            elements.add(matcher.group(0));
            elements.add(matcher.group(1));
            /*elements.add(matcher.group("attributeName"));
            elements.add(matcher.group("value"));*/
            elements.add(matcher.group(2));
        }

        return elements;
    }

    public static List<XmlElement> getElements(String data){

        Matcher matcher = STRANGE_PATTERN_TWO.matcher(data);

        List<XmlElement> elements = new ArrayList<>();

        while (matcher.find()){
            XmlElement current = null;
            try {
                current = new XmlElement(
                        matcher.group(2),
                        matcher.group("attributeName"), matcher.group("value"),
                        matcher.group(6));
                elements.add(current);
            } catch (NullPointerException e){
                e.printStackTrace();
            } finally {
                return elements;
            }

        }
        return null;
    }
}
