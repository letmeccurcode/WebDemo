package cn.itcast.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {

    private Integer id;
    private String sname;
    private String sex;
    private Integer age;
    private String address;
    private String qq;
    private Date birth;

    public Student(String sname, String sex, Integer age, String address, String qq, Date birth) {
        this.sname = sname;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.qq = qq;
        this.birth = birth;
    }

    public Student(Integer id, String sname, String sex, Integer age, String address, String qq, Date birth) {
        this.id = id;
        this.sname = sname;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.qq = qq;
        this.birth = birth;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getBirthStr(){
        return new SimpleDateFormat("yyyy-MM-dd").format(birth);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", qq='" + qq + '\'' +
                ", birth=" + birth +
                '}';
    }
}
