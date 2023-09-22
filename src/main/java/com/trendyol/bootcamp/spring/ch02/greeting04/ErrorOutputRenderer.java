package com.trendyol.bootcamp.spring.ch02.greeting04;

public class ErrorOutputRenderer implements GreetingRenderer {

	private GreetingProvider greetingProvider = null;

	@Override
	public void render() {
		System.err.println(greetingProvider.getGreeting());
	}

	@Override
	public void setGreetingProvider(GreetingProvider greetingProvider) {
		this.greetingProvider = greetingProvider;
	}
}
