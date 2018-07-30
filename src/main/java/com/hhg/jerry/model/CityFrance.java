package com.hhg.jerry.model;

/**
 * Created by lining on 2018/6/14.
 */
public class CityFrance extends CityBase{
    private String district;
    private Long population;

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }
}
