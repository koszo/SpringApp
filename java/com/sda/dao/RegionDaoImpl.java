package com.sda.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sda.interfaces.IRegionDao;
import com.sda.model.Region;

@Repository
public class RegionDaoImpl implements IRegionDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Region> getAllRegions() {
		System.out.println("    Entering RegionDao.getAllRegions");

		Query query = sessionFactory.getCurrentSession().createQuery("from Region");
		List<Region> regions = query.getResultList();

		System.out.println("    Exiting RegionDao.getAllRegions");
		return regions;
	}


	public void saveRegion(Region region) {

		sessionFactory.getCurrentSession().save(region);

	}


	public void deleteRegion(Region region) {
		sessionFactory.getCurrentSession().delete(region);
	}
	
	

	public void updateRegion(Region region) {
		sessionFactory.getCurrentSession().update(region);

	}
	

	public Region getRegionById(int regionId) {

		Region region = new Region();

		region = sessionFactory.getCurrentSession().get(Region.class, regionId);
		return region;
	}
	


}
