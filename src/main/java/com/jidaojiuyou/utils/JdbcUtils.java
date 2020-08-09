package com.jidaojiuyou.utils;

import com.jidaojiuyou.pojo.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : jidaojiuyou
 * @version : 1.0
 * @date : 2020-08-07
 * @description : 自定义数据库工具类
 */
public class JdbcUtils {
//    创建相关连接参数

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static Connection conn = null;
    private static Statement stat = null;
    private static ResultSet rs = null;

//    使用静态代码块类自动载入驱动
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

//    获取连接对象
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

//    增删改
    public static void update(String sql){
        try {
            conn = getConnection();
            stat = conn.createStatement();
            stat.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
                close(stat,conn);
        }
    }

//    查
    public static List<Student> select(String sql){
        List<Student> list = new ArrayList<>();
        try {
            conn = getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()){
                String sno = rs.getString("sno");
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                int age = rs.getInt("age");
                int grade = rs.getInt("grade");
               list.add(new Student(sno,name,sex,age,grade));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close(stat,conn,rs);
        }
        return list;
    }

    private static void close(Statement stat,Connection conn) {
        try {
            if(stat != null) {
                stat.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void close(Statement stat,Connection conn,ResultSet rs) {
        try {
            if(rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(stat,conn);
    }
}
