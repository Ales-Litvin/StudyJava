package by_epam.strings_3.working_with_regular_expressions.task02.node;

public class CloseNode extends Node{

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
