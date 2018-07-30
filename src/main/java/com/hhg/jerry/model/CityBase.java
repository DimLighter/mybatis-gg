package com.hhg.jerry.model;

/**
 * Created by lining on 2018/6/14.
 */
public class CityBase {
    private Long id;
    private String name;

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

    @Override
    public String toString(){
        return "City{" +
                "id=" + id +
                ", name=" + name +
                 '}';
    }
}
