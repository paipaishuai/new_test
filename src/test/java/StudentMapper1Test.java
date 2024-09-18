import org.example.student.po.Student;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.student.mapper.StudentMapper1;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

import static org.junit.Assert.*;

public class StudentMapper1Test {
    StudentMapper1 mapper =null;
    SqlSession sqlSession =null;
    @Before
    public void setUp() throws Exception {
        Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(StudentMapper1.class);
    }



    @Test
    public void selectStudentBySno() {
        Student student = mapper.selectStudentBySno("100000001");
        System.out.println(student);
    }

    @Test
    public void selectStudentBySname() {
        List<Student> students = mapper.selectStudentBySname("刘");
        for (Student student : students) {
            System.out.println(student);
        }
    }
    // 请补全其他代码，完成对stu表的其他操作
    // ……
    @After
    public void tearDown() throws Exception {
        // 关闭 SqlSession
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
    @Test
    public void  insertStudent(){
        Student student = new Student();
        student.setSno("100000011");
        student.setSname("吴耿越");
        student.setSsex("男");
        student.setSnative("广东汕头");
        student.setMno(3);
        Integer a = mapper.insertStudent(student);
        System.out.println(a);
        sqlSession.commit();

    }


    @Test
    public void deleteStudent(){
        String sno = "100000011";
        Integer i = mapper.deleteStudent(sno);
        System.out.println(i);
        sqlSession.commit();

    }
    @Test
    public void updateStudent(){

        Student student = new Student();
        student.setSname("吴耿越");
        student.setMno(64);
        student.setSsex("男");
        student.setSno("100000009");
        student.setSnative("计科2202");
        mapper.updateStudent(student);
        sqlSession.commit();
    }





}

