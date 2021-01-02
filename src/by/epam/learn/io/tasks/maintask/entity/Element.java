package by.epam.learn.io.tasks.maintask.entity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class represents a element in the folder.
 * Element may be folder or file.
 */
public class Element {
    private final File file;
    private final List<Element> elements;

    public Element(File file, List<Element> elements) {
        this.file = file;
        this.elements = elements;
    }

    public Element(File file) {
        this.file = file;
        this.elements = new ArrayList<>();
    }

    public boolean addElement(Element e) {
        return elements.add(e);
    }

    public File getFile() {
        return file;
    }

    public List<Element> getElements() {
        return elements;
    }

    private String getName() {
        return file.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Element)) return false;
        Element element = (Element) o;
        return Objects.equals(file, element.file) &&
                Objects.equals(elements, element.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, elements);
    }

    /**
     * Returns tree of elements. It's recursive method.
     * Example a tree of elements:
     * <pre>+---tasks</pre>
     * <pre>|   +---maintask</pre>
     * <pre>|   |   /---ConsoleHelper.java</pre>
     * <pre>|   |   +---entity</pre>
     * <pre>|   |   |   /---Element.java</pre>
     * <pre>|   |   /---FolderViewer.java</pre>
     * <pre>|   |   /---Main.java</pre>
     * <pre>|   |   /---maintask_structure.txt</pre>
     * <pre>|   |   /---README.txt</pre>
     * <pre>|   |   +---view</pre>
     * <pre>|   |   |   /---AbstractView.java</pre>
     * <pre>|   |   |   /---View.java</pre>
     * <pre>|   |   |   /---ViewToFile.java</pre>
     * <pre>|   +---optionaltask</pre>
     * <pre>|   /---tasks_structure.txt</pre>
     * @return a string representing tree of elements
     */
    @Override
    public String toString() { return toString(0); }

    public String toString(int level) {
        final StringBuilder sb = new StringBuilder();
        sb.append("+---").append(getName()).append("\n");
        if (elements != null && !elements.isEmpty()) {
            level++;
            // There's you can add counter
            for (Element e : elements) {
                sb.append(getTabulation(level));
                if (e.getFile().isFile()) {
                    sb.append("/---").append(e.getName()).append("\n");
                } else {
                    sb.append(e.toString(level));
                    // sb.append(e.toString()); // it worked
                }
            }
        }
        return sb.toString();
    }

    private String getTabulation(int level) {
        String tabulation = "";
        for (int i = 0; i < level; i++) {
            tabulation += "|   ";
        }
        return tabulation;
    }
}