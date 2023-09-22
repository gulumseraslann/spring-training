package com.trendyol.bootcamp.spring.ch02.greeting07;

public class ErrorOutputRenderer implements GreetingRenderer {

	// MessageProvider is Java Interface
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
