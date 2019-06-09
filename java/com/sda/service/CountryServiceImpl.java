package com.sda.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sda.interfaces.ICountryDao;
import com.sda.interfaces.ICountryService;
import com.sda.model.Country;
import com.sda.model.Region;

@Service
public class CountryServiceImpl implements ICountryService {

	@Autowired
	@Qualifier(value="countryDaoImpl")
	private ICountryDao countryDao;
	private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	private List<Country> countries = new ArrayList<Country>();

	
	public ICountryDao getRegionDao() {
		return countryDao;
	}

	
	public void setCountryDao(ICountryDao countryDao) {
		this.countryDao = countryDao;
	}

	@Override
	public List<Country> getAllCountries() {
		System.out.println("  Entering RegionService.getAllCountries");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("  Calling CountryDao.getallCountries");
		countries = countryDao.getAllCountries(session);

		tx.commit();
		session.close();

		System.out.println("  Exiting CountryService.getAllCountries");
		return countries;
	}

	@Override
	public void saveCountry(String id, String newCountry, Region region) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		
		Country country = new Country();
		country.setCountryName(newCountry);
		country.setCountryId(id);
		country.setRegion(region);
		
		countryDao.saveCountry(session, country);

		tx.commit();
		session.close();

	}

	@Override
	public void deleteCountry(String id) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Country c = new Country();
		c.setCountryId(id);

		countryDao.deleteCountry(session, c);

		tx.commit();
		session.close();
	}

	@Override
	public void updateCountry(String id, String newName, Region region) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Country c = session.get(Country.class, id);

		c.setCountryName(newName);
		c.setRegion(region);

		countryDao.updateCountry(session, c);

		tx.commit();
		session.close();
	}

	@Override
	public Country getCountryById(String id) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Country c = new Country();
		c = countryDao.getCountryById(session, id);

		tx.commit();
		session.close();

		return c;
	}
	
	
}
