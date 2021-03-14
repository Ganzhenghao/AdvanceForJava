package com.ganzhenghao;

import com.ganzhenghao.controller.StudentController;
import com.ganzhenghao.controller.TeacherController;

import java.util.Scanner;

/**
 * @ClassName InfoManagerEntry
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/2 8:44
 * @Version 1.0
 */
public class InfoManagerEntry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("--------欢迎来到黑马信息管理系统--------");
            System.out.println("请输入您的选择: 1.学生管理  2.老师管理  3.退出");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    new StudentController().start();
                    break;
                case "2":
                    new TeacherController().start();
                    break;
                case "3":
                    System.out.println("感谢你的使用,即将退出系统.....");
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入有误,请重新输入!");
                    break;
            }
        }
    }
}
