package com.nicole.mybatis.dao;

import com.nicole.mybatis.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentDao {
//    @Results(id = "student", value = {
//            @Result(property = "id", column = "id", id = true),
//            @Result(property = "createAt", column = "create_at"),
//            @Result(property = "updateAt", column = "update_at"),
//            @Result(property = "name", column = "name"),
//            @Result(property = "qqNumber", column = "qq_number"),
//            @Result(property = "major", column = "major"),
//            @Result(property = "estimatedTimeEnrollment", column = "estimated_time_enrollment"),
//            @Result(property = "school", column = "school"),
//            @Result(property = "studentId", column = "student_id"),
//            @Result(property = "logLink", column = "log_link"),
//            @Result(property = "mentor", column = "mentor"),
//            @Result(property = "wishes", column = "wishes"),
//            @Result(property = "recommendedFrom", column = "recommended_from")
//    })

    int getTotal();

    @Insert("INSERT INTO student (id,create_at,update_at,name) VALUES(#{id},#{createAt},#{updateAt},#{name})")
    long addStudent(Student student);

    void deleteStudent(long id);
    @Delete("DELETE FROM student WHERE id = #{id}")
    int deleteStudentBol(long id);

    @Update("UPDATE student SET qq_number='changedQQ' where id = #{id}")
    void updateStudentById(long id);
    @Update("UPDATE student SET qq_number='changedQQ' where id = #{id}")
    int updateStudentByIdBol(long id);
    void updateStudent(Student student);

    Student getStudent(long id);

    @ResultMap("student")
    //@Select("SELECT * FROM student WHERE name LIKE #{name}")
    @Select("SELECT * FROM student WHERE name LIKE '%${name}%'")
    List<Student> getStudentByName( String name);

    List<Student> list(int start, int count);
}
