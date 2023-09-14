package com.trendyol.bootcamp.spring.ch03.config;

import com.trendyol.bootcamp.spring.ch03.repository.account.AccountRepository;
import com.trendyol.bootcamp.spring.ch03.repository.account.JdbcAccountRepository;
import com.trendyol.bootcamp.spring.ch03.repository.restaurant.JdbcRestaurantRepository;
import com.trendyol.bootcamp.spring.ch03.repository.restaurant.RestaurantRepository;
import com.trendyol.bootcamp.spring.ch03.repository.reward.JdbcRewardRepository;
import com.trendyol.bootcamp.spring.ch03.repository.reward.RewardRepository;
import com.trendyol.bootcamp.spring.ch03.service.RewardNetwork;
import com.trendyol.bootcamp.spring.ch03.service.RewardNetworkImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * TODO-00: In this lab, you are going to exercise the following:
 * - Creating Spring configuration class
 * - Defining bean definitions within the configuration class
 * - Specifying the dependency relationships among beans
 * - Injecting dependencies through constructor injection
 * - Creating Spring application context in the test code
 *   (WITHOUT using Spring testContext framework)
 * <p>
 * TODO-01: Make this class a Spring configuration class
 * - Use an appropriate annotation.
 * <p>
 * TODO-02: Define four empty @Bean methods, one for the
 *          reward-network and three for the repositories.
 * - The names of the beans should be:
 *   - rewardNetwork
 *   - accountRepository
 *   - restaurantRepository
 *   - rewardRepository
 * <p>
 * TODO-03: Inject DataSource through constructor injection
 * - Each repository implementation has a DataSource
 *   property to be set, but the DataSource is defined
 *   elsewhere (TestInfrastructureConfig.java), so you
 *   will need to define a constructor for this class
 *   that accepts a DataSource parameter.
 * - As it is the only constructor, @Autowired is optional.
 * <p>
 * TODO-04: Implement each @Bean method to contain the code
 *          needed to instantiate its object and set its
 *          dependencies
 * - You can create beans from the following implementation classes
 *   - rewardNetwork bean from RewardNetworkImpl class
 *   - accountRepository bean from JdbcAccountRepository class
 *   - restaurantRepository bean from JdbcRestaurantRepository class
 *   - rewardRepository bean from JdbcRewardRepository class
 * - Note that return type of each bean method should be an interface
 *   not an implementation.
 */

public class RewardsConfig {

    // Set this by adding a constructor.
    private DataSource dataSource;

}
