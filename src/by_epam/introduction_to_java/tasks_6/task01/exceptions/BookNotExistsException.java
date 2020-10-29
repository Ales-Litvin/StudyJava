package by_epam.introduction_to_java.tasks_6.task01.exceptions;


/**
 * The class {@code Exception} describe situation when book
 * don't exists in the data base.
 */
public class BookNotExistsException extends Exception{

    private final String nameBook;

    public String getNameBook() { return nameBook; }

    public BookNotExistsException(String nameBook) {
        super((String) String.format("Book with name '%s' is not exist.", nameBook));

        this.nameBook = nameBook;
    }
}