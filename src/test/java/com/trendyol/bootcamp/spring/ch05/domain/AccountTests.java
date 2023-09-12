package com.trendyol.bootcamp.spring.ch05.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for the Account class that verify Account behavior works in isolation.
 */
class AccountTests {

	private Account account = new Account("1", "Keith and Keri Donald");

	@Test
	void accountIsValid() {
		// setup account with a valid set of beneficiaries to prepare for testing
		account.addBeneficiary("Annabelle", Percentage.valueOf("50%"));
		account.addBeneficiary("Corgan", Percentage.valueOf("50%"));
		assertTrue(account.isValid());
	}

	@Test
	void accountIsInvalidWithNoBeneficiaries() {
		assertFalse(account.isValid());
	}

	@Test
	void accountIsInvalidWhenBeneficiaryAllocationsAreOver100() {
		account.addBeneficiary("Annabelle", Percentage.valueOf("50%"));
		account.addBeneficiary("Corgan", Percentage.valueOf("100%"));
		assertFalse(account.isValid());
	}

	@Test
	void accountIsInvalidWhenBeneficiaryAllocationsAreUnder100() {
		account.addBeneficiary("Annabelle", Percentage.valueOf("50%"));
		account.addBeneficiary("Corgan", Percentage.valueOf("25%"));
		assertFalse(account.isValid());
	}

	@Test
	void makeContribution() {
		account.addBeneficiary("Annabelle", Percentage.valueOf("50%"));
		account.addBeneficiary("Corgan", Percentage.valueOf("50%"));
		AccountContribution contribution = account.makeContribution(MonetaryAmount.valueOf("100.00"));
		assertEquals(contribution.getAmount(), MonetaryAmount.valueOf("100.00"));
		assertEquals(MonetaryAmount.valueOf("50.00"), contribution.getDistribution("Annabelle").getAmount());
		assertEquals(MonetaryAmount.valueOf("50.00"), contribution.getDistribution("Corgan").getAmount());
	}
}