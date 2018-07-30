package com.hhg.jerry.model;

/**
 * Created by lining on 2018/6/14.
 */
public class CityCountry {
    private Long id;
    private String name;
    private Country country;
    private String district;
    private Long population;

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
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
                ", country=" + country+
                ", district=" + district +
                ", population=" + population +
                 '}';
    }
}
