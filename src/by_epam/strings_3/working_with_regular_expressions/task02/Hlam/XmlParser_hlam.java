package by_epam.strings_3.working_with_regular_expressions.task02.Hlam;

import by_epam.strings_3.working_with_regular_expressions.task02.node.Attribute;
import by_epam.strings_3.working_with_regular_expressions.task02.node.CloseNode;
import by_epam.strings_3.working_with_regular_expressions.task02.node.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlParser_hlam {

    private static final Pattern XML_ROOT_PATTERN = Pattern.compile(
            "<(\\w+)>(.+)</\\1>"
    );

    private static final Pattern XML_PATTERN = Pattern.compile(
            "<(\\w+)(\\s*(?<attributeName>\\w+)\\s*=\\s*[\"'](?<value>\\d+)[\"'])>(?<text>.+)</\\1"
    );
/*
    public static XmlRoot getRootElement(String data){
        Matcher matcher = XML_ROOT_PATTERN.matcher(data);

        if (matcher.find()) {

            return new XmlRoot(matcher.group(1), matcher.group(2));
        }
        return null;
    }

 */
    public static List<XmlElement> getElements(String data){

        Matcher matcher = XML_PATTERN.matcher(data);

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

    /**
     * Matches nodes whose opening or don't have body
     */
    public static Pattern OPENING_TAG = Pattern.compile(
            "<(\\w+)(\\s*(?<attrimbuteName>\\w+)\\s*=\\s*[\"'](?<value>\\d+)[\"'])*>" + // открывающийся тег с атрибутами
                    "|<(\\w+)/>" // тег без тела
    );

    /**
     * Returns list of nodes whose opening or don't have body
     * (возвращает список узлов которые открываются или не имеют тела)
     * @param data data a string xml-document
     * @return list of nodes whose opening or don't have body
     */
    public static List<Node> getOpeningNodes(String data){
        Matcher matcher = OPENING_TAG.matcher(data);

        List<Node> nodes = new ArrayList<>();

        while (matcher.find()){
            String tagName = matcher.group(1);
            String attributeCategory = matcher.group(3);
            String attributeName = matcher.group(4);
            String tagNameNotBody = matcher.group(5); // имя тега беза тела
            if (tagName == null) tagName = tagNameNotBody;
            Attribute attribute = new Attribute(attributeCategory, attributeName);
            Node node = new Node(attribute,
                    tagName,
                    (String) null);
            nodes.add(node);
        }
        return nodes;
    }

    /**
     * Matches nodes whose have body with text or don't have body
     */
    public static Pattern TAG_CONTENT = Pattern.compile(
            "<(\\w+)(\\s*(?<attrimbuteName>\\w+)\\s*=\\s*[\"'](?<value>\\d+)[\"'])*>" + // открывающийся тег с атрибутами
                    "([а-яА-Я0-9_\\s]+)" + // содержимое тега
                    "</\\1>" + // закрывающийся тег
                    "|<(\\w+)/>" // тег без тела
    );

    /**
     * Returns list of  nodes whose have body with text or don't have body
     * (возвращает список узлов содержащих текст или узел без тела)
     * @param data a string xml-document
     * @return list of nodes whose have body with text
     */
    public static List<Node> getNodesWithContent(String data){
        Matcher matcher = TAG_CONTENT.matcher(data);

        List<Node> nodes = new ArrayList<>();

        while (matcher.find()){
            String tagName = matcher.group(1);
            String attributeCategory = matcher.group(3);
            String attributeName = matcher.group(4);
            String tagContent = matcher.group(5);
            String tagNameNotBody = matcher.group(6); // имя тега беза тела
            if (tagName == null) tagName = tagNameNotBody;
            Attribute attribute = new Attribute(attributeCategory, attributeName);
            Node node = new Node(attribute,
                    tagName,
                    tagContent);
            nodes.add(node);
        }
        return nodes;
    }


    /**
     * Matches nodes whose are closing or don't have body
     */
    public static Pattern CLOSING_TAG = Pattern.compile(
            "</(\\w+)>|<(\\w+)/>" // тег без тела
    );

    /**
     * Returns list of nodes whose are closing or don't have body
     * (возвращает список закрывающихся узлов (закрывающихся тегов) и узлов без тела (тег без тела))
     * @param data a string xml-document
     * @return list of nodes whose are closing or don't have body
     */
    public static List<Node> getClosingNodes(String data){
        Matcher matcher = CLOSING_TAG.matcher(data);

        List<Node> nodes = new ArrayList<>();

        while (matcher.find()){
            String tagName = matcher.group(1);
            String tagNameNotBody = matcher.group(2); // имя тега беза тела
            if (tagName == null) tagName = tagNameNotBody;
            Node node = new CloseNode(null,
                    tagName,
                    (String) null);
            nodes.add(node);
        }
        return nodes;
    }

    /**
     * Matches nodes who don't have body
     */
    public static Pattern TAG_NOT_BODY = Pattern.compile(
            "<(\\w+)/>" // тег без тела
    );

    /**
     * Returns list of nodes whose don't have body
     * (возвращает список узлов без тела (тег без тела))
     * @param data a string xml-document
     * @return list of nodes whose don't have body
     */
    public static List<Node> getNodesNotBody(String data){
        Matcher matcher = TAG_NOT_BODY.matcher(data);

        List<Node> nodes = new ArrayList<>();

        while (matcher.find()){
            String tagName = matcher.group(1);
            Node node = new Node(null,
                    tagName,
                    (String) null);
            nodes.add(node);
        }
        return nodes;
    }

    /**
     * Copy information from list of nodes whose have body with text, to list of nodes whose opening
     * @param openingNodes list of nodes whose opening or don't have body
     * @param nodesWithContent list of nodes whose have body with text
     */
    public static void combineList(List<Node> openingNodes, List<Node> nodesWithContent){
        for (Node open : openingNodes) {
            for (Node withText : nodesWithContent) {
                if (open.tagName.equals(withText.tagName)) {
                    open.tagContent = withText.tagContent;
                }
            }
        }
    }


    // Maybe it's good.
    // Hea it's very good!
    // It's working with node whose don't have body
    /**
     * Matches nodes whose are opening or don't have body.
     * Nodes can have attribute. This pattern know one attribute
     */
    public static Pattern OPENING_NODE = Pattern.compile(
            "<((\\w+)(\\s*(?<category>\\w+)\\s*=\\s*[\"'](?<name>\\d+)[\"'])*)/?>" + // открывающийся тег с атрибутами
                    "(([а-яА-Яa-zA-Z0-9_\\s]+)" + // содержимое тега (текст)
                    "</\\2>)*"  // закрывающийся тег

    );

    /**
     * Returns list of nodes whose are opening or don't have body.
     * (возвращает список узлов которые открываются или не имеют тела,
     * а также распознает атрибуты в количестве один)
     * @param data data a string xml-document
     * @return list of nodes whose are opening or don't have body.
     */
    public static List<Node> getOpenNodes(String data){
        Matcher matcher = OPENING_NODE.matcher(data);

        List<Node> nodes = new ArrayList<>();

        while (matcher.find()){
            String tagName = matcher.group(2);
            String category = matcher.group("category");
            String name = matcher.group("name");
            String tagContent = matcher.group(7);
            Attribute attribute = null;
            if (category != null && name != null){
                attribute = new Attribute(category, name);
            }
            Node node = new Node(attribute,
                    tagName,
                    tagContent);
            nodes.add(node);
        }
        return nodes;
    }

    public static void setParent(List<Node> openingNodes, List<Node> closingNodes){
        for (int i = 0; i < openingNodes.size(); i++){
            Node node = openingNodes.get(i);
            for (int j = 0; j < closingNodes.size(); j++){
                if (node.tagName.equals(closingNodes.get(j).tagName)){
                    System.out.println(node.tagName + " : " + i +":" + j);
                    break;
                }
            }

        }
    }

    public static List<Node> getAllNode(String string){
        List<Node> openingNodes = XmlParser_hlam.getOpenNodes(string);
        List<Node> closingNodes = XmlParser_hlam.getClosingNodes(string);

        createList(openingNodes, closingNodes);

        System.out.println(openingNodes); // delete

        return openingNodes;
    }

    public static void createList(List<Node> openingNodes, List<Node> closingNodes){
        int countInsert = 0;
        for (int i = closingNodes.size() - 1; i >= 0; i--){
            Node closeNode = closingNodes.get(i);
            for (int j = i + countInsert; j >= 0; j--){
                Node currentNode = openingNodes.get(j);
                if (closeNode.tagName.equals(currentNode.tagName) &&
                        Objects.equals(closeNode.attribute, currentNode.attribute)) {
                    openingNodes.add(j + 1, closeNode);
                    break;
                } else if (closeNode.tagName.equals(currentNode.tagName) &&
                        !Objects.equals(closeNode.attribute, currentNode.attribute)){
                    openingNodes.add(j, closeNode);
                    break;
                } else if (!currentNode.tagName.equals(closeNode.tagName)){
                    if (openingNodes.size() == j + 1){
                        openingNodes.add(closeNode);
                    } else {
                        openingNodes.add(j + 1, closeNode);
                    }
                    countInsert++;
                    break;
                }
            }
        }
    }
}
