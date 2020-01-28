package com.example.authService.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;


@Entity
public class User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String password;
    
    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="user_roles", 
			joinColumns = @JoinColumn(name="user_id", referencedColumnName = "id"),
		    inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	public Set<UserRole> roles;
    
   
	public User() {}

	
	 public Set<UserRole> getRoles() {
			return roles;
		}

		public void setRoles(Set<UserRole> roles) {
			this.roles = roles;
		}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}



    
}
