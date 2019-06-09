package com.sda.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sda.interfaces.ILocationDao;
import com.sda.model.Location;



@Repository
public class LocationDaoImpl implements ILocationDao {

	
	@Override
	public List<Location> getAllLocations(Session session) {
		System.out.println("    Entering RegionDao.getAllLocations");

		Query query = session.createQuery("from Location");
		List<Location> locations = query.getResultList();

		System.out.println("    Exiting RegionDao.getAllRegions");
		return locations;
	}


	@Override
	public void saveLocation(Session session, Location location) {

		session.save(location);

	}

	
	@Override
	public void deleteLocation(Session session, Location location) {
		session.delete(location);
	}

	
	@Override
	public void updateLocation(Session session, Location location) {
		session.update(location);

	}

	
	@Override
	public Location getLocationById(Session session, double locationId) {

		Location location = new Location();

		location = session.get(Location.class, locationId);
		return location;
	}
	
	
	
}
