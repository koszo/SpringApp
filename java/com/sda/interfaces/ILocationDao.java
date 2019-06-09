package com.sda.interfaces;

import java.util.List;

import org.hibernate.Session;

import com.sda.model.Location;

public interface ILocationDao {

	List<Location> getAllLocations(Session session);

	void saveLocation(Session session, Location location);

	void deleteLocation(Session session, Location location);

	void updateLocation(Session session, Location location);

	Location getLocationById(Session session, double locationId);

}