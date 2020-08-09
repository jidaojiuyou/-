package com.jidaojiuyou.dao;

import com.jidaojiuyou.pojo.Student;

import java.util.List;

/**
 * @author : jidaojiuyou
 * @version : 1.0
 * @date : 2020-08-08
 * @description : studentDao的接口
 */
public interface StudentDao {
    /**
     * 查询信息
     * @return List<Student> 学生集合
     */
    List<Student> selectAll();

    /**
     * 查询一条信息
     * @param sno 学号
     * @return Student 学生类
     */
    Student selectById(String sno);

    /**
     * 增加信息
     * @param student 学生类
     */
    void insert(Student student);

    /**
     * 修改信息
     * @param student 学生类
     */
    void update(Student student);

    /**
     * 删除信息
     * @param sno 学号
     */
    void delete(String sno);
}
