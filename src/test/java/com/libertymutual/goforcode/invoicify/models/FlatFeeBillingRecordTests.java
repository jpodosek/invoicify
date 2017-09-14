package com.libertymutual.goforcode.invoicify.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.ConfigurationBuilder;

public class FlatFeeBillingRecordTests {

	private FlatFeeBillingRecord billingRecord;

	@Before
	public void setUp() {
		billingRecord = new FlatFeeBillingRecord();
	}

	@Test
	public void test_all_getters_and_setters() {
		BeanTester tester = new BeanTester();

		Configuration configuration = new ConfigurationBuilder().ignoreProperty("createdOn").build();
		tester.testBean(FlatFeeBillingRecord.class, configuration);
	}

	@Test
	public void test_getTotal_returns_amount_of_FlatFeeBillingRecord() {
		// Arrange
		billingRecord.setAmount(5);

		// Act
		double actualAmount = billingRecord.getTotal();

		// Assert
		assertThat(actualAmount).isEqualTo(5);
	}
}
