package com.trendyol.bootcamp.spring.ch05.config;

import com.trendyol.bootcamp.spring.ch05.repository.account.AccountRepository;
import com.trendyol.bootcamp.spring.ch05.repository.account.JdbcAccountRepository;
import com.trendyol.bootcamp.spring.ch05.repository.restaurant.JdbcRestaurantRepository;
import com.trendyol.bootcamp.spring.ch05.repository.reward.JdbcRewardRepository;
import com.trendyol.bootcamp.spring.ch05.repository.restaurant.RestaurantRepository;
import com.trendyol.bootcamp.spring.ch05.service.RewardNetwork;
import com.trendyol.bootcamp.spring.ch05.service.RewardNetworkImpl;
import com.trendyol.bootcamp.spring.ch05.repository.reward.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class RewardsConfig {

	@Autowired
	DataSource dataSource;
		
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
