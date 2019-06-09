package com.sda.interfaces;

import java.util.List;

import com.sda.model.Region;


public interface IRegionService {

	List<Region> getAllRegions();

	void saveRegion(String newRegion);

	void deleteRegion(int id);

	void updateRegion(int id, String newName);

	Region getRegionById(int id);

}