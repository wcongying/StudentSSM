package com.nicole.mybatis.service;

import com.nicole.mybatis.dao.StudentDao;
import com.nicole.mybatis.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * StudentService 的实现类
 *
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    public int getTotal() {
        return studentDao.getTotal();
    }

    public long addStudent(Student student) {
        long stuId = studentDao.addStudent(student);
        return stuId;
    }

    public void addStudent2(Student student) {
        studentDao.addStudent2( student );
    }

    public void deleteStudent(long id) {
        studentDao.deleteStudent(id);
    }

    public void updateStudentById(long id) {
        studentDao.updateStudentById(id);
    }

    public void updateStudent(Student student){
        studentDao.updateStudent( student );
    }

    public Student getStudent(long id) {
        return studentDao.getStudent(id);
    }

    public List<Student> getStudentByName(String name){
        return studentDao.getStudentByName(name);
    }

    public List<Student> list(int start, int count) {
        return studentDao.list(start, count);
    }
}
