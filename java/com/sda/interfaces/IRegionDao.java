package com.sda.interfaces;

import java.util.List;

import org.hibernate.Session;

import com.sda.model.Region;

public interface IRegionDao {

	List<Region> getAllRegions();

	void saveRegion(Region region);

	void deleteRegion(Region region);

	void updateRegion(Region region);

	Region getRegionById(int regionId);

}