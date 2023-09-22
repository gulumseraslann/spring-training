package com.trendyol.bootcamp.spring.ch04.restaurant;

import com.trendyol.bootcamp.spring.ch04.domain.Percentage;
import com.trendyol.bootcamp.spring.ch04.domain.Restaurant;
import com.trendyol.bootcamp.spring.ch04.repository.restaurant.JdbcRestaurantRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Tests the JDBC restaurant repository with a test data source to verify data access and relational-to-object mapping
 * behavior works as expected.
 */
class JdbcRestaurantRepositoryTest {

    private JdbcRestaurantRepository repository;

    @BeforeEach
    public void setUp() throws Exception {
        // simulate the Spring bean initialization lifecycle:
        // first, construct the bean
        repository = new JdbcRestaurantRepository();

        // then, inject its dependencies
        repository.setDataSource(createTestDataSource());

        // lastly, initialize the bean
        repository.populateRestaurantCache();
    }

    @AfterEach
    public void tearDown() throws Exception {
        // simulate the Spring bean destruction lifecycle:
        repository.clearRestaurantCache();
    }

    @Test
    void findRestaurantByMerchantNumber() {
        Restaurant restaurant = repository.findByMerchantNumber("1234567890");
        assertNotNull(restaurant, "restaurant is null - check your repositories cache");
        assertEquals("1234567890", restaurant.getNumber(), "number is wrong");
        assertEquals("AppleBees", restaurant.getName(), "name is wrong");
        assertEquals(Percentage.valueOf("8%"), restaurant.getBenefitPercentage(), "benefitPercentage is wrong");
    }

    @Test
    void findRestaurantByBogusMerchantNumber() {
        assertThrows(EmptyResultDataAccessException.class, () -> {
            repository.findByMerchantNumber("bogus");
        });
    }

    @Test
    void restaurantCacheClearedAfterDestroy() throws Exception {
        // force early tear down
        tearDown();
        assertThrows(EmptyResultDataAccessException.class, () -> {
            repository.findByMerchantNumber("1234567890");
        });
    }

    private DataSource createTestDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setName("rewards")
                .addScript("/testdb/schema.sql")
                .addScript("/testdb/data.sql")
                .build();
    }

}