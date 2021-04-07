import com.nicole.mybatis.dao.StudentDao;
import com.nicole.mybatis.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;

import java.io.IOException;
import java.io.InputStream;

public class StudentMainTest {

    public static void main(String[] args) {
        //读取配置文件
        String resource="mybatis-config.xml";
        InputStream is = null;
        SqlSession session = null;
        try{
            is = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

            //true为自动提交事物  false手动提交事物 事物提交方法session.commit();
            session = factory.openSession(false);
//            session.close();
            StudentDao studentDao = (StudentDao) session.getMapper(StudentDao.class);
            StudentMainTest studentMainTest = new StudentMainTest();
            studentMainTest.mainTestGetStudent( studentDao );
            studentMainTest.mainTestAddStudent( studentDao );
            studentMainTest.mainTestDeleteStudent(studentDao);
            studentMainTest.mainTestUpdateStudent(studentDao);

        }catch (IOException e){
            e.printStackTrace();
            System.out.println("!!!!!!!!!!!!!!111");
        }catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("!!!!!!!!!!!!!!222");
        }catch ( Exception e ){
            System.out.println("!!!!!!!!!!!!!!333");
            e.printStackTrace();
            System.out.println("!!!!!!!!!!!!!!333");
        }
        finally {
            session.close();
        }

    }

    public void mainTestGetStudent( StudentDao studentDao ) {
        Student student = studentDao.getStudent(2L);
        System.out.println("MainGet() test. id :  "+student.getId()+";  name :  "+student.getName());
    }

    public long mainTestAddStudent( StudentDao studentDao ) {
        Student student = new Student();
        student.setStudentId("5671D");
        student.setName("BrandNew");
        student.setId(6L);
        long time = System.currentTimeMillis();
        student.setCreateAt(time);
        student.setUpdateAt(time);
        long addedRows = studentDao.addStudent(student);
        System.out.println("MainAdd() return added rows: " + addedRows );
        Student getStudent = studentDao.getStudent(6L);
        System.out.println("MainAdd() test. id :  "+ getStudent.getId()+";  " +
                "name :  "+ getStudent.getName());
        return student.getId();
    }

    public boolean mainTestDeleteStudent(StudentDao studentDao) {
        long id = 3L;
        int bol = studentDao.deleteStudentBol(id);
        Student getStudent = studentDao.getStudent(3L);
        System.out.println("null student original: " + getStudent);
        System.out.println("mainTestDeleteStudent: " + bol);
        if( bol <=0 ) {
            return false;
        }
        return true;
    }

    public boolean mainTestUpdateStudent(StudentDao studentDao) {
        long id = 4L;
        int bol = studentDao.updateStudentByIdBol(id);
        Student getStudent = studentDao.getStudent(4L);
        System.out.println("changedQQ original: " + getStudent.getQqNumber());
        System.out.println("mainTestUpdateStudent: " + bol);
        if( bol <=0 ) {
            return false;
        }
        return true;
    }
}
