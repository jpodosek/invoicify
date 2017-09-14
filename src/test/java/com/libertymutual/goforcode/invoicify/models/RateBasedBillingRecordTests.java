package com.libertymutual.goforcode.invoicify.models;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.ConfigurationBuilder;

public class RateBasedBillingRecordTests {

	private RateBasedBillingRecord billingRecord;

	@Before
	public void setUp() {
		billingRecord = new RateBasedBillingRecord();
	}

	@Test
	public void test_all_getters_and_setters() {
		BeanTester tester = new BeanTester();

		Configuration configuration = new ConfigurationBuilder().ignoreProperty("createdOn").build();
		tester.testBean(RateBasedBillingRecord.class, configuration);
	}

	@Test
	public void test_getTotal_returns_the_product_of_rate_and_quantity_of_RateBasedBillingRecord() {
		// Arrange
		billingRecord.setQuantity(5);
		billingRecord.setRate(4);

		// Act
		double actualTotal = billingRecord.getTotal();

		// Assert
		assertThat(actualTotal).isEqualTo(20);

	}

}
