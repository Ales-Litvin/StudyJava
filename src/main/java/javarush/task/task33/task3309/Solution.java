package javarush.task.task33.task3309;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException, JAXBException {
        StringWriter writer = new StringWriter();

        JAXBContext context = JAXBContext.newInstance(obj.getClass());

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(obj, writer);

        List<String> list = new ArrayList<>();


        for (String text : writer.toString().split("\n")){
            if (text.contains("<" + tagName + ">") && !text.contains("![CDATA[")){
                list.add("<!--" + comment + "-->");
                list.add(text);
            } else {
                list.add(text);
            }
        }

        String xml = "";

        for (int i = 0; i < list.size(); i++) {
            if (i !=list.size() - 1){
                xml += list.get(i) + "\n";
            } else xml += list.get(i);
        }

        return xml;
    }

    public static void main(String[] args) {


    }
}
