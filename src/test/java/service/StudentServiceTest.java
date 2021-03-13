package service;

import com.nicole.mybatis.entity.Student;
import com.nicole.mybatis.service.StudentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    @Transactional
    @Rollback(true)
    public void testAddStudent() {
        Student student = new Student();
        student.setStudentId("5671D");
        student.setName("BrandNew");
        student.setId(6L);
        long time = System.currentTimeMillis();
        student.setCreateAt(time);
        student.setUpdateAt(time);
        studentService.addStudent(student);
        Student getStudent = studentService.getStudent(6L);
        Assert.assertEquals( "BrandNew", getStudent.getName());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testDeleteStudent() {
        long id = 3L;
        studentService.deleteStudent(id);
        Student getStudent = studentService.getStudent(3L);
        Assert.assertEquals( null, getStudent);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testUpdateStudent() {
        long id = 4L;
        studentService.updateStudentById(id);
        Student getStudent = studentService.getStudent(4L);
        Assert.assertEquals( "changedQQ", getStudent.getQqNumber());
    }

    @Test
    public void testGetStudent() {
        Student getStudent = studentService.getStudent(2L);
        Assert.assertEquals( "tomh", getStudent.getName());
    }

    @Test
    public void testGetStudentByName() {
        List<Student> getStudent = studentService.getStudentByName("tomh");
        System.out.println("There are "+ getStudent.size() + "  students.");
        Assert.assertEquals( "CS", getStudent.get(0).getMajor());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testInsertStudents() {
        Student student = new Student();
        long ids = 20;
        int max = 120;
        long startTime = System.currentTimeMillis();
        student.setCreateAt(startTime);
        student.setUpdateAt(startTime);
        System.out.println(startTime);
        while( ids++ < max ){
            student.setId( ids );
            student.setName( "nnccc" + ids );
            //student.setStudentId("5671D"+ids);
            studentService.addStudent(student);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime);
        System.out.println( (endTime - startTime) / 1000 );
    }
    
}
