package by.epam.introduction_to_java.tasks_6.task01.controller;

import by.epam.introduction_to_java.tasks_6.task01.entity.book.Book;
import by.epam.introduction_to_java.tasks_6.task01.entity.user.User;
import by.epam.introduction_to_java.tasks_6.task01.entity.user.UserRole;
import by.epam.introduction_to_java.tasks_6.task01.view.View;
import by.epam.introduction_to_java.tasks_6.task01.exceptions.BookNotExistsException;
import by.epam.introduction_to_java.tasks_6.task01.exceptions.UserHasNotPermission;
import by.epam.introduction_to_java.tasks_6.task01.exceptions.UserNotExistsException;
import by.epam.introduction_to_java.tasks_6.task01.network.EmailSender;
import by.epam.introduction_to_java.tasks_6.task01.utils.BookDao;
import by.epam.introduction_to_java.tasks_6.task01.utils.UserDao;

import javax.mail.MessagingException;
import java.util.Date;
import java.util.List;

public class Controller {
    private View view;

    private UserDao userDao;

    private BookDao bookDao;

    public Controller(UserDao userDao, BookDao bookDao) {
        this.userDao = userDao;
        this.bookDao = bookDao;
        this.view = new View(this);
    }

    /**
     * Starts program;
     */
    public void start(){
        view.initUser();
        view.action();
    }

    /**
     * Is current user.
     */
    private User currentUser;

    public View getView() { return view; }

    public void setView(View view) { this.view = view; }

    public UserDao getUserDao() { return userDao; }

    public void setUserDao(UserDao userDao) { this.userDao = userDao; }

    public BookDao getBookDao() { return bookDao; }

    public void setBookDao(BookDao bookDao) { this.bookDao = bookDao; }

    /**
     * Sets current user.
     * @param user user to check for existence
     * @throws UserNotExistsException if this user doesn't exists.
     */
    public void setCurrentUser(User user) throws UserNotExistsException {
        User u = userDao.findUser(user.getUserName(), user.getPassword());
        if (u == null) {
            this.currentUser = user;
            throw new UserNotExistsException(user);
        } else {
            this.currentUser = u;
        }
    }

    /**
     * Returns book from the catalog.
     * @param name name of book for finding.
     * @throws BookNotExistsException if book with this name not.
     * @throws UserHasNotPermission user doesn't have permission for this action.
     */
    public Book getBook(String name) throws BookNotExistsException, UserHasNotPermission {
        if (!hasUserPermission()) throw new UserHasNotPermission(currentUser);
        Book book = bookDao.findBook(name);
        if (book == null) { throw new BookNotExistsException(name); }
        else return book;
    }

    /**
     * Returns list of book on the {@param numberPage}.
     * @param numberPage number of page (start with '1' finish {@see  numberOfPages}).
     * @throws UserHasNotPermission user doesn't have permission for this action.
     */
    public List<Book> getPage(int numberPage) throws UserHasNotPermission {
        if (!hasUserPermission()) throw new UserHasNotPermission(currentUser);
        return bookDao.getPage(numberPage);
    }

    public int getCountPages(){
        return bookDao.getNumberOfPages();
    }

    /**
     * Returns all books on the catalog.
     * @throws UserHasNotPermission user doesn't have permission for this action.
     */
    public List<Book> getAllBook() throws UserHasNotPermission {
        if (!hasUserPermission()) throw new UserHasNotPermission(currentUser);
        return bookDao.getAll();
    }

    /**
     * Adds book to the catalog.
     * @param book book for add.
     * @throws UserHasNotPermission user doesn't have permission for this action.
     */
    public void addBook(Book book) throws UserHasNotPermission, MessagingException {
        if (!hasAdminPermission()) throw new UserHasNotPermission(currentUser);
        bookDao.save(book);

        String subject = String.format("New book '%s'.", book.getName());

        String text = String.format(
                "Was adds new book '%s' in the '%s'.\n" +
                "%3$tA, on %3$td %3$tB %3$tT (%3$tZ) %3$tY\n"+
                "Your BookCatalog!",
                book.getName(), book.getType(), new Date());

        sendEmail(userDao.getUsersEmails().toArray(new String[0]),
                subject,
                text );
        View.writeMessage(
                "==================================\n" +
                "Sent messages all users:\n" +
                "__________________________________\n" +
                "Subject: " + subject + "\n" +
                "Text: " + text + "\n" +
                "__________________________________");
    }

    /**
     * Sends email.
     */
    public void sendEmail(String[] recipients, String subject, String text) throws MessagingException {
        String[] data = view.getEmailData();

        EmailSender.sendMessage(
                data[0],
                data[1],
                recipients,
                subject,
                text);
    }

    /**
     * Offers book.
     */
    public void offerBook(Book book) throws UserHasNotPermission, MessagingException {
        if (!hasUserPermission()) throw new UserHasNotPermission(currentUser);

        String subject = String.format("User offer '%s'.", currentUser.getUserName());

        String text = String.format(
                "Can you adds new book '%s' in the '%s'.\n" +
                "Yours friend %s!",
                book.getName(), book.getType(), currentUser.getUserName());


        sendEmail(userDao.getAdminsEmails().toArray(new String[0]),
                subject,
                text);
        View.writeMessage(
                "==================================\n" +
                "Sent messages all admin:\n" +
                "__________________________________\n" +
                "Subject: " + subject + "\n" +
                "Text: " + text + "\n" +
                "__________________________________");
    }

    /**
     * Checks has current user admin permission or not.
     * @return {@code true} if the current user has admin permission,
     *         {@code false} if has not admin permission.
     */
    private boolean hasAdminPermission(){
        if (currentUser == null) {
            return false;
        } else {
            return currentUser.getRole() == UserRole.ADMIN;
        }
    }

    /**
     * Checks has current user 'user' permission or not.
     * @return {@code true} if the current user has 'user' permission,
     *         {@code false} if has not 'user' permission.
     */
    private boolean hasUserPermission(){
        if (currentUser == null) {
            return false;
        } else if (currentUser.getRole() == UserRole.USER) {
            return true;
        } else return currentUser.getRole() == UserRole.ADMIN;
    }
}
