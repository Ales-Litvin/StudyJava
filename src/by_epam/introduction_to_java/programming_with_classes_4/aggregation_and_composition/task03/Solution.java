package by_epam.introduction_to_java.programming_with_classes_4.aggregation_and_composition.task03;

/*
 * Условие задачи:
 * 3. Создать объект класса Государство, используя классы Область, Район, Город.
 *    Методы: вывести на консоль столицу,
 *            количество областей,
 *            площадь,
 *            областные центры.
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        // создаем районы с центрами в виде необольшого города
        District berestovica = new District(new City("Берестовица"), 731.58);
        District volkovysk = new District(new City("Волковыск"), 1192.85);

        District borisov = new District(new City("Борисов"), 2987.95);
        District volojyn = new District(new City("Воложин"), 1916.75);

        // создаем списки районов по регионам
        List<District> grodnoRegion = new ArrayList<>();
        grodnoRegion.add(berestovica);
        grodnoRegion.add(volkovysk);

        List<District> minskRegion = new ArrayList<>();
        minskRegion.add(borisov);
        minskRegion.add(volojyn);

        // создаем области
        Region grodno = new Region(new City("Гродно"), grodnoRegion);
        Region minsk = new Region(new City("Минск"), minskRegion);

        // создаем список областей
        List<Region> regions = new ArrayList<>();
        regions.add(grodno);
        regions.add(minsk);

        // создаем государство, позднее в него можно добавлять новы области например: Смоленскую, Белостоцкую, Виленскую.
        final State BELARUS = new State("BELARUS",new City("Менск"), regions);

        // выводим на консоль столицу
        BELARUS.printTheCapital();

        // выводим на консоль количество областей, пока только 2
        System.out.println("Количестов областей:" + BELARUS.getCountOfRegions());

        // выводим на консоль площадь, сейчас площадь государства еще маленькая )
        System.out.println("Площадь: " + + BELARUS.getArea());

        // выводим на экран областные центры
        System.out.println("Областные центры:" + BELARUS.getRegionsCentres());
    }
}