package com.trendyol.bootcamp.spring.ch02.greeting03;

public class Application {

	public static void main(String[] args) {
		StandardOutputRenderer renderer = new StandardOutputRenderer();
		EnglishGreetingProvider provider = new EnglishGreetingProvider();
		renderer.setGreetingProvider(provider);
		renderer.render();
	}
}
