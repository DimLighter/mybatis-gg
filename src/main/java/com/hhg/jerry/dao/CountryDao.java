package com.hhg.jerry.dao;

import com.hhg.jerry.enums.Continent;
import com.hhg.jerry.model.Country;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cache.decorators.LruCache;
import org.apache.ibatis.cache.impl.PerpetualCache;

import java.util.List;

/**
 * Created by lining on 2018/6/22.
 */

@CacheNamespace(implementation = PerpetualCache.class, eviction = LruCache.class,
flushInterval = 60000, size = 2048, readWrite = false, blocking = true)
public interface CountryDao {
    @Select("select * from country where Code = #{code,javaType=string,jdbcType=CHAR}")
    Country getByCode(String code);

//    @Select("select * from country where IndepYear between #{fromYear} and #{toYear}")
//    List<Country> getByIndependentYear(Integer fromYear, Integer toYear);
//
//    @Select("select * from country where Continent = #{continent}")
//    List<Country> getByContinent(Continent continent);
}
