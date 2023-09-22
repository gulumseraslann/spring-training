package com.trendyol.bootcamp.spring.ch02.greeting07;

public class ObjectProviderFramework {
	
	private GreetingRenderer renderer;
	private GreetingProvider provider;
	
	public ObjectProviderFramework(){}

	public Object getObject(String clazzName1, String clazzName2) {
		Object o1 = null;
		Object o2 = null;
		try {
			o1 = Class.forName(clazzName1).getDeclaredConstructor().newInstance();
			o2 = Class.forName(clazzName2).getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			System.out.println("Problem with instantiating the class: " + e.getMessage());
		}
		
		if(o1 instanceof GreetingRenderer)
			renderer = (GreetingRenderer) o1;
		
		if(o2 instanceof GreetingProvider)
			provider = (GreetingProvider) o2;
		
		renderer.setGreetingProvider(provider);
		
		return renderer;
	}
}
