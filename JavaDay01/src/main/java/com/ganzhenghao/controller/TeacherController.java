package com.ganzhenghao.controller;

import com.ganzhenghao.domain.Teacher;
import com.ganzhenghao.service.TeacherService;
import com.ganzhenghao.service.impl.TeacherServiceImpl;


import java.util.List;
import java.util.Scanner;

/**
 * @ClassName TeacherController
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/2 16:47
 * @Version 1.0
 */
public class TeacherController {
    TeacherService ts = new TeacherServiceImpl();


    public void start() {
        Scanner sc = new Scanner(System.in);
        lo:
        while (true) {
            System.out.println("--------欢迎来到 <老师> 管理系统--------");
            System.out.println("请输入您的选择: 1.添加老师  2.删除老师  3.修改老师  4.查看老师  5.退出");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("添加老师");
                    addTeacher();
                    break;
                case "2":
                    System.out.println("删除老师");
                    deleteTeacher();
                    break;
                case "3":
                    System.out.println("修改老师");
                    updateTeacher();
                    break;
                case "4":
                    System.out.println("查看老师");
                    findAllTeachers();
                    break;
                default:
                    System.out.println("感谢你的使用,即将退出系统.....");
                    break lo;
            }


        }
    }

    public void updateTeacher() {
        boolean flag = ts.updateTeacher( inputInfo(false));
        if (flag){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }

    private  Teacher inputInfo(boolean flag) {
        // 1. 键盘接收老师信息
        Scanner sc = new Scanner(System.in);
        String id;
        while (true) {
            System.out.println("请输入老师id:");
            id = sc.next();
            if (!flag){ if (ts.isExists(id) != -1) {
                break;
            } else {
                System.out.println("id不存在,请重新输入");
            }}else{
                if (ts.isExists(id) == -1) {
                    break;
                } else {
                    System.out.println("id已经存在,请重新输入");
                }
            }

        }
        System.out.println("请输入老师姓名:");
        String name = sc.next();
        System.out.println("请输入老师年龄:");
        String age = sc.next();
        System.out.println("请输入老师生日:");
        String birthday = sc.next();
        // 2. 将老师信息封装为老师对象
        Teacher stu = new Teacher();
        stu.setId(id);
        stu.setName(name);
        stu.setAge(age);
        stu.setBirthday(birthday);
        return stu;
    }

    public void addTeacher() {

        boolean result = ts.addTeacher(inputInfo(true));
        //4. 根据返回的boolean类型结果，在控制台打印成功/失败
        if (result) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }


    }

    public void findAllTeachers() {

        List<Teacher> list = ts.findAllTeachers();
        if (list.size() == 0) {
            System.out.println("无数据,请先添加数据");
        }
        System.out.println("学号\t\t姓名\t年龄\t生日");
        for (Teacher stu : list) {
            System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t\t" + stu.getBirthday());
        }
    }

    public void deleteTeacher() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入老师id");
            String id = scanner.nextLine();
            int index = ts.isExists(id);
            if (index == -1) {
                System.out.println("Id不存在,请重新输入");
            } else {
                boolean flag = ts.deleteTeacher(index);
                if (flag) {
                    System.out.println("删除成功");
                } else {
                    System.out.println("系统异常,删除失败");
                }
                break;
            }
        }

    }
}
