package com.ganzhenghao.controller;

import com.ganzhenghao.domain.Student;
import com.ganzhenghao.service.StudentService;
import com.ganzhenghao.service.impl.StudentServiceImpl;

import java.util.List;
import java.util.Scanner;

/**
 * @ClassName BaseStudentController
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/3 14:48
 * @Version 1.0
 */
public class BaseStudentController {

    final StudentService studentService = new StudentServiceImpl();

    public void start() {
        Scanner sc = new Scanner(System.in);
        lo:
        while (true) {
            System.out.println("--------欢迎来到 <学生> 管理系统--------");
            System.out.println("请输入您的选择: 1.添加学生  2.删除学生  3.修改学生  4.查看学生  5.退出");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("添加学生");
                    addStudent();
                    break;
                case "2":
                    System.out.println("删除学生");
                    deleteStudent();
                    break;
                case "3":
                    System.out.println("修改学生");
                    updateStudent();
                    break;
                case "4":
                    System.out.println("查看学生");
                    findAllStudents();
                    break;
                default:
                    System.out.println("感谢你的使用,即将退出系统.....");
                    break lo;
            }


        }
    }

    public void updateStudent() {
        boolean flag = studentService.updateStudent( inputInfo(false));
        if (flag){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }

    private Student inputInfo(boolean flag) {
        // 1. 键盘接收学生信息
        Scanner sc = new Scanner(System.in);
        String id;
        while (true) {
            System.out.println("请输入学生id:");
            id = sc.next();
            if (!flag){ if (studentService.isExists(id) != -1) {
                break;
            } else {
                System.out.println("id不存在,请重新输入");
            }}else{
                if (studentService.isExists(id) == -1) {
                    break;
                } else {
                    System.out.println("id已经存在,请重新输入");
                }
            }

        }
        System.out.println("请输入学生姓名:");
        String name = sc.next();
        System.out.println("请输入学生年龄:");
        String age = sc.next();
        System.out.println("请输入学生生日:");
        String birthday = sc.next();
        // 2. 将学生信息封装为学生对象
        Student stu = new Student();
        stu.setId(id);
        stu.setName(name);
        stu.setAge(age);
        stu.setBirthday(birthday);
        return stu;
    }

    public void addStudent() {

        boolean result = studentService.addStudent(inputInfo(true));
        //4. 根据返回的boolean类型结果，在控制台打印成功/失败
        if (result) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }


    }

    public void findAllStudents() {

        List<Student> list = studentService.findAllStudents();
        if (list.size() == 0) {
            System.out.println("无数据,请先添加数据");
        }
        System.out.println("学号\t\t姓名\t年龄\t生日");
        for (Student stu : list) {
            System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t\t" + stu.getBirthday());
        }
    }

    public void deleteStudent() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入学生id");
            String id = scanner.nextLine();
            int index = studentService.isExists(id);
            if (index == -1) {
                System.out.println("Id不存在,请重新输入");
            } else {
                boolean flag = studentService.deleteStudent(index);
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
