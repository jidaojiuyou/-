package com.jidaojiuyou.pojo;

/**
 * @author : jidaojiuyou
 * @version : 1.0
 * @date : 2020-08-08 09:09
 * @description :
 */
public class Student {
    private String sno;
    private String name;
    private String sex;
    private int age;
    private int grade;

    public Student() {
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Student(String sno, String name, String sex, int age, int grade) {
        this.sno = sno;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.grade = grade;
    }
}
