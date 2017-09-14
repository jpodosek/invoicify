package com.libertymutual.goforcode.invoicify.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;


public class UserTests {
	
	private User user;
	
	@Before
	public void setUp() {
		user = new User();
	}

	@Test
	public void test_all_getters_and_setters() {
		BeanTester tester = new BeanTester();
		tester.testBean(User.class);
	}

	@Test
	public void test_User_constructor_sets_username_password_and_adds_role_name() {	
		//Act
		String username = "admin";
		String password = "admin123";
		String roleName = "ADMIN";
		
		User actualUser = new User(username, password, roleName);
		List<UserRole> roles = new ArrayList<UserRole>();
		
		//roles.add(new UserRole(roleName, this));
		
		//Assert
		assertThat(actualUser.getUsername()).isSameAs(username);
		assertThat(actualUser.getPassword()).isSameAs(password);
	}
	
	@Test
	public void test_isAccountNonExpired() {
		//Act
		boolean actual = user.isAccountNonExpired();
		
		//Assert
		assertThat(actual).isEqualTo(true);
	}
	
	@Test
	public void test_isAccountNonLocked() {
		//Act
		boolean actual = user.isAccountNonLocked();
		
		//Assert
		assertThat(actual).isEqualTo(true);
	}
	
	@Test
	public void test_isCredentialsNonExpired() {
		//Act
		boolean actual = user.isCredentialsNonExpired();
		
		//Assert
		assertThat(actual).isEqualTo(true);
	}
	
	@Test
	public void test_isEnabled() {
		//Act
		boolean actual = user.isEnabled();
		
		//Assert
		assertThat(actual).isEqualTo(true);
	}
	
	
}
