package com.greatlearning.gradedlab6.studentService;

import java.util.List;

import com.greatlearning.gradedlab6.entity.Student;

public interface StudentService {
	
	public List<Student> getAllStudents();
	
	public Student saveStudent(Student student);
	
	public Student getStudentById(int id);
	
	public Student updateStudent(int id, Student student);
	
	public void deleteStudentById(int id);
}
