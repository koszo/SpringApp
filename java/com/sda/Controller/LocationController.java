package com.sda.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sda.interfaces.ILocationService;
import com.sda.interfaces.ILocationService;
import com.sda.interfaces.ICountryService;
import com.sda.model.Location;
import com.sda.model.Location;
import com.sda.model.Country;

@Controller
@RequestMapping("/location")
public class LocationController {

	@Autowired
	private ICountryService countryService;
	@Autowired
	private ILocationService locationService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listLocation(ModelMap model) {
		List<Location> locations = locationService.getAllLocations();

		model.addAttribute("locationList", locations);

		// returnam .jsp ul
		return "locationList";
	}

	@RequestMapping(value = "/listByCountry", method = RequestMethod.GET)
	public String listByCountry(ModelMap model, @RequestParam("countryId") String id) {
		Country country = countryService.getCountryById(id);

		model.addAttribute("locationList", country.getLocations());

		// returnam .jsp ul
		return "locationList";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createLocation(ModelMap model) {

		model.addAttribute("countryList", countryService.getAllCountries());

		// returnam .jsp ul
		return "locationCreate";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createLocation(ModelMap model, @RequestParam("newLocationId") double locationId,
			@RequestParam("newAddress") String newAddress, @RequestParam("newPostalCode") String newPostalCode,
			@RequestParam("newCity") String newCity, @RequestParam("newStateProvince") String newStateProvince,
			@RequestParam("countryId") String countryId) {
		Country country = countryService.getCountryById(countryId);

		locationService.saveLocation(locationId, newAddress, newPostalCode, newCity, newStateProvince, country);

		List<Location> locations = locationService.getAllLocations();

		model.addAttribute("locationList", locationService.getAllLocations());

		// returnam .jsp ul
		return "locationList";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteLocation(ModelMap model, @RequestParam("locationId") double id) {
		locationService.deleteLocation(id);

		model.addAttribute("locationList", locationService.getAllLocations());

		// returnam .jsp ul
		return "locationList";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateLocation(ModelMap model, @RequestParam("locationId") double id) {

		Location location = locationService.getLocationById(id);
		model.addAttribute("location", location);
		model.addAttribute("countryList", countryService.getAllCountries());

		// returnam .jsp ul
		return "locationUpdate";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateLocations(ModelMap model,@RequestParam("locationId") double id, @RequestParam("streetAddress") String streetAddress,
			@RequestParam("postalCode") String postalCode, 
			@RequestParam("city") String city, @RequestParam("stateProvince") String stateProvince,
			@RequestParam("countryId") String countryId) {

		Country country = countryService.getCountryById(countryId);

		locationService.updateLocation(id, streetAddress, postalCode, city, stateProvince, country);

		model.addAttribute("locationList", locationService.getAllLocations());

		// returnam .jsp ul
		return "locationList";
	}

}
