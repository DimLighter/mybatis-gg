package com.hhg.jerry.model;

import org.apache.ibatis.annotations.Param;

/**
 * Created by lining on 2018/6/14.
 */
public class CityConstructor {
    private Long id;
    private String name;
    private String countryCode;
    private String district;
    private Long population;

    public CityConstructor(@Param(value = "id") Long id,
                           @Param(value = "name") String name,
                           @Param(value = "countryCode") String countryCode){
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

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

    @Override
    public String toString(){
        return "City{" +
                "id=" + id +
                ", name=" + name +
                ", countryCode=" + countryCode+
                ", district=" + district +
                ", population=" + population +
                 '}';
    }
}
