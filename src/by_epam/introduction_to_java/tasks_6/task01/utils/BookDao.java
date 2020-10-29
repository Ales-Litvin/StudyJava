/*
 * Copyright (c) 2020, Rachko and/or its affiliates. All rights reserved.
 * RACHKO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package by_epam.introduction_to_java.tasks_6.task01.utils;

import by_epam.introduction_to_java.tasks_6.task01.entity.book.Book;
import by_epam.introduction_to_java.tasks_6.task01.loader.DataLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements interface DAO.
 * @author Aliaksandr Rachko
 * @version 1.0
 */
public class BookDao implements Dao<Book>{
    private DataLoader<Book> loader;

    private final List<Book> books;

    public BookDao(DataLoader<Book> loader) {
        this.loader = loader;
        this.books = new ArrayList<>(loader.getList());
    }

    public void setLoader(DataLoader<Book> loader) {
        this.loader = loader;
    }

    /**
     * Finds book by name.
     */
    public Book findBook(String name){
        for (Book book : books){
            if (book.getName().equals(name)){
                return book;
            }
        }
        return null;
    }

    @Override
    public List<Book> getAll() {
        return books;
    }

    @Override
    public void save(Book book) {
        books.add(book);
        refresh();
    }

    @Override
    public void delete(Book book) {
        if (books.remove(book)) {
            refresh();
        }
    }

    /**
     * Quantity of books on the one page for show.
     */
    private static final int COUNT_BOOK_ON_PAGE = 10;

    /**
     * Quantity of pages in the archive
     */
    private int numberOfPages;

    public int getNumberOfPages() { return numberOfPages; }

    /**
     * Returns quantity of pages in the archive.
     */
    private int countPages(){
        return (int) (((books.size() - 1) / COUNT_BOOK_ON_PAGE) + 1);
    }

    /**
     * Returns list of books on the page.
     * @param n number of page (start with '1' finish {@see  numberOfPages}).
     */
    public List<Book> getPage(int n){
        if (0 >= n && n > numberOfPages) return null;
        int fromIndex = (n - 1) * COUNT_BOOK_ON_PAGE;
        int toIndex = Math.min((fromIndex + COUNT_BOOK_ON_PAGE + 1), books.size());

        return books.subList(fromIndex, toIndex);
    }

    /**
     * Refreshes the page count in the data base.
     */
    private void refresh(){
        loader.store(books);
        this.numberOfPages = countPages();
    }
}
