package com.sda.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Regions")
public class Region {

    @Id
    @Column(name = "REGION_ID")
    private int regionId;
    @Column(name = "REGION_NAME")
    private String name;
    
    @OneToMany(mappedBy="region", fetch = FetchType.EAGER)
    private List<Country> countries;
    
    
    
    public Region() {
        super();
    }

    public Region(int regionId, String regionName) {
        super();
        this.regionId = regionId;
        this.name = regionName;
    }

    
    
    public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return name;
    }

    public void setRegionName(String regionName) {
        this.name = regionName;
    }

    @Override
    public String toString() {
        return "Regions [regionId=" + regionId + ", regionName=" + name + "]\n";
    }

}
