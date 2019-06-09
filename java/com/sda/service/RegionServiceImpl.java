package com.sda.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sda.interfaces.IRegionDao;
import com.sda.interfaces.IRegionService;
import com.sda.model.Region;


@Service
@Transactional
public class RegionServiceImpl implements IRegionService {

	@Autowired
	@Qualifier(value="regionDaoImpl")
	private IRegionDao regionDao;

	public IRegionDao getRegionDao() {
		return regionDao;
	}

	public void setRegionDao(IRegionDao regionDao) {
		this.regionDao = regionDao;
	}

	public List<Region> getAllRegions() {
		System.out.println("  Entering RegionService.getAllRegions");
		System.out.println("  Calling RegionDao.getAllRegions");
		List<Region> regions = regionDao.getAllRegions();


		System.out.println("  Exiting RegionService.getAllRegions");
		return regions;
	}

	public void saveRegion(String newRegion) {

		Region region = new Region();
		region.setRegionName(newRegion);

		regionDao.saveRegion(region);


	}

	public void deleteRegion(int id) {

		Region r = new Region();
		r.setRegionId(id);

		regionDao.deleteRegion(r);

	}

	public void updateRegion(int id, String newName) {


		Region r = getRegionById(id);

		r.setRegionName(newName);

		regionDao.updateRegion( r);

	}

	public Region getRegionById(int id) {


		Region r = new Region();
		r = regionDao.getRegionById( id);


		return r;
	}
}
