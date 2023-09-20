package com.trendyol.bootcamp.spring.ch05.service;

import com.trendyol.bootcamp.spring.ch05.domain.Account;
import com.trendyol.bootcamp.spring.ch05.domain.Dining;

/**
 * Determines if benefit is available for an account for dining.
 * <p>
 * A value object. A strategy. Scoped by the Resturant aggregate.
 */
public interface BenefitAvailabilityPolicy {

    /**
     * Calculates if an account is eligible to receive benefits for a dining.
     *
     * @param account the account of the member who dined
     * @param dining  the dining event
     * @return benefit availability status
     */
    boolean isBenefitAvailableFor(Account account, Dining dining);
}
