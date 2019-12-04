package cn.itcast.dao;

import cn.itcast.domain.Student;
import cn.itcast.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StuDao {

    JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查询所有的学生信息
     * @return List集合 存放了所有的学生对象
     */
    public List<Student> findAllStu() {
        String sql = "select * from stu";
        List<Student> list = jt.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
        return list;
    }

    /**
     * 添加学生记录
     * @param s 学生对象
     */
    public void addStudent(Student s) {
        String sql = "insert into stu values(null,?,?,?,?,?,?)";
        jt.update(sql, s.getSname(), s.getSex(), s.getAge(), s.getAddress(), s.getQq(), s.getBirth());
    }

    /**
     * @param iid 所要删除的学生的id
     */
    public void deletestuByID(int iid) {
        String sql = "delete from stu where id = ?";
        jt.update(sql,iid);
    }
}
