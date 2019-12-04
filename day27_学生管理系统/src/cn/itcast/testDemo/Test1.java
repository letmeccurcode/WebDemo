package cn.itcast.testDemo;

import cn.itcast.dao.StuDao;
import cn.itcast.domain.Student;

import java.util.List;

public class Test1 {

    @org.junit.Test
    public void m1(){
        StuDao dao = new StuDao();
        List<Student> list = dao.findAllStu();
        System.out.println(list);
    }
}
