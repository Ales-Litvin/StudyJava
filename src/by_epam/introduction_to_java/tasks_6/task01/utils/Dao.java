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

import java.util.List;
import java.util.Optional;


public interface Dao<T> {

    Optional<T> get(String name);

    List<T> getAll();

    void save(T t);

    void delete(T t);
}