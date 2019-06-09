package com.sda.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sda.interfaces.IRegionService;
import com.sda.model.Region;
import com.sda.service.RegionServiceImpl;

@Controller
@RequestMapping("/region")
public class RegionController {

	@Autowired
	private IRegionService regionService;
	List<Region> regions;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listRegion(ModelMap model) {
		regions = regionService.getAllRegions();

		model.addAttribute("regionList", regions);
		
		// returnam .jsp ul
		return "regionList";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createRegions(ModelMap model, @RequestParam("newRegion") String regionName) {

		

		model.addAttribute("regionList", regionService.getAllRegions());
		
		// returnam .jsp ul
		return "regionCreate";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createRegion(ModelMap model, @RequestParam("newRegion") String regionName) {

		regionService.saveRegion(regionName);

		model.addAttribute("regionList", regionService.getAllRegions());
		
		// returnam .jsp ul
		return "regionList";
	}

	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteRegion(ModelMap model, @RequestParam("regionId") int id) {
		
		
		try {
		regionService.deleteRegion(id);
		} catch(Exception e) {
			String errorMessage ="Can't delete region because it has countries assigned to it";
			model.addAttribute("errorMessage", errorMessage);
			
		}finally {
		model.addAttribute("regionList", regionService.getAllRegions());

		
		// returnam .jsp ul
		return "regionList";
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateRegion(ModelMap model, @RequestParam("regionId") int id) {
		Region region = regionService.getRegionById(id);

		model.addAttribute("region", region);

		
		// returnam .jsp ul
		return "regionUpdate";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateRegions(ModelMap model, @RequestParam("regionName") String regionName, @RequestParam("regionId") int id) {
		
		regionService.saveRegion(regionName);
		
		
		model.addAttribute("regionList", regionService.getAllRegions());

		
		// returnam .jsp ul
		return "regionList";
	}
}
