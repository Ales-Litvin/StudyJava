package javarush.task.task19.task1918;

/*
Считайте с консоли имя файла, который имеет HTML-формат.

Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>

Первым параметром в метод learn.main приходит тег. Например, "span".
Вывести на консоль все теги, которые соответствуют заданному тегу.
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле.
Количество пробелов, \n, \r не влияют на результат.
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нет.
Тег может содержать вложенные теги.


Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag text2>text1</tag>

text1, text2 могут быть пустыми
 */

/*
Знакомство с тэгами
 */

/*
G:\Teg.htm
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String dataAll = "";
        String data;
        while ((data = fileReader.readLine()) != null){
            dataAll = dataAll.concat(data);
        }
        fileReader.close();

        if (args.length > 0) {
            Pattern pattern = Pattern.compile("<(" + args[0] + ")[^>]*?>.*?(<\\1[^>]*?>.*?</\\1>)*.*?</\\1>");
            //Pattern pattern = Pattern.compile("<span[ >].+</span>");
            Matcher matcher = pattern.matcher(dataAll);
            while (matcher.find()) {
                System.out.println(matcher.group(0));
                String t = matcher.group(2);
                if (t != null) System.out.println(t);
            }
        }

        // для разбития регулярного вырожения нужно было делать рекурсию методов
        // вызывать в методе метод matcher.group() у переданной строки matcher.group()
    }
}
