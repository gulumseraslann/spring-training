package com.trendyol.bootcamp.spring.ch02.greeting07;

public class ItalianGreetingProvider implements GreetingProvider{

	@Override
	public String getGreeting() {
		return "Ciao!";
	}
}
