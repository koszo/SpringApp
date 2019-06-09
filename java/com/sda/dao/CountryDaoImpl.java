package com.sda.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sda.interfaces.ICountryDao;
import com.sda.model.Country;

@Repository
public class CountryDaoImpl implements ICountryDao {

	
	@Override
	public List<Country> getAllCountries(Session session) {
		System.out.println("    Entering RegionDao.getAllCountries");

		Query query = session.createQuery("from Country");
		List<Country> countries = query.getResultList();

		System.out.println("    Exiting RegionDao.getAllRegions");
		return countries;
	}


	@Override
	public void saveCountry(Session session, Country country) {

		session.save(country);

	}

	
	@Override
	public void deleteCountry(Session session, Country country) {
		session.delete(country);
	}

	
	@Override
	public void updateCountry(Session session, Country country) {
		session.update(country);

	}

	
	@Override
	public Country getCountryById(Session session, String countryId) {

		Country country = new Country();

		country = session.get(Country.class, countryId);
		return country;
	}
	
	
}
