package com.jidaojiuyou.main;

import com.jidaojiuyou.utils.InputUtils;
import com.jidaojiuyou.utils.JdbcUtils;

/**
 * @author : jidaojiuyou
 * @version : 1.1
 * @date : 2020-08-08
 */
public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        while (true) {
            System.out.println("╭───────────────────────────╮");
            System.out.println("│\t\t\t\t\t\t\t│");
            System.out.println("│\t欢迎使用学生信息管理系统\t│");
            System.out.println("│\t\t\t\t\t\t\t│");
            System.out.println("│\t\t1、添加学生信息\t\t│");
            System.out.println("│\t\t2、修改学生信息\t\t│");
            System.out.println("│\t\t3、查询学生信息\t\t│");
            System.out.println("│\t\t4、删除学生信息\t\t│");
            System.out.println("│\t\t5、退出\t\t\t\t│");
            System.out.println("│\t\t请输入你的选择:\t\t│");
            System.out.println("╰───────────────────────────╯");

            int choice = InputUtils.inputInt();
            switch(choice){
                case 1: Menu.insert();break;
                case 2: Menu.update();break;
                case 3: Menu.query();break;
                case 4: Menu.delete();break;
                case 5: exit();break;
                default:{
                    System.out.println("╭───────────────────────────╮");
                    System.out.println("│\t你的输入有误，请重新输入!\t│");
                    System.out.println("╰───────────────────────────╯");
                    System.out.println();
                    break;
                }
            }
        }
    }
    public static void exit(){
        System.out.println("╭───────────────────────────╮");
        System.out.println("│\t\t你已经退出系统！\t\t│");
        System.out.println("╰───────────────────────────╯");
        InputUtils.close();
        System.exit(-1);
    }
}
