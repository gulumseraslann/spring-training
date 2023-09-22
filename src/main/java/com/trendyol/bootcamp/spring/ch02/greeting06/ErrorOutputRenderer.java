package com.trendyol.bootcamp.spring.ch02.greeting06;

public class ErrorOutputRenderer implements GreetingRenderer {

	// GreetingProvider is Java Interface
	private GreetingProvider greetingProvider = null;
	
	@Override
	public void setGreetingProvider(GreetingProvider greetingProvider) {
		this.greetingProvider = greetingProvider;
	}

	@Override
	public void render() {
		String greeting = greetingProvider.getGreeting();
		System.err.println(greeting);
	}
}
