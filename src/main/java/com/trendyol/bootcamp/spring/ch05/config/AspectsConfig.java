package com.trendyol.bootcamp.spring.ch05.config;

import com.trendyol.bootcamp.spring.ch05.monitor.jamon.JamonMonitorFactory;
import com.trendyol.bootcamp.spring.ch05.monitor.MonitorFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// TODO-04: Update Aspect related configuration
// - Add a class-level annotation to scan for components
//	 located in the aspect package.
// - Add @EnableAspectJAutoProxy to this class to instruct Spring
//	 to process beans that have the @Aspect annotation.
//   (Note that this annotation is redundant for Spring Boot
//    application since it will be automatically added through
//    auto configuration.)
@Configuration
@ComponentScan("com.trendyol.bootcamp.spring.ch05.aspect")
@EnableAspectJAutoProxy
public class AspectsConfig {

	@Bean
	public MonitorFactory monitorFactory(){
		return new JamonMonitorFactory();
	}
	
}
