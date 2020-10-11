package by_epam.strings_3.working_with_regular_expressions.task02.Hlam.element;

import by_epam.strings_3.working_with_regular_expressions.task02.XmlLoader;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Note {



    public static void main(String[] args) {
        XmlLoader xmlLoader = new XmlLoader("E:\\Library\\Books\\Study\\src\\by_epam\\strings_3\\working_with_regular_expressions\\task02\\text.xml");

        String string = xmlLoader.getStringXml();

        System.out.println(getId(string));
    }

    private int id;

    private Map<ArgumentNote, String> map;


    private static final Pattern NOTE_PATTER = Pattern.compile("<note id = \"(?<id>\\d+)\">" +
            "<(/<tagName>)></></note>");



    /*
        <note id = "1">
        <to>Вася</to>
        <from>Света</from>
        <heading>Напоминание</heading>
        <body>Позвони мне завтра</body>
        </note>
     */

    private static String getId(String data){
        Matcher matcher = NOTE_PATTER.matcher(data);
        matcher.find();
        return matcher.group("id");
    }


}
