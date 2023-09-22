package com.trendyol.bootcamp.spring.ch05;

import com.trendyol.bootcamp.spring.ch05.config.AspectsConfig;
import com.trendyol.bootcamp.spring.ch05.config.RewardsConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;


/** 
 * TODO-05: Make this configuration include the aspect configuration. 
 * Save all your work, run the LoggingAspectTests.  It should pass, 
 * and you should see one line of LoggingAspect output in the console.	 
 */
@Configuration
@Import({AspectsConfig.class, RewardsConfig.class})
public class SystemTestConfig {

	
	/**
	 * Creates an in-memory "rewards" database populated 
	 * with test data for fast testing
	 */
	@Bean
	public DataSource dataSource(){
		return
			(new EmbeddedDatabaseBuilder())
			.addScript("classpath:testdb/schema.sql")
			.addScript("classpath:testdb/data.sql")
			.build();
	}	
	
}
