package by_epam.introduction_to_java.strings_3.working_with_regular_expressions.task02;


import by_epam.introduction_to_java.strings_3.working_with_regular_expressions.task02.node.Attribute;
import by_epam.introduction_to_java.strings_3.working_with_regular_expressions.task02.node.CloseNode;
import by_epam.introduction_to_java.strings_3.working_with_regular_expressions.task02.node.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlParser {

    /**
     * Matches nodes whose are opening or don't have body.
     * (соответсвует открывающимся тегам с одним атрибутом и содержимым или без содрежимого)
     * Nodes can have attribute. This pattern know one attribute
     */
    public static Pattern OPENING_NODE = Pattern.compile(
            "<((\\w+)(\\s*(?<category>\\w+)\\s*=\\s*[\"'](?<name>\\d+)[\"'])*)/?>" + // открывающийся тег с одним атрибутом
                    "(([а-яА-Яa-zA-Z0-9_\\s]+)" + // содержимое тега (текст)
                    "</\\2>)*"  // закрывающийся тег

    );

    /**
     * Returns list of nodes whose are opening or don't have body.
     * (возвращает список тегов которые открываются или не имеют содержимого,
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

    /**
     * Matches nodes whose are closing or don't have body
     */
    public static Pattern CLOSING_TAG = Pattern.compile(
            "</(\\w+)>|<(\\w+)/>" // тег без тела
    );

    /**
     * Returns list of nodes whose are closing or don't have body
     * (возвращает список закрывающихся тегов и тегов без содрежимого)
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
     * (возвращает список тегов без содержимого)
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
     *  Returns list of nodes
     *  (Возвращает список тегов в порядке расположения в xml-документе)
     * @param string a string xml-document
     * @return list of nodes
     */
    public static List<Node> getAllNode(String string){
        List<Node> openingNodes = XmlParser.getOpenNodes(string);
        List<Node> closingNodes = XmlParser.getClosingNodes(string);

        createList(openingNodes, closingNodes);

        return openingNodes;
    }

    /**
     * Copies closingNodes in the openingNodes
     * (копирует закрывающиеся теги в список окрвающихся тегов в порядке их встречи)
     * @param openingNodes list of opening tag
     * @param closingNodes list of closed tag
     */
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

    public static Node getRootNode(String string){
        List<Node> openingNodes = XmlParser.getOpenNodes(string);
        List<Node> closingNodes = XmlParser.getClosingNodes(string);

        createList(openingNodes, closingNodes);

        Node root = openingNodes.get(0);
        root.parent = null;

        for (int i = 1; i < openingNodes.size(); i++){
            Node past = openingNodes.get(i - 1);
            Node current = openingNodes.get(i);
            past.next = current;
            current.parent = past;
        }
        return root;
    }


}
