package com.trendyol.bootcamp.spring.ch03.service;

import com.trendyol.bootcamp.spring.ch03.domain.AccountContribution;
import com.trendyol.bootcamp.spring.ch03.domain.Dining;
import com.trendyol.bootcamp.spring.ch03.domain.MonetaryAmount;
import com.trendyol.bootcamp.spring.ch03.domain.RewardConfirmation;
import com.trendyol.bootcamp.spring.ch03.repository.StubAccountRepository;
import com.trendyol.bootcamp.spring.ch03.repository.StubRestaurantRepository;
import com.trendyol.bootcamp.spring.ch03.repository.StubRewardRepository;
import com.trendyol.bootcamp.spring.ch03.repository.account.AccountRepository;
import com.trendyol.bootcamp.spring.ch03.repository.restaurant.RestaurantRepository;
import com.trendyol.bootcamp.spring.ch03.repository.reward.RewardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Unit tests for the RewardNetworkImpl application logic. Configures the implementation with stub repositories
 * containing dummy data for fast in-memory testing without the overhead of an external data source.
 */
class RewardNetworkImplTests {

    /**
     * The object being tested.
     */
    private RewardNetworkImpl rewardNetwork;

    @BeforeEach
    public void setUp() throws Exception {
        AccountRepository accountRepo = new StubAccountRepository();
        RestaurantRepository restaurantRepo = new StubRestaurantRepository();
        RewardRepository rewardRepo = new StubRewardRepository();

        rewardNetwork = new RewardNetworkImpl(accountRepo, restaurantRepo, rewardRepo);
    }

    @Test
    void testRewardForDining() {
        Dining dining = Dining.createDining("100.00", "1234123412341234", "1234567890");

        RewardConfirmation confirmation = rewardNetwork.rewardAccountFor(dining);

        assertNotNull(confirmation);
        assertNotNull(confirmation.getConfirmationNumber());

        AccountContribution contribution = confirmation.getAccountContribution();
        assertNotNull(contribution);

        assertEquals("123456789", contribution.getAccountNumber());

        assertEquals(MonetaryAmount.valueOf("8.00"), contribution.getAmount());

        assertEquals(2, contribution.getDistributions().size());

        assertEquals(MonetaryAmount.valueOf("4.00"), contribution.getDistribution("Annabelle").getAmount());
        assertEquals(MonetaryAmount.valueOf("4.00"), contribution.getDistribution("Corgan").getAmount());
    }
}