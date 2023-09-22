package com.trendyol.bootcamp.spring.ch04;

import com.trendyol.bootcamp.spring.ch04.config.RewardsConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;

@Configuration
@Import(RewardsConfig.class)
public class TestInfrastructureConfig {

    /**
     * Creates an in-memory "rewards" database populated
     * with test data for fast testing
     */
    @Bean
    public DataSource dataSource() {
        return
                (new EmbeddedDatabaseBuilder())
                        .addScript("classpath:testdb/schema.sql")
                        .addScript("classpath:testdb/data.sql")
                        .build();
    }
}
