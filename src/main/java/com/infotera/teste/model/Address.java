package com.infotera.teste.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "address")
public class Address{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;
	
	@Column(name = "nm_address", length = 500, nullable = false)
	@NotEmpty
	private String addressName;
	
	@Column(name = "nr_address", length = 10, nullable = false)
	@NotEmpty
	private String addressNumber;
	
	@Column(name = "nm_city", length = 20, nullable = false)
	@NotEmpty
	private String cityName;
		
	@Column(name = "nm_state", length = 20, nullable = false)
	@NotEmpty
	private String stateName;
	
	@Column(name = "nm_country", length = 20, nullable = false)
	@NotEmpty
	private String countryName;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date", nullable = false)
	private Date creationDate = new Date();
	
	public Long getId() {
		return id;
	}

	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getAddressNumber() {
		return addressNumber;
	}

	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}
