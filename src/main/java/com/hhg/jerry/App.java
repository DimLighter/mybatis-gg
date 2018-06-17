package com.hhg.jerry;

import com.hhg.jerry.dao.CityDao;
import com.hhg.jerry.model.City;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws Exception{
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        City city = null;
        CityDao cityDao = sqlSession.getMapper(CityDao.class);
        city = cityDao.getById(1L);
//        city = sqlSession.selectOne("com.hhg.jerry.dao.CityDao.getById",1L);
        System.out.println(city);
    }
}
