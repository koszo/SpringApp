package com.sda.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sda.interfaces.ICountryService;
import com.sda.interfaces.IRegionService;
import com.sda.model.Country;
import com.sda.model.Region;

@Controller
@RequestMapping("/country")
public class CountryController {

	@Autowired
	private ICountryService countryService;
	@Autowired
	private IRegionService regionService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listCountry(ModelMap model) {
		List<Country> countries = countryService.getAllCountries();

		model.addAttribute("countryList", countries);
		
		// returnam .jsp ul
		return "countryList";
	}
	
	@RequestMapping(value = "/listbyregion", method = RequestMethod.GET)
	public String listByRegion(ModelMap model, @RequestParam("regionId") int id) {
		Region region = regionService.getRegionById(id);
		
		
		

		model.addAttribute("countryList", region.getCountries());
		
		// returnam .jsp ul
		return "countryList";
	}
	
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createCountry(ModelMap model) {

		

		model.addAttribute("regionList", regionService.getAllRegions());
		
		// returnam .jsp ul
		return "countryCreate";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createCountry(ModelMap model, @RequestParam("regionId") int id,
			@RequestParam("newCountryId") String countryId, @RequestParam("newCountryName") String countryName) {
		Region region = regionService.getRegionById(id);

		countryService.saveCountry(countryId, countryName, region);
		
		List<Country> countries = countryService.getAllCountries();
		
		model.addAttribute("countryList", countryService.getAllCountries());

		// returnam .jsp ul
		return "countryList";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteCountry(ModelMap model, @RequestParam("countryId") String id) {
	
		try {
		countryService.deleteCountry(id);
		} catch(Exception e) {
			String errorMessage = "Cannot delete countries with locations still assigned to it.";
			model.addAttribute("errorMessage", errorMessage);
			
		}
		model.addAttribute("countryList", countryService.getAllCountries());

		
		// returnam .jsp ul
		return "countryList";
		
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateCountry(ModelMap model, @RequestParam("countryId") String id) {
				
		Country country = countryService.getCountryById(id);
		model.addAttribute("country", country);
		model.addAttribute("regionList", regionService.getAllRegions());
		
		// returnam .jsp ul
		return "countryUpdate";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCountries(ModelMap model, @RequestParam("countryName") String countryName, @RequestParam("countryId") String id, @RequestParam("regionId") int regionId) {
		
		Region region = regionService.getRegionById(regionId);
		
		countryService.updateCountry(id, countryName, region);
		
		model.addAttribute("countryList", countryService.getAllCountries());

		
		// returnam .jsp ul
		return "countryList";
	}
	
}
