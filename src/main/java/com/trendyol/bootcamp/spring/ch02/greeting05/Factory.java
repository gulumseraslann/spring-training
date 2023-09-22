package com.trendyol.bootcamp.spring.ch02.greeting05;

public interface Factory {

    GreetingRenderer getGreetingRenderer();

    GreetingProvider getGreetingProvider();

}
