package com.libertymutual.goforcode.invoicify.models;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.meanbean.test.BeanTester;

public class UserRoleTests {

	@Test
	public void test_all_getters_and_setters() {
		new BeanTester().testBean(UserRole.class);
	}
	
	@Test
	public void test_UserRole_sets_name_and_user() {	
		//Act	
		User user = new User();
		UserRole actualRole = new UserRole("ADMIN", user);
		
		//Assert
		assertThat(actualRole.getName()).isEqualTo("ADMIN");
		assertThat(actualRole.getUser()).isSameAs(user);
	}

}
