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

/*
 * I recommend see:
 * task3513
 * task3310
 * task3209
 */

import by_epam.introduction_to_java.basics_of_OOP_5.task04.view.View;
import by_epam.introduction_to_java.basics_of_OOP_5.task04.loader.DataLoader;
import by_epam.introduction_to_java.basics_of_OOP_5.task04.model.Treasure;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Treasure> list = new ArrayList<>();
        list.add(new Treasure("The Amber Room", 10000));
        list.add(new Treasure("Sarcophagus of Menkaure", 20000));
        list.add(new Treasure("Ark of the Covenant", 15000));
        list.add(new Treasure("Honjo Masamune Sword", 35000));
        list.add(new Treasure("Lost Library of the Moscow Tsars", 80000));
        list.add(new Treasure("Crown jewels of Ireland", 90000));
        list.add(new Treasure("Sappho's lost poems", 15000));
        list.add(new Treasure("Efrosinya's of Polotsk cross", 10000));
        list.add(new Treasure("Dead Bishop's Treasure Stolen by Pirates", 15000));
        list.add(new Treasure("The Just Judges", 50000));
        list.add(new Treasure("The Florentine Diamond", 60000));
        list.add(new Treasure("Q Source", 5000));


        DataLoader loader = new DataLoader("G:\\Programming\\Work\\StudyJava\\src\\by_epam\\introduction_to_java\\basics_of_OOP_5\\task04\\resources\\treasures.txt");
        loader.store(list);
        list.clear();
        View.printTreasures(list);
        list = loader.getTreasures();
        View.printTreasures(list);
    }
}