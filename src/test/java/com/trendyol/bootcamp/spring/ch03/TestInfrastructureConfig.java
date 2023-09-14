package com.trendyol.bootcamp.spring.ch03;

import com.trendyol.bootcamp.spring.ch03.config.RewardsConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;

/**
 * TODO-06: Study this configuration class used for testing
 * - It contains a @Bean method that returns DataSource.
 * - It also creates and populates in-memory HSQL database tables
 *   using two SQL scripts.
 * - Note that the two scripts are located under the
 *   'test/resources/testdb' directory of
 * - Do not modify this method.
 *
 * TODO-07: Import your application configuration file (RewardsConfig)
 * - Now the test code should have access to all the beans defined in
 *   the RewardsConfig configuration class
 *
 * TODO-08: Go to the RewardNetworkTests class
 *
 */
@Configuration
public class TestInfrastructureConfig {

	/**
	 * Creates an in-memory "rewards" database populated
	 * with test data for fast testing
	 */
	@Bean
	public DataSource dataSource() {
		return (new EmbeddedDatabaseBuilder()) 
				.addScript("classpath:testdb/schema.sql")
				.addScript("classpath:testdb/data.sql")
				.build();
	}
}
