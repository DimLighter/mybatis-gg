package com.hhg.jerry.dao;

import com.hhg.jerry.model.*;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by lining on 2018/6/14.
 */
public interface CityDao {
    City getById(Long id);

    List<CityBase> discriminatorSelect();

    CityCountry getCityCountryById1(Long id);
    CityCountry getCityCountryById2(Long id);
    CityCountryNearBy getCityCountryById3(Long id);

    CityCountry getCityNestSelectById(Long id);

    CountryCity getCountryCityResultMap(String code);

    Country getCountryByCode(String code);

    CountryCity getCountryByCode1(String code);
    CountryCity getCountryByCode2(String code);

    List<City> getCityByCode(String code);

    City getByNameAndCountryCode(@Param(value = "name") String name, @Param(value = "cCode") String countryCode);

    List<CityConstructor> getByName(@Param(value = "name") String name);

    Map<String, Object> getCityAsMapById(Long id);

    List<City> getListCDATALtId(Long maxId);

    List<City> getListBetweenIds(Long minId, Long maxId, String orderByColumn);

    @MapKey(value = "id")
    Map<Long, City> getCityMappedById(Long maxId);

    Boolean insert(City city);

    int update(City city);

    int delete(Long id);

    List<City> getCityIf(@Param(value = "countryCode")String countryCode, @Param(value = "district")String district);

    List<City> getCityIfLike(@Param(value = "countryCode")String countryCode, @Param(value = "district")String district);

    List<City> getCityChoose(City city);

    List<City> getCityWhere(City city);

    List<City> getCityTrim(City city);

    int updateSet(City city);

    int updateTrim(City city);

    List<City> getCityForEachList(List<Long> ids);
    List<City> getCityForEachArray(Long[] ids);
    List<City> getCityForEachSet(Set<Long> ids);
    List<City> getCityForEachMap(@Param(value = "ids") Map<Long,Long> ids);

    int insertBatch(List<City> cities);
}
