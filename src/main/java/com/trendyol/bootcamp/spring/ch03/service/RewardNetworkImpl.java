package com.trendyol.bootcamp.spring.ch03.service;

import com.trendyol.bootcamp.spring.ch03.domain.Account;
import com.trendyol.bootcamp.spring.ch03.domain.AccountContribution;
import com.trendyol.bootcamp.spring.ch03.domain.Dining;
import com.trendyol.bootcamp.spring.ch03.domain.MonetaryAmount;
import com.trendyol.bootcamp.spring.ch03.domain.Restaurant;
import com.trendyol.bootcamp.spring.ch03.domain.RewardConfirmation;
import com.trendyol.bootcamp.spring.ch03.repository.account.AccountRepository;
import com.trendyol.bootcamp.spring.ch03.repository.restaurant.RestaurantRepository;
import com.trendyol.bootcamp.spring.ch03.repository.reward.RewardRepository;

/**
 * Rewards an Account for Dining at a Restaurant.
 * 
 * The sole Reward Network implementation. This object is an application-layer service responsible for coordinating with
 * the domain-layer to carry out the process of rewarding benefits to accounts for dining.
 * 
 * Said in other words, this class implements the "reward account for dining" use case.
 */
public class RewardNetworkImpl implements RewardNetwork {

	private AccountRepository accountRepository;

	private RestaurantRepository restaurantRepository;

	private RewardRepository rewardRepository;

	/**
	 * Creates a new reward network.
	 * @param accountRepository the repository for loading accounts to reward
	 * @param restaurantRepository the repository for loading restaurants that determine how much to reward
	 * @param rewardRepository the repository for recording a record of successful reward transactions
	 */
	public RewardNetworkImpl(AccountRepository accountRepository, RestaurantRepository restaurantRepository,
			RewardRepository rewardRepository) {
		this.accountRepository = accountRepository;
		this.restaurantRepository = restaurantRepository;
		this.rewardRepository = rewardRepository;
	}

	public RewardConfirmation rewardAccountFor(Dining dining) {
		Account account = accountRepository.findByCreditCard(dining.getCreditCardNumber());
		Restaurant restaurant = restaurantRepository.findByMerchantNumber(dining.getMerchantNumber());
		MonetaryAmount amount = restaurant.calculateBenefitFor(account, dining);
		AccountContribution contribution = account.makeContribution(amount);
		accountRepository.updateBeneficiaries(account);
		return rewardRepository.confirmReward(contribution, dining);
	}
}