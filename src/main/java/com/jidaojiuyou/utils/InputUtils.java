package com.jidaojiuyou.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author : jidaojiuyou
 * @version : 1.0
 * @date : 2020-08-08
 * @description : 输入工具类
 */
public class InputUtils {
    static Scanner sc = new Scanner(System.in);

    public static int inputInt(){
            return sc.nextInt();
    }

    public static String inputString(){
        return sc.next();
    }

    public static void close(){
        sc.close();
    }
}
