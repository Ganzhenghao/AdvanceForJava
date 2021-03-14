package com.ganzhenghao.service.impl;

import com.ganzhenghao.dao.StudentDao;
import com.ganzhenghao.domain.Student;
import com.ganzhenghao.service.StudentService;


import java.util.List;

/**
 * @ClassName StudentServiceImpl
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/1 16:41
 * @Version 1.0
 */
public class StudentServiceImpl implements StudentService {

     StudentDao studentDao = new StudentDao();

    @Override
    public boolean addStudent(Student stu) {
        //2.将返回的boolean类型结果, 返还给StudentController
        return studentDao.addStudent(stu);
    }

    @Override
    public  List<Student> findAllStudents() {
        return studentDao.findAllStudents();
    }

    @Override
    public int isExists(String id) {
        int index = -1;
        List<Student> allStudents = studentDao.findAllStudents();
        for (int i = 0; i < allStudents.size(); i++) {
            if (allStudents.get(i).getId().equals(id)) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public boolean deleteStudent(int index) {
        return studentDao.deleteStudent(index);
    }

    @Override
    public boolean updateStudent( Student student) {

        return studentDao.updateStudent(student);
    }
}
