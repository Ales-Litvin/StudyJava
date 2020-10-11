package by_epam.introduction_to_java.strings_3.working_with_regular_expressions.task02.node;

import by_epam.strings_3.working_with_regular_expressions.task02.node.Attribute;
import by_epam.strings_3.working_with_regular_expressions.task02.node.Node;

public class CloseNode extends Node {

    public CloseNode(Attribute attribute, String tagName, String tagContent) {
        super(attribute, tagName, tagContent);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('<').append('/').append(tagName);;
        sb.append('>');
        return sb.toString();
    }
}
