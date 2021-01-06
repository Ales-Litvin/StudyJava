package com.habr.lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStreamDemo {
    public static void main(String[] args) {
        Collection<String> collection = Arrays.asList("a1", "a2", "a3");

        // Create stream use standard method
        Stream<String> streamFromCollection = collection.stream();


        try {
            // Stream from file, each string is element of stream
            Stream<String> streamFromFiles = Files.lines(Paths.get("file.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        IntStream intStream = "String for creates stream example".chars();


    }
}
