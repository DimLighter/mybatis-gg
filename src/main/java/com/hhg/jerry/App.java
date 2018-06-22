package com.hhg.jerry;

import com.hhg.jerry.dao.CityDao;
import com.hhg.jerry.dao.CountryDao;
import com.hhg.jerry.model.City;
import com.hhg.jerry.model.Country;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App {
    private static Log log = LogFactory.getLog(App.class);
    public static void main( String[] args ) throws Exception{
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        queryTest(sqlSession);
        insertTest(sqlSession);
        updateTest(sqlSession);
        log.debug("App exit");
    }

    private static void queryTest(SqlSession sqlSession){
        queryCityTest(sqlSession.getMapper(CityDao.class));
        City city = sqlSession.selectOne("com.hhg.jerry.dao.CityDao.getById",1L);

        queryCountryTest(sqlSession.getMapper(CountryDao.class));
    }

    private static void queryCityTest(CityDao cityDao){
        City city = cityDao.getById(1L);
        city = cityDao.getByNameAndCountryCode("Shanghai","CHN");
        log.debug(city.toString());

        List<City> citiesLikeName = cityDao.getByName("zhou");
        List<City> sqlInjected = cityDao.getByName("zzz' or name like '%jin");

        Map<String, Object> mapCity = cityDao.getCityAsMapById(1L);
        List<City> cities= cityDao.getListLTId(10L);
        cities= cityDao.getListCDATALtId(10L);
        List<City> cities2= cityDao.getListBetweenIds(10L,20L,"ID");
        Map<Long, City> mappedByIdCities = cityDao.getCityMappedById(10L);
        log.debug("queryCityTest exit");
    }

    private static void queryCountryTest(CountryDao countryDao){
        Country country = countryDao.getByCode("BGD");
        log.debug(country.toString());
    }

    private static void insertTest(SqlSession sqlSession){
        insertAndDeleteCityTest(sqlSession.getMapper(CityDao.class));
    }

    private static void insertAndDeleteCityTest(CityDao cityDao){
        City city = buildCity();
        if(cityDao.insert(city)){
            log.debug(city.toString());
            log.debug("delete count:" + cityDao.delete(city.getId()));
        }else{
            log.debug("insertAndDeleteCityTest insert failed");
        }
    }

    private static void updateTest(SqlSession sqlSession){
        CityDao cityDao = sqlSession.getMapper(CityDao.class);
        City city = cityDao.getById(1L);
        Long oldPopulation = city.getPopulation();
        Long newPopulation = new Long(new Random().nextInt(10000));
        if(newPopulation.equals(oldPopulation)){
            newPopulation++;
        }
        city.setPopulation(newPopulation);
        cityDao.update(city);
        city = cityDao.getById(1L);
        log.debug("updateTest oldPopulation:" + oldPopulation + " newPopulation:" + city.getPopulation());
    }

    private static City buildCity(){
        City city = new City();
        city.setName("demoCity");
        city.setCountryCode("AAA");
        city.setDistrict("UnKnow-District");
        city.setPopulation(new Long(new Random().nextInt(10000)));
        return city;
    }
}
