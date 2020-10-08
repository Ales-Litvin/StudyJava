package by_epam.strings_3.working_with_regular_expressions.task02;

import java.util.List;

public class XmlRoot {

    private String tagName; // тут храниться имя тега

    private String tagContent; // тут храниться содержимое корневого тега

    private List<XmlElement> elements; // тут будем хранить элементы

    public XmlRoot(String tagName, String tagContent) {
        this.tagName = tagName;
        this.tagContent = tagContent;
        System.out.println(tagContent);
        //try {
        //this.elements = XmlParser.getElements(tagContent);
        //} catch (NullPointerException e){
        // e.printStackTrace();
        //}
    }

    public void getContent(){
        this.elements = XmlParser.getElements(tagContent);
    }

    public String getTagName() {
        return tagName;
    }

    @Override
    public String toString() {
        return "XmlRoot{" +
                "tagName='" + tagName + '\'' +
                ", elements=" + elements +
                '}';
    }
}
