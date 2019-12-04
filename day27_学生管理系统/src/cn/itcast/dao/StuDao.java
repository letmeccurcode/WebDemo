package cn.itcast.dao;

import cn.itcast.domain.Student;
import cn.itcast.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StuDao {

    JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());

    public List<Student> findAllStu() {
        String sql = "select * from stu";
        List<Student> list = jt.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
        return list;
    }

    public void addStudent(Student s) {
        String sql = "insert into stu values(null,?,?,?,?,?,?)";
        jt.update(sql, s.getSname(), s.getSex(), s.getAge(), s.getAddress(), s.getQq(), s.getBirth());
    }
}
