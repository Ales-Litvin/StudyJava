package by_epam.introduction_to_java.tasks_6.task01.controller;

import by_epam.introduction_to_java.tasks_6.task01.entity.User;
import by_epam.introduction_to_java.tasks_6.task01.exceptions.UserNotExistsException;
import by_epam.introduction_to_java.tasks_6.task01.utils.BookDao;
import by_epam.introduction_to_java.tasks_6.task01.utils.UserDao;
import by_epam.introduction_to_java.tasks_6.task01.view.View;

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
}
