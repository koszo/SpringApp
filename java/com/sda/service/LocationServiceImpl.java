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

import com.sda.interfaces.ILocationDao;
import com.sda.interfaces.ILocationService;
import com.sda.model.Country;
import com.sda.model.Location;
import com.sda.model.Region;

@Service
public class LocationServiceImpl implements ILocationService {

	@Autowired
	@Qualifier(value = "locationDaoImpl")
	private ILocationDao locationDao;
	private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	private List<Location> locations = new ArrayList<Location>();

	@Override
	public ILocationDao getRegionDao() {
		return locationDao;
	}

	@Override
	public void setLocationDao(ILocationDao LocationDao) {
		this.locationDao = LocationDao;
	}

	@Override
	public List<Location> getAllLocations() {
		System.out.println("  Entering RegionService.getAllLocations");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("  Calling LocationDao.getallLocations");
		locations = locationDao.getAllLocations(session);

		tx.commit();
		session.close();

		System.out.println("  Exiting LocationService.getAllLocations");
		return locations;
	}

	@Override
	public void saveLocation(double id, String newAddress, String newPostalCode, String newCity,
			String newStateProvince, Country country) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Location location = new Location();
		location.setLocationId(id);
		location.setStreetAddress(newAddress);
		location.setPostalCode(newPostalCode);
		location.setCity(newCity);
		location.setStateProvince(newStateProvince);
		location.setCountry(country);

		locationDao.saveLocation(session, location);

		tx.commit();
		session.close();

	}

	@Override
	public void deleteLocation(double id) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Location c = getLocationById(id);

		locationDao.deleteLocation(session, c);

		tx.commit();
		session.close();
	}

	@Override
	public void updateLocation(double id, String newAddress, String newPostalCode, String newCity,
			String newStateProvince, Country country) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Location c = session.get(Location.class, id);

		c.setCity(newCity);
		c.setLocationId(id);
		c.setPostalCode(newPostalCode);
		c.setStateProvince(newStateProvince);
		c.setStreetAddress(newAddress);
		c.setCountry(country);

		locationDao.updateLocation(session, c);

		tx.commit();
		session.close();
	}

	@Override
	public Location getLocationById(double id) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Location c = new Location();
		c = locationDao.getLocationById(session, id);

		tx.commit();
		session.close();

		return c;
	}

}
