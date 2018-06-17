package com.hhg.jerry;

import java.sql.*;

/**
 * Created by lina on 2018/6/17.
 */
public class JdbcTest {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/world?useUnicode=true&characterEncoding=utf8&useSSL=false",
                "root","root");
        PreparedStatement statement = connection.prepareStatement("select * from city where id < ?");
        statement.setInt(1,5);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            Long id = resultSet.getLong("ID");
            String name = resultSet.getString("Name");
            String countryCode = resultSet.getString("CountryCode");
            String district = resultSet.getString("District");
            Long population = resultSet.getLong("Population");

            System.out.println("id:"+id + " name:"+name+" countryCode:"+countryCode+
                    " district:"+district + " population:"+population);
        }
    }
}
