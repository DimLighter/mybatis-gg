package com.hhg.jerry.typehandler;

import com.hhg.jerry.enums.Continent;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lina on 2018/7/16.
 */
@MappedJdbcTypes(JdbcType.CHAR)
public class ContinentTypeHandler extends BaseTypeHandler<Continent>{

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Continent parameter, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public Continent getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String s = rs.getString(columnName);
        if(StringUtils.isNotBlank(s)){
            s = StringUtils.deleteWhitespace(s);
        }
        return s == null ? null : Continent.valueOf(s);
    }

    @Override
    public Continent getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public Continent getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
