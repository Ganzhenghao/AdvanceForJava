package com.ganzhenghao.service;

import com.ganzhenghao.domain.Teacher;


import java.util.List;

/**
 * @ClassName TeacherService
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/2 16:50
 * @Version 1.0
 */
public interface TeacherService {
    boolean addTeacher(Teacher stu);

     List<Teacher> findAllTeachers();

    int isExists(String id);

    boolean deleteTeacher(int index);

    boolean updateTeacher(Teacher student);
}
