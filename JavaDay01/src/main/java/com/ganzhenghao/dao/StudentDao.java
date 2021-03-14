package com.ganzhenghao.dao;

import com.ganzhenghao.domain.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName StudentDao
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/1 16:40
 * @Version 1.0
 */
public class StudentDao {

    private static final List<Student> STUDENT_LIST = new ArrayList<>();

    static {
        STUDENT_LIST.add(new Student("heima001", "ganzhenghao", "23", "1998-04-24"));
        STUDENT_LIST.add(new Student("heima002", "zhangsan", "24", "1997-04-24"));
    }


    public boolean addStudent(Student stu) {
        return STUDENT_LIST.add(stu);
    }

    public List<Student> findAllStudents() {
        return STUDENT_LIST;
    }

    public boolean deleteStudent(int index) {
        Student remove = STUDENT_LIST.remove(index);
        return remove != null;
    }


    public boolean updateStudent(Student student) {
        for (int i = 0; i < STUDENT_LIST.size(); i++) {
            if (STUDENT_LIST.get(i).getId().equals(student.getId())) {
                STUDENT_LIST.set(i, student);
                return true;
            }
        }
        return false;
    }
}
