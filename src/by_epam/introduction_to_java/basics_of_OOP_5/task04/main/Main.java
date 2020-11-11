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

package by_epam.introduction_to_java.basics_of_OOP_5.task04.main;

/*
 * Условие задачи:
 * Задача 4.
 * Создать консольное приложение, удовлетворяющее следующим требованиям:
 * • Приложение должно быть объектно-, а не процедурно-ориентированным.
 * • Каждый класс должен иметь отражающее смысл название и информативный состав.
 * • Наследование должно применяться только тогда, когда это имеет смысл.
 * • При кодировании должны быть использованы соглашения об оформлении кода java code convention.
 * • Классы должны быть грамотно разложены по пакетам.
 * • Консольное меню должно быть минимальным.
 * • Для хранения данных можно использовать файлы.
 *
 * Дракон и его сокровища.
 * Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере дракона.
 * Реализовать  возможность  просмотра  сокровищ, выбора  самого  дорогого  по  стоимости  сокровища
 * и выбора сокровищ на заданную сумму.
 */

import by_epam.introduction_to_java.basics_of_OOP_5.task04.controller.Controller;
import by_epam.introduction_to_java.basics_of_OOP_5.task04.model.Cave;
import by_epam.introduction_to_java.basics_of_OOP_5.task04.view.View;
import by_epam.introduction_to_java.basics_of_OOP_5.task04.loader.DataLoader;

/**
 * Main class. Starts program.
 * @author Aliaksandr Rachko
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        DataLoader loader = new DataLoader(
                "./src/by_epam/introduction_to_java/basics_of_OOP_5/task04/resources/treasures.txt");

        Cave cave = new Cave(loader.getTreasures());

        Controller controller = new Controller(cave);

        View view = new View(controller);
        view.action();
    }
}