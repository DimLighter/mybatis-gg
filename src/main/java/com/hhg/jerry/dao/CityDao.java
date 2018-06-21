package com.hhg.jerry.dao;

import com.hhg.jerry.model.City;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by lining on 2018/6/14.
 */
public interface CityDao {
    City getById(Long id);

    City getByNameAndCountryCode(@Param(value = "name") String name, @Param(value = "cCode") String countryCode);

    List<City> getByName(@Param(value = "name") String name);

    Map<String, Object> getCityAsMapById(Long id);

    List<City> getListLTId(Long maxId);

    List<City> getListCDATALtId(Long maxId);

    List<City> getListBetweenIds(Long minId, Long maxId, String orderByColumn);

    @MapKey(value = "id")
    Map<Long, City> getCityMappedById(Long maxId);

    Boolean insert(City city);

    int update(City city);

    int delete(Long id);
}
