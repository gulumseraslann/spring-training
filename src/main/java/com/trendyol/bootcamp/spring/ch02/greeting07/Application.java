package com.trendyol.bootcamp.spring.ch02.greeting07;

/**
 * Topic: Custom object framework.
 *  
 * Greeting providers and greeting renderers are produced through a custom framework.
 * The custom framework is also responsible for wiring objects.
 *
 */
public class Application {

	public static void main(String[] args) {
		
		ObjectProviderFramework framework = new ObjectProviderFramework() ;

		GreetingRenderer renderer = (GreetingRenderer) framework.getObject("com.trendyol.bootcamp.spring.ch02.greeting07.StandardOutputRenderer", "com.trendyol.bootcamp.spring.ch02.greeting07.EnglishGreetingProvider");
		renderer.render();
		
        //renderer = (GreetingRenderer) framework.getObject("com.trendyol.bootcamp.spring.ch02.greeting07.ErrorOutputRenderer", "com.trendyol.bootcamp.spring.ch02.greeting07.TurkishGreetingProvider");
		// renderer.render();
	}
}
