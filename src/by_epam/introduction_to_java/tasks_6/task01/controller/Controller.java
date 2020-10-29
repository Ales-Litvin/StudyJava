package by_epam.introduction_to_java.tasks_6.task01.controller;

import by_epam.introduction_to_java.tasks_6.task01.entity.User;
import by_epam.introduction_to_java.tasks_6.task01.entity.book.Book;
import by_epam.introduction_to_java.tasks_6.task01.exceptions.BookNotExistsException;
import by_epam.introduction_to_java.tasks_6.task01.exceptions.UserNotExistsException;
import by_epam.introduction_to_java.tasks_6.task01.utils.BookDao;
import by_epam.introduction_to_java.tasks_6.task01.utils.UserDao;
import by_epam.introduction_to_java.tasks_6.task01.view.View;

import java.util.List;

public class Controller {
    private View view;

    private UserDao userDao;

    private BookDao bookDao;

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
            this.currentUser = null;
            throw new UserNotExistsException(user);
        } else {
            this.currentUser = user;
        }
    }

    /**
     * Returns book from the catalog.
     * @param name name of book for finding.
     * @throws BookNotExistsException if book with this name not.
     */
    public Book getBook(String name) throws BookNotExistsException {
        Book book = bookDao.findBook(name);
        if (book == null) { throw new BookNotExistsException(name); }
        else return book;
    }

    /**
     * Returns list of book on the {@param numberPage}.
     * @param numberPage number of page (start with '1' finish {@see  numberOfPages}).
     */
    public List<Book> getPage(int numberPage){
        return bookDao.getPage(numberPage);
    }

    /**
     * Returns all books on the catalog.
     */
    public List<Book> getAllBook(){
        return bookDao.getAll();
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
            return currentUser.getRole().equals("ADMIN");
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
        } else {
            return currentUser.getRole().equals("USER");
        }
    }

}
