package com.hhg.jerry.model;

/**
 * Created by lining on 2018/6/14.
 */
public class City {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "City ::: id=" + id;
    }
}
