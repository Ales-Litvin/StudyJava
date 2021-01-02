package by.epam.introduction_to_java.tasks_6.task01.resources;

import by.epam.introduction_to_java.tasks_6.task01.entity.book.Book;
import by.epam.introduction_to_java.tasks_6.task01.entity.book.TypeBook;
import by.epam.introduction_to_java.tasks_6.task01.entity.user.User;
import by.epam.introduction_to_java.tasks_6.task01.entity.user.UserRole;
import by.epam.introduction_to_java.tasks_6.task01.loader.DataLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for helping load data in the books.txt and users.txt
 */
public class InitResources {

    public static List<Book> books;

    public static List<User> users;

    static {
        books = new ArrayList<>();
        books.add(new Book("To Kill a Mockingbird", TypeBook.PAPER));
        books.add(new Book("The Great Gatsby", TypeBook.E_BOOK));
        books.add(new Book("Things Fall Apart", TypeBook.PAPER));
        books.add(new Book("Moby-Dick", TypeBook.E_BOOK));
        books.add(new Book("The Color Purple", TypeBook.PAPER));
        books.add(new Book("Atlas Shrugged", TypeBook.E_BOOK));
        books.add(new Book("1984", TypeBook.E_BOOK));
        books.add(new Book("The Lord of the Rings", TypeBook.PAPER));
        books.add(new Book("Hamlet", TypeBook.PAPER));
        books.add(new Book("The Murder of Roger Akroyd", TypeBook.PAPER));
        books.add(new Book("The Catcher in the Rye", TypeBook.E_BOOK));
        books.add(new Book("Invisible Man", TypeBook.PAPER));
        books.add(new Book("Watchmen", TypeBook.E_BOOK));
        books.add(new Book("Lord of the Flies", TypeBook.PAPER));
        books.add(new Book("Frankenstein", TypeBook.E_BOOK));
        books.add(new Book("Wuthering Heights", TypeBook.E_BOOK));
        books.add(new Book("The Sound and the Fury", TypeBook.PAPER));
        books.add(new Book("The Brothers Karamazov", TypeBook.PAPER));
        books.add(new Book("Slaughterhouse 5", TypeBook.E_BOOK));
        books.add(new Book("Giovanni’s Room", TypeBook.E_BOOK));
        books.add(new Book("The Hate U Give", TypeBook.PAPER));
        books.add(new Book("All Quiet on the Western Front", TypeBook.PAPER));

        users = new ArrayList<>();
        users.add(new User(
                "admin",
                "qwerty1234",
                "AdminEmail@gmail.com",
                UserRole.ADMIN));

        users.add(new User(
                "user",
                "1234",
                "someEmail@gmail.com",
                UserRole.USER));
        users.add(new User(
                "Sam",
                "1234",
                "someEmail@gmail.com",
                UserRole.USER));
    }


    public static void main(String[] args) {
        DataLoader<User> userDataLoader = new DataLoader<>(
                "./src/by_epam/introduction_to_java/tasks_6/task01/resources/users.txt"
        );

        //./src/by_epam/introduction_to_java/tasks_6/task01/resources/users.txt

        userDataLoader.store(users);

        DataLoader<Book> bookDataLoader = new DataLoader<>(
                "./src/by_epam/introduction_to_java/tasks_6/task01/resources/books.txt"
        );

        //./src/by_epam/introduction_to_java/tasks_6/task01/resources/books.txt

        bookDataLoader.store(books);
    }
}
