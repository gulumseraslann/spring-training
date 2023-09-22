package com.trendyol.bootcamp.spring.ch02.greeting05;

/**
 * Topic: Factory class.
 *
 * Greeting providers and renderers are provided through a factory.
 *
 */
public class Application {

	public static void main(String[] args) {
		Factory factory = GreetingFactory.getInstance();
		GreetingRenderer renderer = factory.getGreetingRenderer();
		GreetingProvider provider = factory.getGreetingProvider();
		renderer.setGreetingProvider(provider);
		renderer.render();
	}
}
