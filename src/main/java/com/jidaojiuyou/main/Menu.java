package com.jidaojiuyou.main;

import com.jidaojiuyou.dao.StudentDao;
import com.jidaojiuyou.dao.impl.StudentDaoImpl;
import com.jidaojiuyou.pojo.Student;
import com.jidaojiuyou.utils.InputUtils;

import java.util.List;

/**
 * @author : jidaojiuyou
 * @version : 1.0
 * @date : 2020-08-09
 * @description : 菜单类
 */
public class Menu {
    static StudentDao dao = new StudentDaoImpl();

    /**
     * 查询信息
     */
    public static void query(){
        System.out.println("╭───────────────────────────╮");
        System.out.println("│\t\t正在查询学生信息\t\t│");
        System.out.println("╰───────────────────────────╯");
        while(true){
            List<Student> list = dao.selectAll();
            System.out.println("╭───────────────────────────╮");
            System.out.printf("│%4s\t%4s\t%s\t%s\t%s\t│\n","学号","姓名","性别","年龄","年级");
///            System.out.println("│\t学号\t姓名\t\t性别\t年龄\t年级\t│");
            System.out.println("├───────────────────────────┤");
            for (Student stu : list) {
                System.out.printf("│%4s\t%4s\t%s\t%3d\t%2d\t│\n",stu.getSno(),stu.getName(),stu.getSex(),stu.getAge(),stu.getGrade());
            }
            System.out.println("╰───────────────────────────╯");
            System.out.println();
            System.out.println("╭───────────────────────────╮");
            System.out.println("│\t\t请输入0返回上一级\t\t│");
            System.out.println("╰───────────────────────────╯");
            int i = InputUtils.inputInt();
            if(i == 0){
                Main.menu();
                return;
            }
        }
    }

    /**
     * 添加学生
     */
    public static void insert(){
        while (true) {
            System.out.println("╭───────────────────────────╮");
            System.out.println("│\t\t正在准备添加学生信息\t│");
            System.out.println("╰───────────────────────────╯");
            System.out.println();
            System.out.println("╭───────────────────────────╮");
            System.out.println("│\t\t请输入学号:\t\t\t│");
            System.out.println("╰───────────────────────────╯");
            String sno = InputUtils.inputString();
            System.out.println("╭───────────────────────────╮");
            System.out.println("│\t\t请输入姓名:\t\t\t│");
            System.out.println("╰───────────────────────────╯");
            String name = InputUtils.inputString();
            System.out.println("╭───────────────────────────╮");
            System.out.println("│\t\t请输入性别:\t\t\t│");
            System.out.println("╰───────────────────────────╯");
            String sex = InputUtils.inputString();
            System.out.println("╭───────────────────────────╮");
            System.out.println("│\t\t请输入年龄:\t\t\t│");
            System.out.println("╰───────────────────────────╯");
            int age = InputUtils.inputInt();
            System.out.println("╭───────────────────────────╮");
            System.out.println("│\t\t请输入年级:\t\t\t│");
            System.out.println("╰───────────────────────────╯");
            int grade = InputUtils.inputInt();
            Student student = new Student(sno, name, sex, age, grade);
            dao.insert(student);
            System.out.println("╭───────────────────────────╮");
            System.out.println("│\t\t学生添加完成！\t\t\t│");
            System.out.println("╰───────────────────────────╯");
            System.out.println("╭───────────────────────────╮");
            System.out.println("│\t\t请输入0返回上一级\t\t│");
            System.out.println("╰───────────────────────────╯");
            int i = InputUtils.inputInt();
            if(i == 0){
                Main.menu();
                return;
            }
        }
    }

    /**
     * 删除
     */
    public static void delete(){
        while(true){
            System.out.println("╭───────────────────────────╮");
            System.out.println("│\t\t正在准备删除学生信息\t│");
            System.out.println("╰───────────────────────────╯");
            System.out.println("╭───────────────────────────╮");
            System.out.println("│\t\t请输入学生学号：\t\t│");
            System.out.println("│\t\t输入0将返回上一级\t\t│");
            System.out.println("╰───────────────────────────╯");
            String sno = InputUtils.inputString();
            if(0 == Integer.parseInt(sno)){
                Main.menu();
                return;
            }
            Student stu;

            try {
                stu = dao.selectById(sno);
            }catch (Exception e) {
                System.out.println("╭───────────────────────────╮");
                System.out.println("│\t\t学号输入有误！\t\t\t│");
                System.out.println("╰───────────────────────────╯");
                continue;
            }
            System.out.println("╭───────────────────────────╮");
            System.out.printf("│%4s\t%4s\t%s\t%s\t%s\t│\n","学号","姓名","性别","年龄","年级");
            System.out.println("├───────────────────────────┤");
            System.out.printf("│%4s\t%4s\t%s\t%3d\t%2d\t│\n",stu.getSno(),stu.getName(),stu.getSex(),stu.getAge(),stu.getGrade());
            System.out.println("╰───────────────────────────╯");
            System.out.println();
            System.out.println("╭───────────────────────────╮");
            System.out.println("│\t\t确认删除(Y/N)?\t\t│");
            System.out.println("╰───────────────────────────╯");
            String choice = InputUtils.inputString();
            if ("Y".equals(choice)||"y".equals(choice)){
                dao.delete(sno);
                System.out.println("╭───────────────────────────╮");
                System.out.println("│\t\t学生删除完成！\t\t\t│");
                System.out.println("╰───────────────────────────╯");
            }
        }
    }

    /**
     * 修改学生信息
     */

    public static void update(){
        while(true) {
            System.out.println("╭───────────────────────────╮");
            System.out.println("│\t\t正在准备修改学生信息\t│");
            System.out.println("╰───────────────────────────╯");
            System.out.println("╭───────────────────────────╮");
            System.out.println("│\t\t请输入学生学号：\t\t│");
            System.out.println("│\t\t输入0将返回上一级\t\t│");
            System.out.println("╰───────────────────────────╯");
            String sno = InputUtils.inputString();
            if (0 == Integer.parseInt(sno)) {
                Main.menu();
                return;
            }
            Student stu;

            try {
                stu = dao.selectById(sno);
            } catch (Exception e) {
                System.out.println("╭───────────────────────────╮");
                System.out.println("│\t\t学号输入有误！\t\t\t│");
                System.out.println("╰───────────────────────────╯");
                continue;
            }
            System.out.println("╭───────────────────────────╮");
            System.out.printf("│%4s\t%4s\t%s\t%s\t%s\t│\n", "学号", "姓名", "性别", "年龄", "年级");
            System.out.println("├───────────────────────────┤");
            System.out.printf("│%4s\t%4s\t%s\t%3d\t%2d\t│\n", stu.getSno(), stu.getName(), stu.getSex(), stu.getAge(), stu.getGrade());
            System.out.println("╰───────────────────────────╯");
            System.out.println();
            System.out.println("╭───────────────────────────╮");
            System.out.println("│\t\t请输入修改字段：\t\t│");
            System.out.println("│\t\t输入0将返回上一级\t\t│");
            System.out.println("╰───────────────────────────╯");
            String column = InputUtils.inputString();
            switch (column){
                case "0": {
                    Main.menu();
                    return;
                }
                case "学号": {
                    System.out.println("╭───────────────────────────╮");
                    System.out.println("│\t\t学号不支持修改!\t\t│");
                    System.out.println("╰───────────────────────────╯");
                    break;
                }
                case "姓名": {
                    System.out.println("╭───────────────────────────╮");
                    System.out.println("│\t\t请输入新的姓名:\t\t│");
                    System.out.println("╰───────────────────────────╯");
                    String name = InputUtils.inputString();
                    stu.setName(name);
                    dao.update(stu);
                    System.out.println("╭───────────────────────────╮");
                    System.out.println("│\t\t学生修改完成！\t\t\t│");
                    System.out.println("╰───────────────────────────╯");
                    break;
                }
                case "性别": {
                    System.out.println("╭───────────────────────────╮");
                    System.out.println("│\t\t请输入新的性别:\t\t│");
                    System.out.println("╰───────────────────────────╯");
                    String sex = InputUtils.inputString();
                    stu.setSex(sex);
                    dao.update(stu);
                    System.out.println("╭───────────────────────────╮");
                    System.out.println("│\t\t学生修改完成！\t\t\t│");
                    System.out.println("╰───────────────────────────╯");
                    break;
                }
                case "年龄": {
                    System.out.println("╭───────────────────────────╮");
                    System.out.println("│\t\t请输入新的年龄:\t\t│");
                    System.out.println("╰───────────────────────────╯");
                    int age = InputUtils.inputInt();
                    stu.setAge(age);
                    dao.update(stu);
                    System.out.println("╭───────────────────────────╮");
                    System.out.println("│\t\t学生修改完成！\t\t\t│");
                    System.out.println("╰───────────────────────────╯");
                    break;
                }
                case "年级": {
                    System.out.println("╭───────────────────────────╮");
                    System.out.println("│\t\t请输入新的年级:\t\t│");
                    System.out.println("╰───────────────────────────╯");
                    int grade = InputUtils.inputInt();
                    stu.setGrade(grade);
                    dao.update(stu);
                    System.out.println("╭───────────────────────────╮");
                    System.out.println("│\t\t学生修改完成！\t\t\t│");
                    System.out.println("╰───────────────────────────╯");
                    break;
                }
                default:{
                    System.out.println("╭───────────────────────────╮");
                    System.out.println("│\t\t你的输入有误！\t\t│");
                    System.out.println("╰───────────────────────────╯");
                }
            }
        }
    }
}
