package com.sda.interfaces;

import java.util.List;

import com.sda.model.Country;
import com.sda.model.Location;
import com.sda.model.Region;

public interface ILocationService {

	ILocationDao getRegionDao();

	void setLocationDao(ILocationDao LocationDao);

	List<Location> getAllLocations();

	void saveLocation(double id, String newAddress, String newPostalCode, String newCity, String newStateProvince,
			Country country);

	void deleteLocation(double id);

	void updateLocation(double id, String newAddress, String newPostalCode, String newCity, String newStateProvince,
			Country country);

	Location getLocationById(double id);

}