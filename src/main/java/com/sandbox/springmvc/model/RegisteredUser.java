package com.sandbox.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "registereduser")
public class RegisteredUser {

	@Id
	@SequenceGenerator(name = "registereduser_id_seq_gen", sequenceName = "registereduser_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "registereduser_id_seq_gen")
	@Column(name = "id")
	private Long id;

	@Column(name = "username")
	private String username;

	@Column(name = "address")
	private String address;

	@Column(name = "email")
	private String email;

	public RegisteredUser() {
	}

	public RegisteredUser(long id, String username, String address, String email) {
		this.id = id;
		this.username = username;
		this.address = address;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof RegisteredUser))
			return false;
		RegisteredUser other = (RegisteredUser) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", address=" + address + ", email=" + email + "]";
	}

}
