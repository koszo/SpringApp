package com.sda.interfaces;

import java.util.List;

import com.sda.model.Country;
import com.sda.model.Region;

public interface ICountryService {


	List<Country> getAllCountries();

	void saveCountry(String id, String newCountry, Region region);

	void deleteCountry(String id);

	void updateCountry(String id, String newName, Region region);

	Country getCountryById(String id);

}