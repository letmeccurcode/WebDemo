package cn.itcast.dao;

import cn.itcast.domain.Administrator;
import cn.itcast.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class AdminDao {

    JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
    //根据用户名和密码来做查询
    public Administrator findAdminByNameAndPswd(Administrator a){
        //书写sql语句
        try {
            String sql = "select * from administrator where username = ? and password = ?";
            Administrator result = jt.queryForObject(sql, new BeanPropertyRowMapper<Administrator>(Administrator.class), a.getUsername(), a.getPassword());
            return result;
        } catch (DataAccessException e) {
//            e.printStackTrace();
            return null;
        }
    }
}
