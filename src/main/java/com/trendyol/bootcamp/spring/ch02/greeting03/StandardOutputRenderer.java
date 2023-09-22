package com.trendyol.bootcamp.spring.ch02.greeting03;

public class StandardOutputRenderer {
	private EnglishGreetingProvider greetingProvider = null;

	public void setGreetingProvider(EnglishGreetingProvider provider) {
		this.greetingProvider = provider;
	}

	// Rendering logic can change without affecting the rest of the application
	public void render() {
		String greeting = greetingProvider.getGreeting();
		System.out.println(greeting);
	}
}
