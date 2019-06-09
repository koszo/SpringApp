package com.sda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Locations")
public class Location {

	@Id
	@Column(name = "LOCATION_ID")
	private double locationId;
	@Column(name = "STREET_ADDRESS")
	private String streetAddress;
	@Column(name = "POSTAL_CODE")
	private String postalCode;
	@Column(name = "City")
	private String city;
	@Column(name = "STATE_PROVINCE")
	private String stateProvince;
	
	@ManyToOne
    @JoinColumn(name = "COUNTRY_ID", nullable=false)
	private Country country;

	
	
	
	
	
	public Location() {
		super();
	}

	public Location(double locationId, String streetAddress, String postalCode, String city, String stateProvince,
			Country country) {
		super();
		this.locationId = locationId;
		this.streetAddress = streetAddress;
		this.postalCode = postalCode;
		this.city = city;
		this.stateProvince = stateProvince;
		this.country = country;
	}

	public double getLocationId() {
		return locationId;
	}

	public void setLocationId(double locationId) {
		this.locationId = locationId;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	
	
	
	
	
	
}
