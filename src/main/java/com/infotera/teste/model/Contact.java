package com.infotera.teste.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "contact")
public class Contact {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;
	
	@Column(name = "nm_contact", length = 45, nullable = false)
    private String name;
	
	@Column(name = "nr_telephone", length = 45, nullable = false)
    private String telephoneNumber;
	
	@Column(name = "nm_email", length = 45, nullable = false)
    private String email;

	public Long getId() {
		return id;
	}

	public Person getPerson() {
		return person;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
