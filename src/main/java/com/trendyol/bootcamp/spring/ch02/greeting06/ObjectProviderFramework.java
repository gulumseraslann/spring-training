package com.trendyol.bootcamp.spring.ch02.greeting06;

import java.lang.reflect.InvocationTargetException;

public class ObjectProviderFramework {
	
	public ObjectProviderFramework(){}

	public Object getObject(String clazzName) {
		Object o = null;
		try {
			o = Class.forName(clazzName).getDeclaredConstructor().newInstance();
		} catch (InstantiationException e) {
			System.out.println("Can not instantiate the class: " + clazzName);
		} catch (IllegalAccessException e) {
			System.out.println("Illegal access to the class: " + clazzName);
		} catch (ClassNotFoundException e) {
			System.out.println("No such class found: " + clazzName);
		} catch (InvocationTargetException e) {
			System.out.println("InvocationTargetException exception: " + clazzName);
		} catch (NoSuchMethodException e) {
			System.out.println("NoSuchMethodException exception: " + clazzName);
		}

		return o;
	}
}
