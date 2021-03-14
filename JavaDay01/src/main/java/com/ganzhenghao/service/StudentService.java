package com.ganzhenghao.service;

import com.ganzhenghao.domain.Student;

import java.util.List;

/**
 * @ClassName StudentService
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/1 16:40
 * @Version 1.0
 */
public interface StudentService {

    boolean addStudent(Student stu);

    List<Student> findAllStudents();

    int isExists(String id);

    boolean deleteStudent(int index);

    boolean updateStudent(Student student);
}
