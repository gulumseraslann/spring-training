package com.trendyol.bootcamp.spring.ch02.greeting02;

public class Application {

    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println(args[0]);
        } else {
            System.out.println("Hello World!");
        }
    }

}
