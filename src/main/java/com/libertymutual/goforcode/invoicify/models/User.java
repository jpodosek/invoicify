package com.libertymutual.goforcode.invoicify.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="invoicify_user")
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false, unique=true)
	private String password;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="user", cascade=CascadeType.ALL) //cascade means any action to user, will flow down to associated entities
	private List<UserRole> roles;
	
	public User() {};
	
	public User(String username, String password, String roleName) {
		this.username = username;
		this.password = password;
		
		roles = new ArrayList<UserRole>();
		roles.add(new UserRole(roleName, this));
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		//granted authority spring uses to determine whether you can 
//		this converts List<UserRole> into a List<String> ; a map converts 1 to 1
//		List<String> roleNames = new ArrayList<String>();
//		for (UserRole role: roles) {
//			roleNames.add(role.getName());
//		}
		
		//"ROLE_" with spring, if you create a role, the granted authority needs to have ROLE_ in front of it
				//so .antMatchers("/admin/**").hasRole("ADMIN") would need ROLE_ADMIN	
		
		//Lambda same as loop above
		List<String> roleNames = roles.stream()
			.map(userRole -> "ROLE_" + userRole.getName())  // userRole is a variable name, represents individual user role in List<UserRole>
			.collect(Collectors.toList()); 
		
		String authorityString = String.join(",", roleNames);
		return AuthorityUtils.commaSeparatedStringToAuthorityList(authorityString);		
		
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserRole> getUserRoles() {
		return roles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.roles = userRoles;
	}
	
	
	
	
	
	
}
