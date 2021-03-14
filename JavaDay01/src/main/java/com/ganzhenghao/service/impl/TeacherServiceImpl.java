package com.ganzhenghao.service.impl;

import com.ganzhenghao.dao.TeacherDao;
import com.ganzhenghao.domain.Teacher;
import com.ganzhenghao.service.TeacherService;


import java.util.List;

/**
 * @ClassName TecherServiceImpl
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/2 16:48
 * @Version 1.0
 */
public class TeacherServiceImpl implements TeacherService {
    TeacherDao dao = new TeacherDao();

    @Override
    public boolean addTeacher(Teacher stu) {
        //2.将返回的boolean类型结果, 返还给TeacherController
        return dao.addTeacher(stu);
    }

    @Override
    public  List<Teacher> findAllTeachers() {
        return dao.findAllTeachers();
    }

    @Override
    public int isExists(String id) {
        int index = -1;
        List<Teacher> allTeachers = dao.findAllTeachers();
        for (int i = 0; i < allTeachers.size(); i++) {
            if (allTeachers.get(i).getId().equals(id)) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public boolean deleteTeacher(int index) {
        return dao.deleteTeacher(index);
    }

    @Override
    public boolean updateTeacher( Teacher student) {

        return dao.updateTeacher(student);
    }
    
    
}
