package by.epam.learn.io.tasks.maintask.view;

public interface View {
    /**
     * Show the tree of elements;
     */
    void show(String string);

    /**
     * Reads the tree of elements;
     * @return a string of tree;
     */
    String read(String fileName);

}
