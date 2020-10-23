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

package by_epam.introduction_to_java.basics_of_OOP_5.task05.creator;

import by_epam.introduction_to_java.basics_of_OOP_5.task05.entity.Product;
import by_epam.introduction_to_java.basics_of_OOP_5.task05.entity.flower.Flower;
import by_epam.introduction_to_java.basics_of_OOP_5.task05.entity.flower.FlowerType;
import by_epam.introduction_to_java.basics_of_OOP_5.task05.entity.pack.Pack;
import by_epam.introduction_to_java.basics_of_OOP_5.task05.entity.pack.PackType;
import by_epam.introduction_to_java.basics_of_OOP_5.task05.entity.FlowerComposition;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The base class of the composition factory.
 * @see Flower
 * @see FlowerType
 * @see Creator
 * @see Pack
 * @see PackType
 * @see Creator
 * @see FlowerComposition
 * @author Aliaksandr Rachko
 */
public class CompositionCreator implements Creator{
    private FlowerCreator flowerCreator;
    private PackCreator packCreator;

    public CompositionCreator(FlowerCreator flowerCreator, PackCreator packCreator) {
        this.flowerCreator = flowerCreator;
        System.out.println(flowerCreator.getClass().getName());
        this.packCreator = packCreator;
        System.out.println(packCreator.getClass().getName());
    }

    public FlowerCreator getFlowerCreator() { return flowerCreator; }

    public void setFlowerCreator(FlowerCreator flowerCreator) { this.flowerCreator = flowerCreator; }

    public PackCreator getPackCreator() { return packCreator; }

    public void setPackCreator(PackCreator packCreator) { this.packCreator = packCreator; }

    /**
     * This pattern describes user's query type:<br>
     * __________<br>
     * ROSE\1<br>
     * ASTER\2<br>
     * PAPER<br>
     */
    public static final Pattern REQUEST_PATTERN = Pattern.compile("(?<name>\\w+)\\\\*(?<n>\\d+)*");

    /**
     * Common expression patter.
     */
    public static final Pattern COMMON_PATTER = Pattern.compile("((?<name>\\w+)\\\\(?<n>\\d+))+\\w+");


    /**
     * Returns product class of {@link FlowerComposition}.
     */
    @Override
    public Product createProduct(String name) {
        boolean isTrue = COMMON_PATTER.matcher(name).matches();
        if (!isTrue){
            return null;
        }

        List<Note> notes = parseString(name);

        List<Flower> flowers = new ArrayList<>();

        Pack pack = null;
        for (Note note : notes){
            if (note.count == 0){
                pack = (Pack) packCreator.createProduct(note.name);
            } else {
                for (int i = note.count; i > 0; i--){
                    flowers.add((Flower) flowerCreator.createProduct(note.name));
                }
            }
        }

        if (pack == null){
            pack = new Pack("Package", 0);
        }

        return new FlowerComposition(flowers, pack);
    }

    /**
     * Returns list of notes with data for create products.
     */
    private List<Note> parseString(String name){
        Matcher matcher = REQUEST_PATTERN.matcher(name);

        List<Note> notes = new ArrayList<>();

        while (matcher.find()){
            String string = matcher.group("name");
            int count = 0;
            try {
                count = Integer.parseInt(matcher.group("n"));
            } catch (NumberFormatException e){
                // Does nothing.
            }
            notes.add(new Note(string, count));
        }

        return notes;
    }

    /**
     * Object stores information about the request.
     */
    static class Note{
        String name;
        int count;

        public Note(String name, int count) {
            this.name = name.toUpperCase();
            this.count = count;
        }
    }


}
