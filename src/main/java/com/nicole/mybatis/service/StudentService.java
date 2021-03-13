package com.nicole.mybatis.service;

import com.nicole.mybatis.entity.Student;

import java.util.List;

public interface StudentService {

    /**
     * 获取到 Student 的总数
     * @return
     */
    int getTotal();

    /**
     * 增加一条数据
     * @param student
     */
    long addStudent(Student student);

    /**
     * 删除一条数据
     * @param id
     */
    void deleteStudent(long id);

    /**
     * 更新一条数据
     * @param id
     */
    void updateStudentById(long id);

    /**
     * 找到一条数据
     * @param id
     * @return
     */
    Student getStudent(long id);

    /**
     * 找到一条数据
     * @param name
     * @return
     */
    List<Student> getStudentByName(String name);

    /**
     * 列举出从 start 位置开始的 count 条数据
     * @param start
     * @param count
     * @return
     */
    List<Student> list(int start, int count);

    void updateStudent(Student student);
}
