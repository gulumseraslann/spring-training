package com.trendyol.bootcamp.spring.ch04.restaurant;

import com.trendyol.bootcamp.spring.ch04.domain.AccountContribution;
import com.trendyol.bootcamp.spring.ch04.domain.Dining;
import com.trendyol.bootcamp.spring.ch04.domain.RewardConfirmation;
import com.trendyol.bootcamp.spring.ch04.repository.reward.RewardRepository;

import java.util.Random;

/**
 * A dummy reward repository implementation.
 */
public class StubRewardRepository implements RewardRepository {

	public RewardConfirmation confirmReward(AccountContribution contribution, Dining dining) {
		return new RewardConfirmation(confirmationNumber(), contribution);
	}

	private String confirmationNumber() {
		return new Random().toString();
	}
}