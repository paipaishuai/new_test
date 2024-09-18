package org.example.student.mapper;

import org.example.student.po.Student;

import java.util.List;

public interface StudentMapper1 {
    Student selectStudentBySno(String sno);
    List<Student> selectStudentBySname(String sname);
    Integer insertStudent(Student student);
    Integer deleteStudent(String sno);
    Integer updateStudent(Student student);

}



