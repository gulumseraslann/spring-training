package com.trendyol.bootcamp.spring.solution.ch03.config;

import com.trendyol.bootcamp.spring.solution.ch03.repository.account.AccountRepository;
import com.trendyol.bootcamp.spring.solution.ch03.repository.account.JdbcAccountRepository;
import com.trendyol.bootcamp.spring.solution.ch03.repository.restaurant.JdbcRestaurantRepository;
import com.trendyol.bootcamp.spring.solution.ch03.repository.restaurant.RestaurantRepository;
import com.trendyol.bootcamp.spring.solution.ch03.repository.reward.JdbcRewardRepository;
import com.trendyol.bootcamp.spring.solution.ch03.repository.reward.RewardRepository;
import com.trendyol.bootcamp.spring.solution.ch03.service.RewardNetwork;
import com.trendyol.bootcamp.spring.solution.ch03.service.RewardNetworkImpl;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * TODO-00: In this lab, you are going to exercise the following:
 * - Creating Spring configuration class
 * - Defining bean definitions within the configuration class
 * - Specifying the dependency relationships among beans
 * - Injecting dependencies through constructor injection
 * - Creating Spring application context in the test code
 *   (WITHOUT using Spring testContext framework)
 *
 * TODO-01: Make this class a Spring configuration class
 * - Use an appropriate annotation.
 *
 * TODO-02: Define four empty @Bean methods, one for the
 *          reward-network and three for the repositories.
 * - The names of the beans should be:
 *   - rewardNetwork
 *   - accountRepository
 *   - restaurantRepository
 *   - rewardRepository
 *
 * TODO-03: Inject DataSource through constructor injection
 * - Each repository implementation has a DataSource
 *   property to be set, but the DataSource is defined
 *   elsewhere (TestInfrastructureConfig.java), so you
 *   will need to define a constructor for this class
 *   that accepts a DataSource parameter.
 * - As it is the only constructor, @Autowired is optional.
 *
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

	private DataSource dataSource;

	// As this is the only constructor, @Autowired is not needed.
	public RewardsConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Bean
	public RewardNetwork rewardNetwork(){
		return new RewardNetworkImpl(
				accountRepository(),
				restaurantRepository(),
				rewardRepository());
	}

	@Bean
	public AccountRepository accountRepository(){
		JdbcAccountRepository repository = new JdbcAccountRepository();
		repository.setDataSource(dataSource);
		return repository;
	}

	@Bean
	public RestaurantRepository restaurantRepository(){
		JdbcRestaurantRepository repository = new JdbcRestaurantRepository();
		repository.setDataSource(dataSource);
		return repository;
	}

	@Bean
	public RewardRepository rewardRepository(){
		JdbcRewardRepository repository = new JdbcRewardRepository();
		repository.setDataSource(dataSource);
		return repository;
	}

}
