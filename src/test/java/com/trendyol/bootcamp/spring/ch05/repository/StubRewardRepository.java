package com.trendyol.bootcamp.spring.ch05.repository;

import com.trendyol.bootcamp.spring.ch05.domain.AccountContribution;
import com.trendyol.bootcamp.spring.ch05.domain.Dining;
import com.trendyol.bootcamp.spring.ch05.domain.RewardConfirmation;
import com.trendyol.bootcamp.spring.ch05.repository.reward.RewardRepository;

import java.util.Random;

/**
 * A dummy reward repository implementation.
 */
public class StubRewardRepository implements RewardRepository {

	public RewardConfirmation updateReward(AccountContribution contribution, Dining dining) {
		return new RewardConfirmation(confirmationNumber(), contribution);
	}

	private String confirmationNumber() {
		return new Random().toString();
	}
}