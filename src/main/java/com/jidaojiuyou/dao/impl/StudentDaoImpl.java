package com.jidaojiuyou.dao.impl;

import com.jidaojiuyou.dao.StudentDao;
import com.jidaojiuyou.pojo.Student;
import com.jidaojiuyou.utils.JdbcUtils;

import java.util.List;

/**
 * @author : jidaojiuyou
 * @version : 1.0
 * @date : 2020-08-08
 * @description : 实现studentDao
 */
public class StudentDaoImpl implements StudentDao {

    /**
     * 查询信息
     * @return List<Student> 学生集合
     */
    @Override
    public List<Student> selectAll() {
        String sql = "Select sno,name,sex,age,grade from student";
        return JdbcUtils.select(sql);
    }

    /**
     * 查询一条信息
     * @param sno 学号
     * @return Student 学生类
     */
    @Override
    public Student selectById(String sno) throws IndexOutOfBoundsException {
        String sql = "Select sno,name,sex,age,grade from student where sno = '"+sno+"'";
        return JdbcUtils.select(sql).get(0);
    }

    /**
     * 增加信息
     * @param student 学生类
     */
    @Override
    public void insert(Student student) {
        String sno = student.getSno();
        String name = student.getName();
        String sex = student.getSex();
        int age = student.getAge();
        int grade = student.getGrade();
        String sql = "insert into student(sno,name,sex,age,grade) values('"+sno+"','"+name+"','"+sex+"','"+age+"','"+grade+"')";
        JdbcUtils.update(sql);
    }

    /**
     * 修改信息
     * @param student 学生类
     */
    @Override
    public void update(Student student) {
        String sno = student.getSno();
        String name = student.getName();
        String sex = student.getSex();
        int age = student.getAge();
        int grade = student.getGrade();
        String sql = "update student set sno = '"+sno+"',name = '"+name+"',sex = '"+sex+"',age = '"+age+"',grade = '"+grade+"' where sno = '"+sno+"'";
        JdbcUtils.update(sql);
    }

    /**
     * 删除信息
     * @param sno 学号
     */
    @Override
    public void delete(String sno) {
        String sql = "delete from student where sno = '"+sno+"'";
        JdbcUtils.update(sql);
    }
}
