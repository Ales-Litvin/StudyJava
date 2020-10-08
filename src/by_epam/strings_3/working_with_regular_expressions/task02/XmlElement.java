package by_epam.strings_3.working_with_regular_expressions.task02;

import java.util.List;

public class XmlElement {

    private String tagName; // тут храниться имя тега
    private Attribute attribute;
    private String tagContent; // содержимое тега

    public XmlElement(String tagName, String attributeName, String value, String tagContent) {
        this.tagName = tagName;
        this.attribute = new Attribute(attributeName, value);
        this.tagContent = tagContent;
        //try {
        this.list = XmlParser.getElements(tagContent.trim());
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

    private List<XmlElement> elements; // тут будем хранить элементы



    @Override
    public String toString() {
        String result = "XmlElement\n" +
                "{tagName : '" + tagName + '\'' + '\n';
        if (attribute != null &&
                attribute.getName() != null &&
                attribute.getValue() != null){
            result += attribute;
        }
        result += "\n" + " tagContent : \n" +
                tagContent + '\n' +
                '}';

        return result;
    }
}
