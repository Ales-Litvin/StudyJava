package com.javadevblog.lambda;

public class RunnableLambdaDemo {
    public static void main(String[] args) {
        // Runnable is functional interface
        Runnable runnable = () -> System.out.println("Runnable lambda!");

        // If you need more code use '{ }'
        runnable = () -> {
            // some code here
            System.out.println("Functional interface Runnable!");
        };
    }
}
