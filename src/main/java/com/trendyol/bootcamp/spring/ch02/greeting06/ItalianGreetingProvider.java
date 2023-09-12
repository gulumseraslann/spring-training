package com.trendyol.bootcamp.spring.ch02.greeting06;

public class ItalianGreetingProvider implements GreetingProvider{

	@Override
	public String getGreeting() {
		return "Ciao!";
	}
}
