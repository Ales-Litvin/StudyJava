package by.epam.introduction_to_java.strings_3.working_with_regular_expressions.task02.node;

import java.util.*;

public class Node {

    public Node parent;
    public Attribute attribute; // attribute of node
    public String tagName; // name of node
    public String tagContent; // content of node

    public Node next; // there are inner nodes


    public Node(Attribute attribute, String tagName, String tagContent) {
        this.attribute = attribute;
        this.tagName = tagName;
        this.tagContent = tagContent;
    }

    public String printAll(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.toString()).append('\n');
        if (next != null) {
            sb.append(next.printAll());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('<').append(tagName);
        if (attribute != null && attribute.toString() != null) sb.append(attribute);
        sb.append('>');
        if (tagContent != null) sb.append(tagContent);
        return sb.toString();
    }

    public static Map<String, String> array = new HashMap<>();

    public Iterator<Node> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Node> {
        Node currentNode = next.parent;

        public boolean hasNext() {
            return currentNode.next != null;
        }

        public Node next() {
           if (currentNode.next != null){
               currentNode = currentNode.next;
           }
           return currentNode.parent;
        }
    }

}
