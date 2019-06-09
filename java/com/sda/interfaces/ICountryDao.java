package com.sda.interfaces;

import java.util.List;

import org.hibernate.Session;

import com.sda.model.Country;

public interface ICountryDao {

	List<Country> getAllCountries(Session session);

	void saveCountry(Session session, Country country);

	void deleteCountry(Session session, Country country);

	void updateCountry(Session session, Country country);

	Country getCountryById(Session session, String countryId);

}