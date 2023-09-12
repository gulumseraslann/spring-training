package com.trendyol.bootcamp.spring.ch02.greeting08;

public class StandardOutputRenderer implements GreetingRenderer{
	private GreetingProvider greetingProvider = null;

	@Override
	public void setGreetingProvider(GreetingProvider provider) {
		this.greetingProvider = provider;
	}

	public void render() {
		String greeting = greetingProvider.getGreeting();
		System.out.println(greeting);
	}
}
