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


import by_epam.strings_3.working_with_regular_expressions.task02.node.Node;

import java.util.Iterator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        XmlLoader xmlLoader = new XmlLoader(
                "G:\\Programming\\Work\\StudyJava\\src\\by_epam\\strings_3\\working_with_regular_expressions\\task02\\test_file\\text1.xml"
        );

        System.out.println();
        // загружем из файла в строку содержимео xml-документа
        String string = xmlLoader.getStringXml();

        // корневой элемент
        Node root = XmlParser.getRootNode(string);

        // последовательно возвращает содержимое узлов xml-документа в виде объекта Node
        Iterator<Node> iterator = root.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
