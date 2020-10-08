package by_epam.strings_3.working_with_regular_expressions.task02;

import java.util.List;

public class XmlElement {

    private String tagName; // тут храниться имя тега
    private String attributeName; // тут храниться имя атрибута
    private String value; // атрибуты тега (id)
    private String tagContent; // содержимое тега

    public XmlElement(String tagName, String attributeName, String value, String tagContent) {
        this.tagName = tagName;
        this.attributeName = attributeName;
        this.value = value;
        this.tagContent = tagContent;
        //try {
            this.list = XmlParser.getElements(tagContent);
        //} catch (NullPointerException e){
           // e.printStackTrace();
        //}
    }

    public List<XmlElement> list;

    public void getContent(){
        this.list = XmlParser.getElements(tagContent);
    }


    public String getTagName() {
        return tagName;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public String getValue() {
        return value;
    }

    private List<XmlElement> elements; // тут будем хранить элементы



    @Override
    public String toString() {
        return "XmlElement\n" +
                "{ tagName : '" + tagName + '\'' + '\n' +
                "  attributeName : '" + attributeName + '\'' + '\n' +
                "  attribute : '" + value + '\'' + '\n' +
                "  tagContent : \n" +
                tagContent + '\n' +
                '}';
    }
}
