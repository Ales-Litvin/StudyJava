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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * Implements interface DAO.
 */
public class BookDao implements Dao<Book>{

    List<Book> books = new ArrayList<>();

    public BookDao() {

    }


    @Override
    public Optional<Book> get(String name) {
        Book book = null;
        for (Book b : books){
            if (b.getName().equals(name)){
                book = b;
            }
        }
        return Optional.ofNullable(book);
    }

    @Override
    public List<Book> getAll() {
        return books;
    }

    @Override
    public void save(Book book) {
        books.add(book);
    }

    @Override
    public void delete(Book book) {
        books.remove(book);
    }
}
