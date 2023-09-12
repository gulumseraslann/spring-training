package com.trendyol.bootcamp.spring.ch03.config;

import com.trendyol.bootcamp.spring.ch03.repository.account.AccountRepository;
import com.trendyol.bootcamp.spring.ch03.repository.account.JdbcAccountRepository;
import com.trendyol.bootcamp.spring.ch03.repository.restaurant.JdbcRestaurantRepository;
import com.trendyol.bootcamp.spring.ch03.repository.restaurant.RestaurantRepository;
import com.trendyol.bootcamp.spring.ch03.repository.reward.JdbcRewardRepository;
import com.trendyol.bootcamp.spring.ch03.repository.reward.RewardRepository;
import com.trendyol.bootcamp.spring.ch03.service.RewardNetwork;
import com.trendyol.bootcamp.spring.ch03.service.RewardNetworkImpl;
import org.assertj.core.api.Fail;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.sql.DataSource;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test the Spring configuration class to ensure it is creating the right
 * beans.
 */
@SuppressWarnings("unused")
public class RewardsConfigTest {
	// Provide a mock object for testing
	private DataSource dataSource = Mockito.mock(DataSource.class);

	// TODO-05: Run the test
	// - Uncomment the code below between /* and */
	// - If you have implemented RewardsConfig as requested it should compile.
	// - Fix RewardsConfig if necessary.
	// - Now run the test, it should pass.

	/*
	private RewardsConfig rewardsConfig = new RewardsConfig(dataSource);


	@Test
	public void getBeans() {
		RewardNetwork rewardNetwork = rewardsConfig.rewardNetwork();
		assertTrue(rewardNetwork instanceof RewardNetworkImpl);

		AccountRepository accountRepository = rewardsConfig.accountRepository();
		assertTrue(accountRepository instanceof JdbcAccountRepository);
		checkDataSource(accountRepository);

		RestaurantRepository restaurantRepository = rewardsConfig.restaurantRepository();
		assertTrue(restaurantRepository instanceof JdbcRestaurantRepository);
		checkDataSource(restaurantRepository);

		RewardRepository rewardsRepository = rewardsConfig.rewardRepository();
		assertTrue(rewardsRepository instanceof JdbcRewardRepository);
		checkDataSource(rewardsRepository);
	}
	*/

	/**
	 * Ensure the data-source is set for the repository. Uses reflection as we do
	 * not wish to provide a getDataSource() method.
	 * 
	 * @param repository One of our three repositories.
	 *
	 */
	private void checkDataSource(Object repository) {
		Class<? extends Object> repositoryClass = repository.getClass();

		try {
			Field dataSource = repositoryClass.getDeclaredField("dataSource");
			dataSource.setAccessible(true);
			assertNotNull(dataSource.get(repository));
		} catch (Exception e) {
			String failureMessage = "Unable to validate dataSource in " + repositoryClass.getSimpleName();
			System.out.println(failureMessage);
			e.printStackTrace();
			Fail.fail(failureMessage);
		}
	}
}
