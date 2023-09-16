package com.trendyol.bootcamp.spring.ch04.service;

import com.trendyol.bootcamp.spring.ch04.domain.Account;
import com.trendyol.bootcamp.spring.ch04.domain.AccountContribution;
import com.trendyol.bootcamp.spring.ch04.domain.Dining;
import com.trendyol.bootcamp.spring.ch04.domain.MonetaryAmount;
import com.trendyol.bootcamp.spring.ch04.domain.Restaurant;
import com.trendyol.bootcamp.spring.ch04.domain.RewardConfirmation;
import com.trendyol.bootcamp.spring.ch04.repository.account.AccountRepository;
import com.trendyol.bootcamp.spring.ch04.repository.restaurant.RestaurantRepository;
import com.trendyol.bootcamp.spring.ch04.repository.reward.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Rewards an Account for Dining at a Restaurant.
 *
 * The sole Reward Network implementation. This class is an
 * application-layer service responsible for coordinating with
 * the domain-layer to carry out the process of rewarding benefits
 * to accounts for dining.
 *
 * Said in other words, this class implements the "reward account
 * for dining" use case.
 */

/* TODO-03: Let this class to be found in component-scanning
 * - Annotate this class with an appropriate stereotype annotation
 *   to cause component-scanning to create a Spring bean from this class.
 * - Inject all 3 dependencies.  Decide if you should use field
 *   injection or constructor injection.
 */
@Component
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

	@Autowired
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