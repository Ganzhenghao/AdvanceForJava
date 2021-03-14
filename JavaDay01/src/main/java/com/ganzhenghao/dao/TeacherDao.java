package com.ganzhenghao.dao;

import com.ganzhenghao.domain.Teacher;


import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TeacherDao
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/2 16:47
 * @Version 1.0
 */
public class TeacherDao {

    private static final List<Teacher> TEACHER_LIST = new ArrayList<>();

    public boolean addTeacher(Teacher stu) {
        return TEACHER_LIST.add(stu);
    }

    public  List<Teacher> findAllTeachers() {
        return TEACHER_LIST;
    }

    public boolean deleteTeacher(int index) {
        Teacher remove = TEACHER_LIST.remove(index);
        return remove != null;
    }


    public boolean updateTeacher( Teacher teacher) {

        for (int i = 0; i < TEACHER_LIST.size(); i++) {
            if (TEACHER_LIST.get(i).getId().equals(teacher.getId())){
                TEACHER_LIST.set(i, teacher);
                return true;
            }
        }
        return false;

    }
}
