package com.trendyol.bootcamp.spring.ch02.greeting06;

/**
 * Topic: Custom factory framework.
 *  
 * Greeting providers and greeting renderers are produced through a factory. 
 * But the factory is a custom framework.
 *
 */
public class Application {

	public static void main(String[] args) {
		ObjectProviderFramework framework = new ObjectProviderFramework() ;

		GreetingRenderer renderer = (GreetingRenderer) framework.getObject("com.trendyol.bootcamp.spring.ch02.greeting06.StandardOutputRenderer");
		GreetingProvider provider = (GreetingProvider) framework.getObject("com.trendyol.bootcamp.spring.ch02.greeting06.EnglishGreetingProvider");
		
		renderer.setGreetingProvider(provider);
		renderer.render();
		
		renderer = (GreetingRenderer) framework.getObject("com.trendyol.bootcamp.spring.ch02.greeting06.ErrorOutputRenderer");
		provider = (GreetingProvider) framework.getObject("com.trendyol.bootcamp.spring.ch02.greeting06.TurkishGreetingProvider");
		
		renderer.setGreetingProvider(provider);
		renderer.render();
		
		provider = (GreetingProvider) framework.getObject("com.trendyol.bootcamp.spring.ch02.greeting06.ItalianGreetingProvider");
		
		renderer.setGreetingProvider(provider);
		renderer.render();
	}
}
