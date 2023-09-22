package com.trendyol.bootcamp.spring.ch02.greeting07;

public class StandardOutputRenderer implements GreetingRenderer{
	private GreetingProvider greetingProvider = null;

	@Override
	public void setGreetingProvider(GreetingProvider provider) {
		this.greetingProvider = provider;
	}

	// Rendering logic can change without affecting the rest of the application
	public void render() {
		String greeting = greetingProvider.getGreeting();
		System.out.println(greeting);
	}
}
