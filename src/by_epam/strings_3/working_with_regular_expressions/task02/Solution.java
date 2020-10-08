package by_epam.strings_3.working_with_regular_expressions.task02;

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


import java.sql.ClientInfoStatus;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        XmlLoader xmlLoader = new XmlLoader("G:\\Programming\\Work\\StudyJava\\src\\by_epam\\strings_3\\working_with_regular_expressions\\task02\\text.xml");

        String string = xmlLoader.getXml();

        /*
        XmlRoot xmlRoot = XmlParser.getRootElement(string);

        System.out.println(xmlRoot);


        List<XmlElement> list = XmlParser.getElements(string);

        System.out.println(list);

        System.out.println(list.get(0).list);
        */

        List<String> list = XmlParser.getStrings(string);

        System.out.println(list);


    }

    



}
